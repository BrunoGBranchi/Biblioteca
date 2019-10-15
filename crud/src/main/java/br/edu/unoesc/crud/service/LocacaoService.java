package br.edu.unoesc.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.crud.Repository.LocacaoRepository;
import br.edu.unoesc.crud.model.Locacao;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;

	public void salvar(Locacao locacao) {
		locacaoRepository.saveAndFlush(locacao);
	}

	public void excluir(Long id, Locacao locacao) {
		locacaoRepository.deleteById(id);
	}

}
