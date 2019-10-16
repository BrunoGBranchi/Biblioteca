package br.edu.unoesc.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.crud.Repository.ClienteRepository;
import br.edu.unoesc.crud.Repository.ExemplaresRepository;
import br.edu.unoesc.crud.Repository.LocacaoRepository;

@Controller
@RequestMapping({"/index", "/", ""})
public class IndexController {

	@Autowired
	private ExemplaresRepository exemplatesRepository;
	@Autowired
	private ClienteRepository clientesRepository;
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
    @GetMapping({"/index", "", "/"})
    public String index(Model model){
    	model.addAttribute("exemplares", exemplatesRepository.cincoPrimeiros());
    	model.addAttribute("contaExemplares", exemplatesRepository.count());
    	model.addAttribute("contaLocatarios", clientesRepository.count());
    	model.addAttribute("contalocacao", locacaoRepository.count());

    	return "index/index";
    }

}
