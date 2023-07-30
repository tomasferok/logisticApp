package com.iLogApp.logisticApp.com.services;
import com.iLogApp.logisticApp.com.entities.Client;
import com.iLogApp.logisticApp.com.repositories.JpaClientRepository;
import com.iLogApp.logisticApp.com.services.IService.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    JpaClientRepository jpaClientRepository;

    @Override
    public Optional<Page<Client>> getAll(int numberPage) {
        int pageSize = 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaClientRepository.findAll(page));
    }

    @Override
    public Optional<Client> getById(Long id) {
        if(jpaClientRepository.existsById(id)){
            Optional<Client> clientFinded = jpaClientRepository.findById(id);
            return clientFinded;
        }
        return Optional.empty();
    }


    @Override
    public Optional<?> deleteById(Long id) {
        if(jpaClientRepository.existsById(id)){
            Optional<Client> clientDeleted = jpaClientRepository.findById(id);
            jpaClientRepository.deleteById(id);
            return clientDeleted;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Client> save(Client client) {
        return Optional.of(jpaClientRepository.save(client));
    }
}
