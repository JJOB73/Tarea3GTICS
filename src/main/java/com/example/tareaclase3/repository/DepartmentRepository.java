package com.example.tareaclase3.repository;

import com.example.tareaclase3.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tareaclase3.entity.Department;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Buscar ciudades y países con más de 3 empleados por departamento
    @Query(value = """
        SELECT d.* FROM departments d
        WHERE (SELECT COUNT(*) FROM employees e WHERE e.department_id = d.department_id) > 3
        """, nativeQuery = true)
    List<Department> findDepartmentsWithMoreThan3Employees();
}

