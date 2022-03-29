package com.example.rp1.domain.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    public Users findByEmail(String email);

    public List<Users> findByTenantId(Integer tenantId);
}
