package com.contract.management.system.service.constract;

import com.contract.management.system.dao.collateral.CollateralDao;
import com.contract.management.system.dao.contract.ContractCollateralDao;
import com.contract.management.system.dao.contract.ContractDao;
import com.contract.management.system.dao.contract.ContractProductDao;
import com.contract.management.system.dao.product.ProductDao;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.contract.ContractMapper;
import com.contract.management.system.model.contract.dto.ContractAddDto;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import com.contract.management.system.model.contract.entity.ContractEntity;
import com.contract.management.system.model.contract.entity.ContractProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService
{
    private final ContractDao constractDao;
    private final ContractProductDao contractProductDao;
    private final ContractCollateralDao contractCollateralDao;
    private final ProductDao productDao;
    private final CollateralDao collateralDao;

    @Override
    public ContractDto addContract(ContractAddDto dto)
    {
        ContractEntity entity = ContractMapper.INSTANCE.toAddEntity(dto);
        List<CollateralEntity> collateralEntities = collateralDao.findByIdIn(dto.getCollateralIds());
        setConstractInfo(entity, collateralEntities);
        ContractEntity contract = constractDao.save(entity);

        ContractProductEntity contractProductEntity = ContractMapper.INSTANCE.toAddProductEntity(productDao.findById(dto.getProductId()));
        contractProductEntity.setContract(contract);
        ContractProductEntity contractProduct = contractProductDao.save(contractProductEntity);

        List<ContractCollateralEntity> contractCollateralEntities = ContractMapper.INSTANCE.toAddCollateralEntities(collateralEntities);

        for(ContractCollateralEntity contractCollateral : contractCollateralEntities)
        {
            contractCollateral.setContractProduct(contractProduct);
            contractCollateralDao.save(contractCollateral);
        }

        return ContractMapper.INSTANCE.toDto(constractDao.findById(contract.getId()));
    }

    @Override
    public void delete(int id)
    {
        constractDao.deleteById(id);
    }

    @Override
    public ContractDto findById(int id)
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

    private void setConstractInfo(ContractEntity contract, List<CollateralEntity> collaterals)
    {
        int period = contract.getPeriod();
        int startMonth = LocalDate.now().getMonth().getValue();
        contract.setStartMonth(startMonth);
        contract.setEndMonth(startMonth + period);

        /**
         * 납입기간(월) * ((담보 가입금액 / 기준급액) + .... n개 )
         */
        double price = 0;
        for(CollateralEntity collateral: collaterals)
        {
            price = price + (collateral.getInsurableMoney() / collateral.getStandardMoney());
        }

        contract.setTotalMoney(period * price);

    }

}
