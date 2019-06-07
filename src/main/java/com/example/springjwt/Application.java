package com.example.springjwt;

import com.example.springjwt.entitie.Users;
import com.example.springjwt.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Optional;


@SpringBootApplication
public class Application implements CommandLineRunner {

	private final UsersRepository repo;

	public Application(UsersRepository repo) {
		this.repo = repo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    //insert
		Users user = new Users();
		user.setUsername("pepe");
		user.setPassword("pepe");
		repo.save(user);

		//find
        Optional<Users> user2 = repo.findByUsername("javier");
        System.out.println(">>>>>>>>>>>>>>> User: "+user2.get().toString());

	}
}

