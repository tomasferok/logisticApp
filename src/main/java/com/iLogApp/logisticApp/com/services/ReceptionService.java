package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.Reception;
import com.iLogApp.logisticApp.com.helpers.Ihelpers.IReceptionHelper;
import com.iLogApp.logisticApp.com.repositories.JpaReceptionRepository;
import com.iLogApp.logisticApp.com.services.IService.IReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceptionService implements IReceptionService {
    @Autowired
    JpaReceptionRepository jpaReceptionRepository;
    @Autowired
    IReceptionHelper iReceptionHelper;

    @Override
    public Optional<Page<Reception>> getAll(int numberPage) {
        int pageSize= 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaReceptionRepository.findAll(page));
    }

    @Override
    public Optional<Reception> getById(Long id) {
        if (jpaReceptionRepository.existsById(id)){
            Optional<Reception> receptionFinded = jpaReceptionRepository.findById(id);
          return receptionFinded;
        }
        return Optional.empty();
    }

    @Override
    public Optional<?> deleteById(Long id) {
        if (jpaReceptionRepository.existsById(id)){
            Optional<Reception> receptionDeleted = jpaReceptionRepository.findById(id);
            jpaReceptionRepository.deleteById(id);
            String message = "The reception: " + receptionDeleted.get().getIdRecep() + " has been deleted";
            return Optional.of(message);
        }
        return Optional.empty();
    }

    @Override
    public Optional<?> controlReception(Reception reception) {
        return iReceptionHelper.controlReception(reception);
    }

    @Override
    public Optional<?> save(Reception reception) {

        return iReceptionHelper.saveReceptionProductsInStorage(reception);
    }
}
