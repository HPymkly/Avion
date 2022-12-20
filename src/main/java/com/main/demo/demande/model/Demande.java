package com.main.demo.demande.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.main.demo.generic.model.ObjectBdd;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "purchase_request")
@EntityListeners(AuditingEntityListener.class)
public class Demande extends ObjectBdd {
	@OneToOne
	@JoinColumn(name = "departmentid")
	private Departement dept;
	@OneToMany(mappedBy = "id")
	private List<DetailDemande> detailDemandes;
	@CreationTimestamp
	private Date dateins;
	@OneToOne
	@JoinColumn(name = "state_requestid")
	private StateRequest state_requestid;

	public void setState(Status status) {
		StateRequest st = new StateRequest(status);
		this.setState_requestid(st);
	}

	@Override
	public String toString() {
		String message = "Departement : %s";
		String ans = String.format(message, this.getDept().getName());
		return ans;
	}

	public void loadDetails(Demande d) {
		for (int i = 0; i < this.detailDemandes.size(); i++) {
			this.detailDemandes.get(i).setDemande(d);
		}
	}

	public void setDetailDemandes(List<DetailDemande> detailDemandes) {
		this.detailDemandes = detailDemandes;
		this.loadDetails(this);
	}
}