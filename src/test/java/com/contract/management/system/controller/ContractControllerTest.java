package com.contract.management.system.controller;

import com.contract.management.system.constans.ContractStatusType;
import com.contract.management.system.model.contract.dto.ContractDto;
import com.contract.management.system.service.constract.ContractService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContractController.class)
class ContractControllerTest
{
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ContractService contractService;

    @Test
    @DisplayName("CONTRACT-GET")
    public void getContract() throws Exception
    {
        int id = 1;
        given(contractService.findById(id)).willReturn(
                new ContractDto(
                        1,
                        "202206041222",
                        12,
                        6,
                        5,
                        10000,
                        ContractStatusType.NORMAL.getValue(),
                        null
                ));

        mockMvc.perform(get("/contract?id="+id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.code").exists())
                .andExpect(jsonPath("$.period").exists())
                .andExpect(jsonPath("$.startMonth").exists())
                .andExpect(jsonPath("$.endMonth").exists())
                .andExpect(jsonPath("$.totalMoney").exists())
                .andExpect(jsonPath("$.status").exists())
                .andDo(print());

        verify(contractService).findById(id);
    }
}