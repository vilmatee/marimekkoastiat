package com.example.project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	//Luodaan kategorialuokka
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Astia> astiat;
	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Astia> getAstiat() {
		return astiat;
	}

	public void setBooks(List<Astia> astiat) {
		this.astiat = astiat;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + ", astiat=" + astiat + "]";
	}

	public static void deleteById(Long astiaId) {
		// TODO Auto-generated method stub
		
	}
	
}

