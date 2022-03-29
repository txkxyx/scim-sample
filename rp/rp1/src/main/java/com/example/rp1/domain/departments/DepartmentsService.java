package com.example.rp1.domain.departments;

import java.util.List;

import javax.transaction.Transactional;

import com.example.rp1.domain.tenant.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Transactional
    public Departments createAdminDepartment(Tenant tenant) {
        return createDepartment("000", "所属なし", tenant.getId());
    }

    @Transactional
    public Departments createDepartment(String code, String name, Integer tenantId) {
        Departments departments = new Departments();
        departments.setCode(code);
        departments.setName(name);
        departments.setTenantId(tenantId);
        return departmentsRepository.save(departments);
    }

    @Transactional
    public List<Departments> getAllDepartments(Integer tenantId) {
        return departmentsRepository.findByTenantId(tenantId);
    }
}
