package br.com.sankhya.knowledgebasefinder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sankhya.knowledgebasefinder.model.RequestDTO;
import br.com.sankhya.knowledgebasefinder.model.ResultDTO;

@Controller
@RequestMapping("/search")
public class KnowledgeBaseFinderController {

	@GetMapping
    public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("requestDTO", new RequestDTO());
		return modelAndView;
    }

	@PostMapping
	public ModelAndView find(@ModelAttribute RequestDTO requestDTO) {
		ModelAndView modelAndView = new ModelAndView("home");

		modelAndView.addObject("hasResult", true);
		modelAndView.addObject("query", requestDTO.getQuery());
		modelAndView.addObject("qtdResult", "2");

		List<ResultDTO> results = new ArrayList<>();

		List<String> tags = new ArrayList<String>();
		tags.add("Manual");
		tags.add("Configurações");
		
		results.add(ResultDTO.builder().tag(tags).title("Portal de Vendas").highlight("Este é o resumo do conteúdo....").build());
		results.add(ResultDTO.builder().tag(tags).title("Portal de Compras").highlight("Este é o resumo do conteúdo....").build());

		modelAndView.addObject("results", results);

		return modelAndView;		
	}
	
}
