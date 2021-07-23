package com.hillel.crm.config.dao;

import com.hillel.crm.config.entity.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyReportDao extends JpaRepository<DailyReport, Long> {

}
