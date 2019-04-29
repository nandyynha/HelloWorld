package br.com.apihelloworld;

import java.util.Map;


import br.com.apihelloworld.ws.model.User;

public interface UserRepository {
	void save(User user);
	Map<String,User>findAll();
	User findById(String id);
	void update(User user);
	void delete(String id);
	boolean salvar(User user);
	String findByName(String nome);
}
