package com.contract.management.system.service.constract;

import com.contract.management.system.constans.ContractStatusType;
import com.contract.management.system.dao.contract.ContractDao;
import com.contract.management.system.model.contract.entity.ContractEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
class ContractServiceImplTest
{
    @Mock
    private ContractDao contractDao;

    @Test
    void addContract()
    {
    }

    @Test
    void delete()
    {
    }

    @Test
    void findById()
    {
        int id = 1;
        given(contractDao.findById(id)).willReturn(
                new ContractEntity(
                        1,
                        "202206041222",
                        12,
                        6,
                        5,
                        10000,
                        ContractStatusType.NORMAL.name(),
                        null
                ));

        ContractEntity contractEntity = contractDao.findById(id);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date now = new Date(System.currentTimeMillis());
        String newId = sdf.format(now);

        assertEquals(1, contractEntity.getId());
        assertEquals("202206041222", contractEntity.getCode());
        assertEquals(12, contractEntity.getPeriod());
        assertEquals(6, contractEntity.getStartMonth());
        assertEquals(5, contractEntity.getEndMonth());
        assertEquals(10000, contractEntity.getTotalMoney());
        assertEquals(ContractStatusType.NORMAL.name(), contractEntity.getStatus());
    }

    @Test
    void findByCode()
    {
    }

    @Test
    void findAll()
    {
    }
}