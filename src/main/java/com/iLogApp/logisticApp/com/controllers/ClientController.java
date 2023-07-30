package com.iLogApp.logisticApp.com.controllers;
import com.iLogApp.logisticApp.com.entities.Client;
import com.iLogApp.logisticApp.com.services.IService.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    IClientService iClientService;

    @GetMapping("/getPage/{numberPage}")
    public Optional<?> getAllClient (@PathVariable int numberPage){
        return iClientService.getAll(numberPage);
    }

    @GetMapping("/{idCategory}")
    public Optional<Client> getClientById(@PathVariable Long idClient){

        return iClientService.getById(idClient);
    }
    @PostMapping
    public Optional<Client> saveClient(@RequestBody Client client){
        return iClientService.save(client);
    }

    @DeleteMapping("/{id}")
    public Optional<?>deleteClientById(@PathVariable Long id){
        return iClientService.deleteById(id);
    }
}
