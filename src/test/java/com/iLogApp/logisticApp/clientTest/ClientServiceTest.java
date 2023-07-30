package com.iLogApp.logisticApp.clientTest;

import com.iLogApp.logisticApp.com.entities.Client;
import com.iLogApp.logisticApp.com.repositories.JpaClientRepository;
import com.iLogApp.logisticApp.com.services.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @Mock
    private JpaClientRepository jpaClientRepositoryMock;

    @InjectMocks
    private ClientService clientService;

    @Before
    public void setup() {
        // Puedes inicializar datos o configurar comportamientos predeterminados aquí si es necesario.
    }

    @Test
    public void testSaveClient() {
        // Datos de prueba
        Client clientToSave = new Client(); // Supongamos que has creado un objeto Client con datos válidos para guardar.

        // Comportamiento del mock
        when(jpaClientRepositoryMock.save(clientToSave)).thenReturn(clientToSave);

        // Llamar al método y realizar la prueba
        Optional<Client> savedClient = clientService.save(clientToSave);

        // Verificar que el método save del repositorio se llamó con el cliente adecuado.
        verify(jpaClientRepositoryMock).save(clientToSave);

        // Verificar que el cliente devuelto es el mismo que el cliente que intentamos guardar.
        assertEquals(clientToSave, savedClient.get());
    }

    // Aquí puedes agregar más pruebas para otros casos, como intentar guardar un cliente nulo, etc.
}

