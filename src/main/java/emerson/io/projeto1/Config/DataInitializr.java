package emerson.io.projeto1.Config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import emerson.io.projeto1.Entity.User;
import emerson.io.projeto1.Repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		List<User> users = userRepository.findAll();
		
		if (users.isEmpty()) {
		
			createUser("Emerson A Cardoso", "maj.almeida@hotmail.com");
			createUser("Teste de inclusão", "teste@teste.com.br");
			createUser("Teste de inclusão 2", "teste2@teste.com.br");
		}
		
		User user = userRepository.findByname("Emerson A Cardoso");
		System.out.println(user.getName());
	}
	
	public void createUser(String name, String email) {
		
		User user = new User (name, email);
		userRepository.save(user);
	}
	
}
