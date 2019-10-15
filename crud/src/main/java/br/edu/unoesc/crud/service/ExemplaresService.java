package br.edu.unoesc.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.crud.Repository.ExemplaresRepository;
import br.edu.unoesc.crud.model.Exemplares;

@Service
public class ExemplaresService {
	
	@Autowired
	private ExemplaresRepository ExemplaresRepository;
	
	public void salvar(Exemplares exemplares) {
		ExemplaresRepository.saveAndFlush(exemplares);
	}
	
	public void excluir(Long id, Exemplares exemplares) {
		ExemplaresRepository.deleteById(id);
	}
	
}
