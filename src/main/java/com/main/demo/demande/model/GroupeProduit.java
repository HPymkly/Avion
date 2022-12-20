package com.main.demo.demande.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vrequest_group")
public class GroupeProduit {
    @Id
    Integer justid;

    @OneToOne
    @JoinColumn(name = "request_groupid")
    GroupDemande groupDemande;

    @OneToOne
    @JoinColumn(name = "productid")
    Produit produit;

    @Column(name = "qtt")
    int quantite;

    String quality;
}
