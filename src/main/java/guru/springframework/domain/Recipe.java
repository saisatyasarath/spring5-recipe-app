package guru.springframework.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.*;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	public String description;
	public Integer prepTime;
	public Integer cookTime;
	public Integer servings;
	public String source;
	public String url;
	
	@Lob
	public String directions;
	
	//private Difficulty difficuty;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	
	@Lob
	private Byte[] image;
	
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	@ManyToMany
	@JoinTable(name = "recipe_category",joinColumns = @JoinColumn(name = "recipe_id"),inverseJoinColumns = @JoinColumn(name="catrgory_id"))
	private Set<Category> categories = new HashSet<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public Integer getPrepTime() {
		return prepTime;
	}
	public Integer getCookTime() {
		return cookTime;
	}
	public Integer getServings() {
		return servings;
	}
	public String getSource() {
		return source;
	}
	public String getUrl() {
		return url;
	}
	public String getDirections() {
		return directions;
	}
	public Byte[] getImage() {
		return image;
	}
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
	}
	public Recipe addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
		return this;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
//	public void setNotes(Notes notes) {
//		this.notes = notes;
//	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> catogeries) {
		this.categories = categories;//catogeries;
	}
	
	
	
	
	

}
