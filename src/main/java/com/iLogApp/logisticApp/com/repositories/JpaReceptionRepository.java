package com.iLogApp.logisticApp.com.repositories;

import com.iLogApp.logisticApp.com.entities.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaReceptionRepository extends JpaRepository<Reception,Long> {
}
