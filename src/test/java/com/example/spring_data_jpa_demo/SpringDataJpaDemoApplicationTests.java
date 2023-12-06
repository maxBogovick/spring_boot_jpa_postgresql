package com.example.spring_data_jpa_demo;

import com.example.spring_data_jpa_demo.itvdn.core.entity.Company;
import com.example.spring_data_jpa_demo.itvdn.core.service.JobService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaDemoApplicationTests {

  @Autowired
  private JobService jobService;

  @Test
  void test_get_all_job_with_jdbc_success() {
    var result = jobService.getAllJobs();
    Assertions.assertFalse(result.isEmpty());
  }
  @Test
  void test_get_all_job_with_repository_success() {
    var result = jobService.listAllJobs();
    Assertions.assertFalse(result.isEmpty());
  }
  @Test
  void test_find_all_jobs_by_title_success() {
    var result = jobService.findAllJobs(null, "senior");
    Assertions.assertFalse(result.isEmpty());
  }

  @Test
  void test_find_all_jobs_by_title_v2_success() {
    var result = jobService.findAllJobsV2(null, "senior");
    Assertions.assertFalse(result.isEmpty());
  }

}
