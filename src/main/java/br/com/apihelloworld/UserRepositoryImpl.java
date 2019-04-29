package br.com.apihelloworld;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import br.com.apihelloworld.ws.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private RedisTemplate<String, User> redisTemplate;
	private HashOperations hashOperations;
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }
	@Override
	public void save(User user) {		
		hashOperations.put("USER", user.getId(), user);
		
	}

	
	@Override
	public boolean salvar(User user) {	
		
		String nome = user.getNome();
		String nomeEncontrado = findByName(user.getNome());
		if(!nome.equals(nomeEncontrado)) {
		hashOperations.put("USER", user.getId(), user);
	
		return true;
		}
		else {
		return 	false;
		}
	}

	@Override
	public Map<String,User> findAll() {
		
		return hashOperations.entries("USER" );
	}

	@Override
	public User findById(String id) {

		return (User) hashOperations.get("USER", id);
	}

	@Override
	public String findByName(String nome) {

		return  (String) hashOperations.get("Name", nome);
	}

	@Override
	public void update(User user) {
		
		save(user);
	}

	@Override
	public void delete(String id) {
		
		hashOperations.delete("USER",id);
	}


}
