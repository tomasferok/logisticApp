package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.Reception;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IReceptionService {
    Optional<Page<Reception>> getAll(int numberPage);
    Optional<Reception>getById(Long id);
    Optional<?>deleteById(Long id);
    Optional<?>controlReception(Reception reception);
    Optional<?> save(Reception reception);
}
