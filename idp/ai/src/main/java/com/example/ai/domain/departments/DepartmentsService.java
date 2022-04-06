package com.example.ai.domain.departments;

import java.util.List;

import com.example.ai.domain.tenant.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsMapper departmentsMapper;

    public Departments createAdminDepartment(Tenant tenant) {
        return createDepartment("000", "所属なし", tenant.getId());
    }

    public Departments createDepartment(String code, String name, Long tenantId) {
        Departments departments = new Departments();
        departments.setCode(code);
        departments.setName(name);
        departments.setTenantId(tenantId);
        departmentsMapper.save(departments);
        return departments;
    }

    public List<Departments> getAllDepartments(Long tenantId) {
        return departmentsMapper.findByTenantId(tenantId);
    }

    public Departments getDepartments(Long id, Long tenantId) {
        return departmentsMapper.findById(id, tenantId);
    }

    public Departments updateDepartments(Long id, String code, String name, Long tenantId) {
        Departments departments = new Departments();
        departments.setId(id);
        departments.setCode(code);
        departments.setName(name);
        departments.setTenantId(tenantId);
        departmentsMapper.update(departments);
        return departments;
    }

    public boolean deleteDepartments(Long id, Long tenantId) {
        return departmentsMapper.delete(id, tenantId);
    }
}
