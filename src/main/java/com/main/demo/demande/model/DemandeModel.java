package com.main.demo.demande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

import com.main.demo.demande.service.departement.DepartementService;
import com.main.demo.demande.service.produit.ProduitService;

import lombok.Data;

@Data
@ComponentScan(basePackages = { "com.main.demo" })
public class DemandeModel {

	private Departement[] departements;
	private Produit[] produits;

	@Autowired
	@Qualifier("departService")
	DepartementService dpService;

	@Autowired
	@Qualifier("prService1")
	ProduitService prService;

	public DemandeModel() {
	}

	public void init() {
		this.loadDepartements();
		this.loadProduits();
	}

	/**
	 * Set the products from DB
	 */
	public void loadProduits() {
		this.setProduits(this.getPrService().getAll());
	}

	public void loadDepartements() {
		this.setDepartements(this.getDpService().getAll());
	}

}