package br.edu.unoesc.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unoesc.crud.Repository.ClienteRepository;
import br.edu.unoesc.crud.Repository.ExemplaresRepository;
import br.edu.unoesc.crud.Repository.LocacaoRepository;
import br.edu.unoesc.crud.model.Locacao;
import br.edu.unoesc.crud.service.LocacaoService;

@Controller
@RequestMapping("/locacao")
public class LocacaoController {

	@Autowired
	private ExemplaresRepository exemplaresRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private LocacaoService locacaoService;

	// Carregar a pagina de cadastro de locacao e tb carrega os exemplares e
	// usuarios para popular select
	@RequestMapping(path = { "/cadastro", "/", "" })
	public String cadastro(Model model) {
		model.addAttribute("exemplares", exemplaresRepository.findAll());
		model.addAttribute("clientes", clienteRepository.findAll());
		return "locacao/cadastro";
	}

	// Metodo para salvar a locacao, chama esse no botao "salvar" e redireciona pra
	// tela de listagem
	@RequestMapping(path = "/salvar", method = RequestMethod.POST)
	public String salvar(Locacao locacao, Model model) {
		locacaoService.salvar(locacao);
		model.addAttribute("locacao", locacaoRepository.findAll());
		return "locacao/listar";
	}

	// Metodo para excluir o exemplar
	@RequestMapping(path = "/excluir/{id}")
	public String excluir(@PathVariable(value = "id") Long id, Locacao locacao) {
		locacaoService.excluir(id, locacao);
		return "redirect:locacao/listar";
	}

	// Metodo para listar
	@RequestMapping(path = { "/listar" })
	public String mostrar(Model model) {
		model.addAttribute("locacao", locacaoRepository.findAll());
		return "locacao/listar";
	}
	
	@RequestMapping(path = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Optional <Locacao> c = locacaoRepository.findById(id);
		model.addAttribute("locacao", c.get());
		return "locacao/editar";
	}
	
	@RequestMapping(path = "/salvarEditado", method = RequestMethod.POST)
	public String editando(Locacao locacao, Model model) {
		locacaoRepository.saveAndFlush(locacao);
		return "redirect:/locacao/listar";
	}
	
}
