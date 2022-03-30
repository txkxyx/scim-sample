package com.example.rp1.domain.departments;

import java.util.List;

import com.example.rp1.domain.tenant.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsMapper departmentsMapper;

    public Departments createAdminDepartment(Tenant tenant) {
        return createDepartment("000", "所属なし", tenant.getId());
    }

    public Departments createDepartment(String code, String name, Integer tenantId) {
        Departments departments = new Departments();
        departments.setCode(code);
        departments.setName(name);
        departments.setTenantId(tenantId);
        departmentsMapper.save(departments);
        return departments;
    }

    public List<Departments> getAllDepartments(Integer tenantId) {
        return departmentsMapper.findByTenantId(tenantId);
    }

    public Departments getDepartments(Integer id, Integer tenantId) {
        return departmentsMapper.findById(id, tenantId);
    }

    public Departments updateDepartments(Integer id, String code, String name, Integer tenantId) {
        Departments departments = new Departments();
        departments.setId(id);
        departments.setCode(code);
        departments.setName(name);
        departments.setTenantId(tenantId);
        departmentsMapper.update(departments);
        return departments;
    }
}
