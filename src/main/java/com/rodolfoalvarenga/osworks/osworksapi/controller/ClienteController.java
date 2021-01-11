package com.rodolfoalvarenga.osworks.osworksapi.controller;

import com.rodolfoalvarenga.osworks.osworksapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Rodolfo");
        cliente1.setTelefone("19123456789");
        cliente1.setEmail("rod@test.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Thaís Santos");
        cliente2.setTelefone("19987452000");
        cliente2.setEmail("td@tes.com");

        return Arrays.asList(cliente1, cliente2);
    }

}
