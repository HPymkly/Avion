package com.main.demo.demande.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.main.demo.generic.model.ObjectBdd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Produit extends ObjectBdd {
	private String value;

}