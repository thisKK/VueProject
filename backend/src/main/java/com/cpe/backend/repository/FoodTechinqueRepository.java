package com.cpe.backend.repository;

import com.cpe.backend.entity.FoodTechinque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FoodTechinqueRepository extends JpaRepository<FoodTechinque, Long> {
    FoodTechinque findById(long id);
}