package br.ueg.Atividade1.Prog.III.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.Atividade1.Prog.III.model.Filme;
import br.ueg.Atividade1.Prog.III.service.FilmeService;

@RestController
@RequestMapping(path = "/filme")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;
	
	@GetMapping(path = "{titulo}")
	public Filme getFilme(@PathVariable("titulo") String titulo) {
		return filmeService.getFilme(titulo);
	}
	
	@GetMapping
	public List<Filme> listar(){
		List<Filme> filmes = new ArrayList<Filme>();
		filmes = filmeService.listarTudo();
		return filmes;
	}
	
	@GetMapping(path = "diretor/{diretor}")
	public List<Filme> listarPorDiretor(@PathVariable("diretor") String diretor){
		return filmeService.getByDiretor(diretor);
	}
	
	@PostMapping
	public Filme incluir(@RequestBody Filme filme) {
		return filmeService.inserir(filme);
	}
	
	@DeleteMapping(path = "{titulo}")
	public Filme remover(@PathVariable("titulo") String titulo) {
		return filmeService.remover(titulo);
	}
	
	@PatchMapping( path = "{titulo}")
	public Filme alterar(@RequestBody Filme filme, @PathVariable("titulo") String titulo) {
		return filmeService.alterar(filme, titulo);
	}
}