package com.example.rp2.domain.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    private TenantMapper tenantRepository;

    public Tenant createTenant(String name) {
        Tenant tenant = new Tenant();
        tenant.setName(name);
        tenantRepository.save(tenant);
        return tenant;
    }
}
