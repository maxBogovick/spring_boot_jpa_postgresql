package com.example.spring_data_jpa_demo.itvdn.core.repository;

import com.example.spring_data_jpa_demo.itvdn.core.entity.Company;
import com.example.spring_data_jpa_demo.itvdn.core.entity.JobEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends ListCrudRepository<JobEntity, Long>, JpaSpecificationExecutor<JobEntity> {

  @Query(nativeQuery = true,
      value = "select * from job where " +
          "lower(title) like concat('%', lower(:p_title), '%') and company_name = :#{#p_company.name()}")
  List<JobEntity> findAllByFilter(@Param("p_title") String title, @Param("p_company") Company company, Pageable page);

}
