package com.web_project.shop.repository;

import com.web_project.shop.model.NewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewModel,Long> {
}