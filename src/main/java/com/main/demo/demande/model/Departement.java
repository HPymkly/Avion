package com.main.demo.demande.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.main.demo.generic.model.ObjectBdd;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "department")
public class Departement extends ObjectBdd {

	private String name;

	public Departement(String name) {
		this.setName(name);
	}

	@Override
	public String toString() {
		return this.getName() + " : " + this.getId();
	}
}