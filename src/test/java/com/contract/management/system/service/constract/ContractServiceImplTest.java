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
    void findById()
    {
        int id = 1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date now = new Date(System.currentTimeMillis());
        String newId = sdf.format(now);

        given(contractDao.findById(id)).willReturn(
                new ContractEntity(
                        1,
                        newId,
                        "202206",
                        "202206",
                        10000.0,
                        ContractStatusType.NORMAL.name(),
                        null
                ));

        ContractEntity contractEntity = contractDao.findById(id);

        assertEquals(1, contractEntity.getId());
        assertEquals(newId, contractEntity.getCode());
        assertEquals("202206", contractEntity.getStartDate());
        assertEquals("202206", contractEntity.getEndDate());
        assertEquals(10000, contractEntity.getTotalMoney());
        assertEquals(ContractStatusType.NORMAL.name(), contractEntity.getStatus());
    }
}