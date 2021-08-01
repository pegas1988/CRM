package com.hillel.crm.config.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class DailyReportDto {

    private Long id;
    private Date date;
    private String responsiblePerson;
}
