package com.example.rp1.domain.tenant;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Transactional
    public Tenant createTenant(String name) {
        Tenant tenant = new Tenant();
        tenant.setName(name);
        return tenantRepository.save(tenant);
    }
}
