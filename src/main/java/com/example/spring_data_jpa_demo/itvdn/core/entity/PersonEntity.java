package com.example.spring_data_jpa_demo.itvdn.core.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "person", schema = "public", catalog = "itvdn")
@Data
public class PersonEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id", nullable = false)
  private Long id;
  @Basic
  @Column(name = "email", nullable = false, length = 100)
  private String email;
  @Basic
  @Column(name = "first_name", nullable = false, length = 100)
  private String firstName;
  @Basic
  @Column(name = "last_name", nullable = false, length = 100)
  private String lastName;
  @Basic
  @Column(name = "phone_number", nullable = false, length = 100)
  private String phoneNumber;
  @OneToMany(mappedBy = "person")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<JobHistoryEntity> jobHistories;
}
