package extract.vehicule.kilometrage;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import extract.vehicule.Vehicule;
import lombok.Data;

@Data
@EntityListeners(EntityListeners.class)
@Entity
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vehiculeid", nullable = false, updatable = false)
    Vehicule vehicule;

    Date date;

    double debut;

    double fin;
}
