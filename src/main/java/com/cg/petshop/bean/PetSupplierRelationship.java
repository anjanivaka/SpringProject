package com.cg.petshop.bean;

import com.cg.petshop.compositekeys.PetSupplierRelationshipId;

import jakarta.persistence.*;

@Entity
@Table(name = "pet_supplier_relationship")
public class PetSupplierRelationship {
	
	@EmbeddedId
	private PetSupplierRelationshipId id;
	
	@ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id",insertable = false, updatable = false)
    private Pets pet;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id",insertable = false, updatable = false)
    private Suppliers supplier;

	public PetSupplierRelationshipId getId() {
		return id;
	}

	public Pets getPet() {
		return pet;
	}

	public Suppliers getSupplier() {
		return supplier;
	}
    
    
    
}