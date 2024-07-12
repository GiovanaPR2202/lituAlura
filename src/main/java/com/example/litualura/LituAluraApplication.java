package com.example.litualura;

import com.example.litualura.principal.Principal;
import com.example.litualura.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LituAluraApplication  implements CommandLineRunner {

	@Autowired
	private BooksRepository repository;


	public static void main(String[] args)    {
		SpringApplication.run(LituAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.print();
	}
}
