package com.hillel.crm.config.service.rest;

import com.hillel.crm.config.dto.DailyReportDto;
import com.hillel.crm.config.entity.DailyReport;

import java.util.List;

public interface DailyReportServiceRest {
    public DailyReport getById(Long id);

    List<DailyReport> findAll();

    DailyReport create(DailyReportDto dailyReportDto);

    public void delete(Long id);

    public void update(Long id, DailyReportDto dailyReportDto);
}
