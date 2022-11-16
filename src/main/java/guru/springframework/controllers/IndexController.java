package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;

@Controller
public class IndexController {
	
private final RecipeService recipeService;
	
	

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}



	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("recipes", recipeService.getRecipies());
		
		return "index";
	}

}
