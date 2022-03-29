package com.example.rp1.domain.departments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {

    public List<Departments> findByTenantId(Integer tenantId);

}
