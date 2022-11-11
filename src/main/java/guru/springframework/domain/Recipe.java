package guru.springframework.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	public String directions;
	
	//private Difficulty difficuty;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "recipe")
	private Set<Ingredient> ingredients;
	
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	@Lob
	private Byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	
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
	public void setNotes(Notes notes) {
		this.notes = notes;
	}
	
	

}
