package br.com.apihelloworld.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apihelloworld.ws.model.Cliente;

@RestController
public class ClienteController {

	Map<Integer, Cliente> clientes = new HashMap<>();;
	Integer proximoId = 1;

	// Negocios
	private Cliente cadastrar(Cliente cliente) {

		cliente.setId(proximoId);
		// criar Id
		proximoId++;

		clientes.put(cliente.getId(), cliente);
		return cliente;

	}

	private Collection<Cliente> buscarTodos() {
		return clientes.values();

	}

	// end Points

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
		Collection<Cliente> clientesEncontrados = buscarTodos();
		return new ResponseEntity<>(clientesEncontrados, HttpStatus.OK);
	}
}