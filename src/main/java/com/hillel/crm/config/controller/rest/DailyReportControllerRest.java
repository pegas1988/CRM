package com.hillel.crm.config.controller.rest;

import com.hillel.crm.config.dto.DailyReportDto;
import com.hillel.crm.config.entity.DailyReport;
import com.hillel.crm.config.service.impl.DailyReportServiceRestImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/daily-report")
@RequiredArgsConstructor
public class DailyReportControllerRest {
    private final DailyReportServiceRestImpl dailyReportServiceRest;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<DailyReportDto> findById(@PathVariable Long id) {
        final DailyReport dailyReport = dailyReportServiceRest.getById(id);
        DailyReportDto dailyReportDto = new DailyReportDto();
        BeanUtils.copyProperties(dailyReport, dailyReport);
        return new ResponseEntity<>(dailyReportDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DailyReportDto>> findAll() {
        List<DailyReport> dailyReportList = dailyReportServiceRest.findAll();
        List<DailyReportDto> dailyReportDtoList = dailyReportList.stream()
                .map(dailyReport -> {
                    DailyReportDto dailyReportDto = new DailyReportDto();
                    BeanUtils.copyProperties(dailyReport, dailyReport);
                    return dailyReportDto;
                }).collect(Collectors.toList());
        return new ResponseEntity<>(dailyReportDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyReportDto> create(@RequestBody DailyReportDto dailyReportDto) {
        final DailyReport dailyReport = dailyReportServiceRest.create(dailyReportDto);
        dailyReportDto.setId(dailyReport.getId());
        return new ResponseEntity<>(dailyReportDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        dailyReportServiceRest.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody DailyReportDto dailyReportDto) {
        dailyReportServiceRest.update(id, dailyReportDto);
    }
}
