package com.iLogApp.logisticApp.com.repositories;

import com.iLogApp.logisticApp.com.entities.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSupplierRepository extends JpaRepository<Supplier, Long> {
}
