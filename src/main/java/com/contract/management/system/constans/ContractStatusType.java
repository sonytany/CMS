package com.contract.management.system.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContractStatusType
{
    NORMAL("정상상태"),
    CANCEL("청약철회"),
    EXPIRE("기간만료");

    private String value;
}
