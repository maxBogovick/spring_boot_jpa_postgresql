package com.example.spring_data_jpa_demo.itvdn.core.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "job_history", schema = "public", catalog = "itvdn")
@Data
public class JobHistoryEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id", nullable = false)
  private Long id;
  @Basic
  @Column(name = "date_from", nullable = true)
  private LocalDate dateFrom;
  @Basic
  @Column(name = "date_to", nullable = true)
  private LocalDate dateTo;
  @Basic
  @Column(name = "salary", nullable = true)
  private Integer salary;
  @ManyToOne
  @JoinColumn(name = "job_id", referencedColumnName = "id")
  private JobEntity job;
  @ManyToOne
  @JoinColumn(name = "person_id", referencedColumnName = "id")
  private PersonEntity person;
}
