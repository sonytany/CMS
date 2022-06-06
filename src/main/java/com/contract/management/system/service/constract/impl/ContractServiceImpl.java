package com.contract.management.system.service.constract.impl;

import com.contract.management.system.constans.ContractStatusType;
import com.contract.management.system.constans.ExceptionClassType;
import com.contract.management.system.dao.collateral.CollateralDao;
import com.contract.management.system.dao.contract.ContractCollateralDao;
import com.contract.management.system.dao.contract.ContractDao;
import com.contract.management.system.dao.contract.ContractProductDao;
import com.contract.management.system.dao.product.ProductDao;
import com.contract.management.system.exception.BaseException;
import com.contract.management.system.model.collateral.entity.CollateralEntity;
import com.contract.management.system.model.contract.ContractMapper;
import com.contract.management.system.model.contract.dto.*;
import com.contract.management.system.model.contract.entity.ContractCollateralEntity;
import com.contract.management.system.model.contract.entity.ContractEntity;
import com.contract.management.system.model.contract.entity.ContractProductEntity;
import com.contract.management.system.model.product.entiry.ProductEntity;
import com.contract.management.system.service.constract.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService
{
    private final ContractDao contractDao;
    private final ContractProductDao contractProductDao;
    private final ContractCollateralDao contractCollateralDao;
    private final ProductDao productDao;
    private final CollateralDao collateralDao;

    @Override
    public ContractDto findById(long id) throws BaseException
    {
        ContractDto dto = ContractMapper.INSTANCE.toDto(contractDao.findById(id));

        if(dto == null)
            throw new BaseException(ExceptionClassType.CLIENT,HttpStatus.BAD_REQUEST,"존재하지 않은 계약ID 입니다.");

        return dto;
    }

    @Override
    public ContractDto findByCode(String Code) throws BaseException
    {
        ContractDto dto = ContractMapper.INSTANCE.toDto(contractDao.findByCode(Code));

        if(dto == null)
            throw new BaseException(ExceptionClassType.CLIENT,HttpStatus.BAD_REQUEST,"존재하지 않은 계약CODE 입니다.");

        return dto;
    }

    @Transactional
    @Override
    public ContractDto addContract(ContractAddDto dto) throws BaseException
    {
        int period = dto.getPeriod();
        ProductEntity product = productDao.findById(dto.getProductId());
        ContractProductEntity contractProduct = ContractMapper.INSTANCE.toContractProductEntity(product);
        List<CollateralEntity> collaterals = collateralDao.findByIdIn(dto.getCollateralIds());

        if(product == null)
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "상품이 존재하지 않습니다.");
        else if(collaterals == null || collaterals.isEmpty())
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "담보가 존재하지 않습니다.");
        else if(collaterals != null && collaterals.size() > 0)
        {
            for(CollateralEntity collContract : collaterals)
            {
                if(product.getId() != collContract.getProduct().getId())
                    throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "해당 상품의 담보정보가 아닙니다. ");
            }
        }

        List<ContractCollateralEntity> contractCollaterals = ContractMapper.INSTANCE.toAddCollateralEntities(collaterals);
        contractProduct.setPeriod(period);

        ContractEntity saveContract = contractDao.save(
                getContractInfo(period, product.getMinPeriod(), product.getMaxPeriod(),
                        ContractMapper.INSTANCE.toAddEntity(dto),
                        ContractMapper.INSTANCE.toContractCollateralDtosByCollateralEntites(collaterals), false)
        );

        contractProduct.setContract(saveContract);
        ContractProductEntity saveContractProduct = contractProductDao.save(contractProduct);
        saveContract.setContractProduct(saveContractProduct);

        for(ContractCollateralEntity contractCollateral : contractCollaterals)
        {
            contractCollateral.setContractProduct(saveContractProduct);
            contractCollateralDao.save(contractCollateral);
        }

        saveContractProduct.setContractCollaterals(contractCollaterals);

        return ContractMapper.INSTANCE.toDto(contractDao.findById(saveContract.getId()));
    }

    @Transactional
    @Override
    public ContractDto updateContract(ContractUpdateDto dto) throws BaseException
    {
        for(Long id : dto.getDeleteContractCollateralIds())
            contractCollateralDao.deleteById(id);

        int period = dto.getPeriod();

        ContractEntity contract = contractDao.findById(dto.getContractId());

        if(ContractStatusType.EXPIRE == ContractStatusType.valueOf(contract.getStatus()))
           throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "만료상태의 계약을 변경할 수 없습니다.");

        contract.setStatus(ContractStatusType.valueOf(dto.getStatusCode()).name());
        ContractProductEntity contractProduct = contract.getContractProduct();
        contractProduct.setPeriod(period);

        List<ContractCollateralEntity> contractCollaterals = contractCollateralDao.findByContractProductId(contractProduct.getId());
        contractProduct.setContractCollaterals(contractCollaterals);
        long contractProductId = contractProduct.getId();

        ProductEntity product = productDao.findById(contractProductId);
        List<ContractCollateralDto> contractCollateralDtos = new ArrayList<>();

        for(ContractCollateralEntity contractCollateral : contractCollaterals)
            contractCollateralDtos.add(ContractMapper.INSTANCE.toContractCollateralDto(contractCollateral));

        for(CollateralEntity collateral : collateralDao.findByIdIn(dto.getAddCollateralIds()))
        {
            if(contractProductId == collateral.getProduct().getId())
            {
                contractCollaterals.add(ContractMapper.INSTANCE.toContractCollateralEntity(collateral));
                contractCollateralDtos.add(ContractMapper.INSTANCE.toContractCollateralDtoByCollateralEntity(collateral));
            }
        }

        if(contractCollaterals.size() == 0)
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "담보는 최소1개를 가지고 있어야 합니다.");

        ContractEntity saveContract = contractDao.save(getContractInfo(period, product.getMinPeriod(), product.getMaxPeriod(), contract, contractCollateralDtos, true));

        for(ContractCollateralEntity contractCollateral : contractCollaterals)
        {
            contractCollateral.setContractProduct(contractProduct);
            contractCollateralDao.save(contractCollateral);
        }

        contractProduct.setContract(saveContract);
        ContractProductEntity saveContractProduct = contractProductDao.save(contractProduct);

        saveContract.setContractProduct(saveContractProduct);
        saveContractProduct.setContractCollaterals(contractCollaterals);

        return ContractMapper.INSTANCE.toDto(contractDao.findById(saveContract.getId()));
    }

    public ContractTempDto findTotalPrice(ContractAddDto dto) throws BaseException
    {
        int period = dto.getPeriod();
        ProductEntity product = productDao.findById(dto.getProductId());
        ContractProductEntity contractProduct = ContractMapper.INSTANCE.toContractProductEntity(product);
        List<CollateralEntity> collaterals = collateralDao.findByIdIn(dto.getCollateralIds());

        if(product == null)
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "상품이 존재하지 않습니다.");
        else if(collaterals == null || collaterals.isEmpty())
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "담보가 존재하지 않습니다.");
        else if(collaterals != null && collaterals.size() > 0)
        {
            for(CollateralEntity collContract : collaterals)
            {
                if(product.getId() != collContract.getProduct().getId())
                    throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "해당 상품의 담보정보가 아닙니다. ");
            }
        }

        ContractEntity tempContract = getContractInfo(period, product.getMinPeriod(), product.getMaxPeriod(),
                ContractMapper.INSTANCE.toAddEntity(dto),
                ContractMapper.INSTANCE.toContractCollateralDtosByCollateralEntites(collaterals), false);

        ContractTempDto.ContractTempDtoBuilder dtoBuilder = ContractTempDto.builder();
        dtoBuilder.totalMoney(tempContract.getTotalMoney()).startDate(tempContract.getStartDate()).endDate(tempContract.getEndDate());


        return dtoBuilder.build();
    }


    private ContractEntity getContractInfo(int period, int minPeriod, int maxPeriod, ContractEntity contract, List<ContractCollateralDto> contractCollateralDtos, boolean isUpdate) throws BaseException
    {
        LocalDate localDate = LocalDate.now();

        if(isUpdate)
        {
            String date = contract.getStartDate();
            localDate = LocalDate.of(Integer.parseInt(date.substring(0,4)),Integer.parseInt(date.substring(4,6)),Integer.parseInt(date.substring(6,8)));
        }

        if(!(minPeriod <= period) || !(period <= maxPeriod))
            throw new BaseException(ExceptionClassType.CONTRACT, HttpStatus.BAD_REQUEST, "해당 상품의 기간계간 범위내에서 선택해 주세요. ("+minPeriod+" ~ "+maxPeriod+" 개월) ");
        else
        {
            double price = 0;
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd");

            String startDate = localDate.format(pattern);
            String endDate = localDate.plusMonths(period).format(pattern);
            contract.setStartDate(startDate);
            contract.setEndDate(endDate);

            for(ContractCollateralDto contractCollateralDto : contractCollateralDtos)
                price = price + ((double) contractCollateralDto.getInsurableMoney() / (double) contractCollateralDto.getStandardMoney());

            contract.setTotalMoney(Math.floor((period * price)*100)/100.0);
        }

        return contract;
    }
}
