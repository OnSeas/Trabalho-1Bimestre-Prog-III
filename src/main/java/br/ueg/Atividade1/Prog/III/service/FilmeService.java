package br.ueg.Atividade1.Prog.III.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.ueg.Atividade1.Prog.III.model.Filme;
import br.ueg.Atividade1.Prog.III.repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public Filme inserir(Filme filme) {
		boolean existeTitulo = filmeRepository.existeTitulo(filme.getTitulo());
		
		if(existeTitulo) {
			throw new IllegalStateException("Um filme com o título: " + filme.getTitulo() + "já existe!");
		}
		
		return filmeRepository.save(filme);
	}
	
	public Filme getFilme(String titulo) {
		this.verificarSeExiste(titulo);
		Filme filme = obterFilme(titulo);
		return filme;
	}
	
	public List<Filme> listarTudo(){
		return filmeRepository.findAll();
	}
	
	public List<Filme> getByDiretor(String diretor){
		List<Filme> filmes = filmeRepository.findByDiretor(diretor);
		if(CollectionUtils.isEmpty(filmes)) {
			throw new IllegalAccessError("Não há filmes do diretor "+diretor+" no sistema");
		}
		return filmes;
	}
	
	public Filme remover(String titulo) {
		verificarSeExiste(titulo);
		Filme filme = obterFilme(titulo);
		filmeRepository.delete(filme);		
		return filme;
	}
	
	public Filme alterar(Filme filme, String titulo) {
		verificarSeExiste(titulo);
		Filme filmeBD = obterFilme(titulo);
		
		if(StringUtils.hasLength(filme.getTitulo())) {
			filmeBD.setTitulo(filme.getTitulo());
		}
		
		if(StringUtils.hasLength(filme.getDiretor())) {
			filmeBD.setDiretor(filme.getDiretor());
		}
		
		if(StringUtils.hasLength(filme.getDataLancamento())) {
			filmeBD.setDataLancamento(filme.getDataLancamento());
		}
		
		if(filme.getDuracao() != null) {
			filmeBD.setDuracao(filme.getDuracao());
		}
		
		filmeBD = filmeRepository.save(filmeBD);
				
		return filmeBD;
	}
	
	// Funções auxiliares
	
	private void verificarSeExiste(String titulo) {
		if(!filmeRepository.existeTitulo(titulo)) {
			throw new IllegalStateException("Não existe um filme com o título " + titulo);
		}
	}
	
	private Filme obterFilme(String titulo){
		return filmeRepository.findByTitulo(titulo);
	}
	
}
