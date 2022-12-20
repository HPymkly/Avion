package com.main.demo.demande.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request_group")
@EntityListeners(AuditingEntityListener.class)
public class GroupDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @CreationTimestamp
    Date date;

    @OneToMany(mappedBy = "id")
    @JsonManagedReference
    List<DetGroupDemande> demandeDetails;

    public void setDemandeDetails(List<DetGroupDemande> liste) {
        this.demandeDetails = liste;
        for (int i = 0; i < liste.size(); i++) {
            this.getDemandeDetails().get(i).setGroupDemande(this);
        }
    }
}
