package com.iLogApp.logisticApp.com.repositories;

import com.iLogApp.logisticApp.com.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClientRepository extends JpaRepository<Client, Long> {
}
