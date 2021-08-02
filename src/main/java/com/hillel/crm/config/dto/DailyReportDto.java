package com.hillel.crm.config.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class DailyReportDto {

    private Long id;
    private Date date;
    private String responsiblePerson;
}
