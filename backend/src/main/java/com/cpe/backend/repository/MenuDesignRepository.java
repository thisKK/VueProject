package com.cpe.backend.repository;

import com.cpe.backend.entity.MenuDesign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MenuDesignRepository extends JpaRepository<MenuDesign, Long> {
}