package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.Category;
import com.iLogApp.logisticApp.com.entities.Client;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IClientService {
    Optional<Page<Client>> getAll(int numberPage);
    Optional<Client>getById(Long id);
    Optional<?>deleteById(Long id);
    Optional<Client> save(Client client);
}
