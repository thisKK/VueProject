package com.cpe.backend.repository;

import com.cpe.backend.entity.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FoodImageRepository extends JpaRepository<FoodImage, Long> {
    FoodImage findById(long id);
}