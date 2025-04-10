package com.example.tareaclase3.repository;


import com.example.tareaclase3.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.tareaclase3.entity.JobHistory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {

    @Query("SELECT jh FROM JobHistory jh " +
            "WHERE LOWER(jh.employee.firstName) LIKE %:search% " +
            "OR LOWER(jh.employee.lastName) LIKE %:search% " +
            "OR LOWER(jh.job.jobTitle) LIKE %:search% " +
            "OR LOWER(jh.department.departmentName) LIKE %:search%")
    List<JobHistory> findBySearch(@Param("search") String search);
}
