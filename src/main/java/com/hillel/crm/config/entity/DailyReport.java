package com.hillel.crm.config.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "daily_report")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_report")
    private Date date;

    @Column(name = "responsible_person")
    private String responsiblePerson;
}
