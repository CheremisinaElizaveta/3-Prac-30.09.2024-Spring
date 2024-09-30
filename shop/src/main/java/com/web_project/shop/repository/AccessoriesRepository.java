package com.web_project.shop.repository;

import com.web_project.shop.model.AccessoriesModel;
import com.web_project.shop.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccessoriesRepository extends JpaRepository<AccessoriesModel,Long> {
    Optional<AccessoriesModel> findByName(String name);
}
