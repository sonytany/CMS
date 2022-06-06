package com.contract.management.system.service.constract.impl;

import com.contract.management.system.constans.ExceptionClassType;
import com.contract.management.system.dao.collateral.CollateralDao;
import com.contract.management.system.dao.contract.ContractCollateralDao;
import com.contract.management.system.dao.contract.ContractDao;
import com.contract.management.system.dao.contract.ContractProductDao;
import com.contract.management.system.dao.product.ProductDao;
import com.contract.management.system.exception.BaseException;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.contract.ContractMapper;
import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import com.contract.management.system.model.contract.entity.ContractEntity;
import com.contract.management.system.model.contract.entity.ContractProductEntity;
import com.contract.management.system.model.product.entiry.ProductEntity;
import com.contract.management.system.service.constract.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService
{
    private final ContractDao constractDao;
    private final ContractProductDao contractProductDao;
    private final ContractCollateralDao contractCollateralDao;
    private final ProductDao productDao;
    private final CollateralDao collateralDao;

    @Override
    public ContractDto addContract(ContractAddDto dto) throws BaseException
    {
        ProductEntity product = productDao.findById(dto.getProductId());
        List<CollateralEntity> collaterals = collateralDao.findByIdIn(dto.getCollateralIds());

        ContractEntity contract = getConstractInfo(dto, product, collaterals);
        ContractEntity saveContract = constractDao.save(contract);

        ContractProductEntity contractProduct = ContractMapper.INSTANCE.toAddProductEntity(product);
        contractProduct.setPeriod(dto.getPeriod());
        contractProduct.setContract(saveContract);
        ContractProductEntity saveContractProduct = contractProductDao.save(contractProduct);

        List<ContractCollateralEntity> contractCollaterals = ContractMapper.INSTANCE.toAddCollateralEntities(collaterals);
        for(ContractCollateralEntity contractCollateral : contractCollaterals)
        {
            contractCollateral.setContractProduct(saveContractProduct);
            contractCollateralDao.save(contractCollateral);
        }

        saveContractProduct.setContractCollaterals(contractCollaterals);
        saveContract.setContractProduct(saveContractProduct);

        return ContractMapper.INSTANCE.toDto(constractDao.findById(saveContract.getId()));
    }

    @Override
    public void delete(long id)
    {
        constractDao.deleteById(id);
    }

    @Override
    public ContractDto findById(long id)
    {
        return ContractMapper.INSTANCE.toDto(constractDao.findById(id));
    }

    @Override
    public List<ContractDto> findByCode(String Code)
    {
        return null;
    }

    @Override
    public List<ContractDto> findAll()
    {
        return null;
    }

    private ContractEntity getConstractInfo(ContractAddDto dto, ProductEntity product, List<CollateralEntity> collaterals) throws BaseException
    {
        ContractEntity contract = ContractMapper.INSTANCE.toAddEntity(dto);
        int period = dto.getPeriod();

        if(product == null)
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "상품이 존재하지 않습니다.");
        else if(collaterals == null || collaterals.isEmpty())
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "담보가 존재하지 않습니다.");
        else
        {
            long productId =  product.getId();
            int minPeriod = product.getPeriod();
            int maxPeriod = product.getMaxPeriod();


            if(!(minPeriod <= period) || !(period <= maxPeriod))
                throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "해당 상품의 기간계간 범위내에서 선택해 주세요. ("+minPeriod+" ~ "+maxPeriod+" 개월) ");
            else
            {
                double price = 0;
                DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMM");
                String startDate = LocalDate.now().format(pattern);
                String endDate = LocalDate.now().plusMonths(period).format(pattern);
                contract.setStartDate(startDate);
                contract.setEndDate(endDate);

                for(CollateralEntity collateral: collaterals)
                {
                    if(productId != collateral.getProduct().getId())
                        throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "해당 상품의 담보정보가 아닙니다. ");

                    price = price + ((double) collateral.getInsurableMoney() / (double) collateral.getStandardMoney());
                }

                contract.setTotalMoney(Math.round((period * price)*100)/100.0);
            }
        }

        return contract;
    }

}
