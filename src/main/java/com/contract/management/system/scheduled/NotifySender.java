package com.contract.management.system.scheduled;

import com.contract.management.system.dao.contract.ContractDao;
import com.contract.management.system.model.contract.entity.ContractEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
public class NotifySender
{
    private ContractDao contractDao;

    //    @Scheduled(cron = "01 * * * * *")
    public void send()
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd");
        String endDate = LocalDate.now().format(pattern);

        List<ContractEntity> contractEntities = contractDao.findByEndDateGreaterThan("20220801");

        System.out.println("START :: Before Exprie Notify");

        for(ContractEntity contract : contractEntities)
            System.out.println("CONTRACT CODE :: "+contract.getCode());

        System.out.println("END :: Before Exprie Notify");
    }
}
