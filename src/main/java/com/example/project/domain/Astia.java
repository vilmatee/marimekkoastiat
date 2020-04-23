package com.example.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Astia {
	
	//Luodaan luokka astia ja sille sen attribuutit
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String kuosi;
	private String vari;
	private String tilavuus;
	private double hinta;
	private int ostovuosi;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;
	
	public Astia() {}
	
	public Astia(String kuosi, String vari, String tilavuus, double hinta, int ostovuosi, Category category) {
		super();
		this.kuosi = kuosi;
		this.vari = vari;
		this.tilavuus = tilavuus;
		this.hinta = hinta;
		this.ostovuosi = ostovuosi;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKuosi() {
		return kuosi;
	}

	public void setKuosi(String kuosi) {
		this.kuosi = kuosi;
	}

	public String getVari() {
		return vari;
	}

	public void setVari(String vari) {
		this.vari = vari;
	}

	public String getTilavuus() {
		return tilavuus;
	}

	public void setTilavuus(String tilavuus) {
		this.tilavuus = tilavuus;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public int getOstovuosi() {
		return ostovuosi;
	}

	public void setOstovuosi(int ostovuosi) {
		this.ostovuosi = ostovuosi;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Astia [id=" + id + ", kuosi=" + kuosi + ", vari=" + vari + ", tilavuus=" + tilavuus + ", hinta=" + hinta
				+ ", ostovuosi=" + ostovuosi + "]";
	}

	
}


