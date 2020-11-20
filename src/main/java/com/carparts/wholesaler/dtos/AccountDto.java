package com.carparts.wholesaler.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AccountDto {

//    public AccountDto(){
//
//    }

    private String email;
    private String password;
    private long nip;

}
