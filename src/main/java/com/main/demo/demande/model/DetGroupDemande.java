package com.main.demo.demande.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request_group_details")
@EntityListeners(AuditingEntityListener.class)
public class DetGroupDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "request_detailsid")
    DetailDemande detailDemande;

    @ManyToOne
    @JoinColumn(name = "request_groupid", nullable = false, updatable = false)
    @JsonBackReference
    GroupDemande groupDemande;

    public DetGroupDemande(DetailDemande detailDemande, GroupDemande groupDemande) {
        this.setDetailDemande(detailDemande);
        this.setGroupDemande(groupDemande);
    }

}
