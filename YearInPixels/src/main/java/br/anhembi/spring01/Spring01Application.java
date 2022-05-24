package br.anhembi.spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.anhembi.spring01.controller.UserController;

@SpringBootApplication
public class Spring01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);
	}

	@Autowired
	private UserController userController;

	@Override
	public void run(String... args) throws Exception {

		
		// for (int a = 1; a < 30; a++) {
			
		// 	this.userController.saves(a, 2, "data", "texto");
		// }

		for (int i = 1; i <= 365; i++) {
			if (this.userController.findToComplete(i) == true) {
				this.userController.redefinir(i);
			}
		}


	}
}
