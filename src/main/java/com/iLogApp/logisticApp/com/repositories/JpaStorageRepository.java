package com.iLogApp.logisticApp.com.repositories;

import com.iLogApp.logisticApp.com.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStorageRepository extends JpaRepository<Storage, Long> {
}
