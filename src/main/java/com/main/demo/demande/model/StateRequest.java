package com.main.demo.demande.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.main.demo.generic.model.ObjectBdd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "state_request")
@EntityListeners(AuditingEntityListener.class)
public class StateRequest extends ObjectBdd {
    String value;

    public StateRequest(Status status) {
        this.setId(status.getId());
    }

}
