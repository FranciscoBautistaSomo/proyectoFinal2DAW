package com.retroHIFI.webshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retroHIFI.webshop.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByAuthority(String authority);
}
