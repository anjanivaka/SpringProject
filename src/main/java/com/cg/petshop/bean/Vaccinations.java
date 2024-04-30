package com.cg.petshop.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "vaccinations")
public class Vaccinations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccination_id")
    private int vaccinationId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price",columnDefinition = "DECIMAL(10,2)")
    private Double price;

    @Column(name = "available",columnDefinition = "tinyint")
    private int available;

	public int getVaccinationId() {
		return vaccinationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int isAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Vaccinations(int vaccinationId, String name, String description, Double price, int available) {
		super();
		this.vaccinationId = vaccinationId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.available = available;
	}

	public Vaccinations(String name, String description, Double price, int available) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.available = available;
	}

	public Vaccinations() {
		super();
	}

	@Override
	public String toString() {
		return "Vaccinations [vaccinationId=" + vaccinationId + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", available=" + available + "]";
	}

    
}

