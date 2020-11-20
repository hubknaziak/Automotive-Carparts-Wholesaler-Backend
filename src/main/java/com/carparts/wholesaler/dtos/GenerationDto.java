package com.carparts.wholesaler.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class GenerationDto {

    private int idGeneration;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date beginDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private String name;
}
