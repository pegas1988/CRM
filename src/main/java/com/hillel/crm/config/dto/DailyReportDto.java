package com.hillel.crm.config.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyReportDto {

    private Long id;
    private Date date;
    private String responsiblePerson;
}
