package com.cpe.backend.repository;

import com.cpe.backend.entity.MenuList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MenuListRepository extends JpaRepository<MenuList, Long> {
    MenuList findById(long id);
}
