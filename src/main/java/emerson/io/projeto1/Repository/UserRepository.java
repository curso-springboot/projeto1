package emerson.io.projeto1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import emerson.io.projeto1.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByname(String name);
}
