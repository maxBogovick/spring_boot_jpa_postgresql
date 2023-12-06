package com.example.spring_data_jpa_demo.itvdn.core.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "job", schema = "public", catalog = "itvdn")
@Data
@NoArgsConstructor
public class JobEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id", nullable = false)
  private Long id;
  @Basic
  @Column(name = "company_name", nullable = false, length = 255)
  @Enumerated(EnumType.STRING)
  private Company company;
  @Basic
  @Column(name = "experience", nullable = true, precision = 0)
  private Double experience;
  @Basic
  @Column(name = "title", nullable = false, length = 500)
  private String title;
  @Basic
  @Column(name = "max_salary", nullable = true)
  private Integer maxSalary;
  @Basic
  @Column(name = "min_salary", nullable = true)
  private Integer minSalary;

  @OneToMany(mappedBy = "job")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private List<JobHistoryEntity> jobHistories;
}
