package com.iLogApp.logisticApp.com.repositories;

import com.iLogApp.logisticApp.com.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category,Long> {
}
