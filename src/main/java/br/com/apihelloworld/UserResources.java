package br.com.apihelloworld;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apihelloworld.ws.model.User;

@RestController
@RequestMapping("/rest/user")

public class UserResources {

	private UserRepository userRepository;

	public UserResources(UserRepository userRepository) {
		this.userRepository = userRepository;
	
	
	}
    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        userRepository.save(new User(id, name));
        return userRepository.findById(id);
    }

    @GetMapping("/salvar/{id}/{name}")
    public String salvar(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
    	
    
    	if(userRepository.salvar(new User())) {
    		
            userRepository.save(new User(id, name));
            return "salvou";
    	}else {
        return "Ja existe";
    	}
    }
	@GetMapping("/update/{id}/{name}")
	public User update(@PathVariable("id") final String id, 
					@PathVariable("name") final String name){
		userRepository.save(new User(id,name));
		return userRepository.findById(id);
	}
	@GetMapping("/all")
	public Map<String, User> all(){
		userRepository.findAll();
		return userRepository.findAll();
	}
    @GetMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") final String id) {
        userRepository.delete(id);
        return all();
    }

		
}
