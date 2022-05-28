package br.ueg.Atividade1.Prog.III;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ueg.Atividade1.Prog.III.model.Filme;
import br.ueg.Atividade1.Prog.III.repository.FilmeRepository;

@SpringBootApplication
public class Atividade1ProgIiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Atividade1ProgIiiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(FilmeRepository filmeRepository) {
		return args -> {
			Filme filme =  new Filme(null, "Jurassic park", "n sei escrever", "13/06/1993", 126);
			filme = filmeRepository.save(filme);
			
			filme =  new Filme(null, "outro", "outro", "23/06/2022", 140);
			filme = filmeRepository.save(filme);
		};
	}
}
