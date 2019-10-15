package br.edu.unoesc.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unoesc.crud.Repository.ExemplaresRepository;
import br.edu.unoesc.crud.model.Exemplares;
import br.edu.unoesc.crud.service.ExemplaresService;

@Controller
@RequestMapping("/exemplares")
public class ExemplaresController {

	@Autowired
	private ExemplaresRepository exemplaresRepository;

	@Autowired
	private ExemplaresService exemplaresService;

	// Carregar a pagina de cadastro de exemplares
	@RequestMapping(path = { "/cadastro", "/", "" })
	public String cadastro() {
		return "exemplares/cadastro";
	}

	// Metodo para listar
	@RequestMapping(path = { "/listar" })
	public String mostrar(Model model) {
		model.addAttribute("exemplares", exemplaresRepository.findAll());
		return "exemplares/listar";
	}

	// Metodo para salvar o exemplar, chama esse no botao "salvar" e redireciona pra
	// tela de listagem
	@RequestMapping(path = "/salvar", method = RequestMethod.POST)
	public String salvar(Exemplares exemplares, Model model) {
		exemplaresService.salvar(exemplares);
		model.addAttribute("exemplares", exemplaresRepository.findAll());
		return "exemplares/listar";
	}

	// Metodo para excluir o exemplar
	@RequestMapping(path = "/excluir/{id}")
	public String excluir(@PathVariable(value = "id") Long id, Exemplares exemplares) {
		exemplaresService.excluir(id, exemplares);
		return "redirect:exemplares/listar";
	}

	@RequestMapping(path = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Optional <Exemplares> c = exemplaresRepository.findById(id);
		model.addAttribute("exemplares", c.get());
		return "exemplares/editar";
	}
	
	@RequestMapping(path = "/salvarEditado", method = RequestMethod.POST)
	public String editando(Exemplares exemplares, Model model) {
		exemplaresRepository.saveAndFlush(exemplares);
		return "redirect:/exemplares/listar";
	}
	
}
