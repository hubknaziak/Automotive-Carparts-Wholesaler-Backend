package com.carparts.wholesaler.dtos;

import com.carparts.wholesaler.models.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientDto {

    //private String type;

    private long nip;

    private String companyName;

    //private String status;

}
