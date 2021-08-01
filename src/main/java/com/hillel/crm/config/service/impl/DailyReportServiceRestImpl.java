package com.hillel.crm.config.service.impl;

import com.hillel.crm.config.dao.DailyReportDao;
import com.hillel.crm.config.dto.DailyReportDto;
import com.hillel.crm.config.entity.DailyReport;
import com.hillel.crm.config.service.rest.DailyReportServiceRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DailyReportServiceRestImpl implements DailyReportServiceRest {

    private final DailyReportDao dailyReportDao;

    @Override
    public DailyReport getById(Long id) {
        DailyReport dailyReport = dailyReportDao.findById(id)
                .orElseThrow(() -> new RuntimeException("не удалось найти DailyReport с id " + id));
        return dailyReport;
    }

    @Override
    public List<DailyReport> findAll() {
        return dailyReportDao.findAll();
    }

    @Override
    @Transactional
    public DailyReport create(DailyReportDto dailyReportDto) {
        if (!Objects.isNull(dailyReportDto.getId())) {
            throw new IllegalArgumentException("Failed to create DailyReport. DailyReport with such ID already exist.");
        }
        DailyReport dailyReport = new DailyReport();
        BeanUtils.copyProperties(dailyReportDto, dailyReport);
        return dailyReportDao.save(dailyReport);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!dailyReportDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete DailyReport. DailyReport with such ID doesnt exist.");
        }
        dailyReportDao.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, DailyReportDto dailyReportDto) {
        if (!dailyReportDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to delete DailyReport. DailyReport with such ID doesnt exist.");
        }
        DailyReport dailyReport = new DailyReport();
        BeanUtils.copyProperties(dailyReportDto, dailyReport);
        dailyReport.setId(id);
        dailyReportDao.save(dailyReport);
    }
}
