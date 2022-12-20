package com.main.demo.demande.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.main.demo.generic.model.ObjectBdd;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "request_details")
public class DetailDemande extends ObjectBdd {

	@ManyToOne
	@JoinColumn(name = "purchase_requestid", nullable = false, updatable = false)
	private Demande demande;
	@OneToOne
	@JoinColumn(name = "productid", nullable = false, updatable = false)
	private Produit produit;
	@Column(name = "qtt")
	private int quantite;
	@Column(name = "quality")
	private String qualite;
	private String designation;

	public DetailDemande(Produit produit, int quantite, String qualite, String designation) {
		this.setProduit(produit);
		this.setQuantite(quantite);
		this.setQualite(qualite);
		this.setDesignation(designation);
	}

}