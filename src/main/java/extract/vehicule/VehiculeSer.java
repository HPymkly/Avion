package extract.vehicule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class VehiculeSer {
    @Autowired
    VehiculeRepos vehiculeRepos;

    public void delete(Integer id) {
        Vehicule v = new Vehicule();
        v.setId(id);
        this.delete(v);
    }

    public void delete(Vehicule v) {
        this.getVehiculeRepos().delete(v);
    }

    public Vehicule getById(Integer id) {
        return this.getVehiculeRepos().findById(id).get();
    }

    public List<Vehicule> list() {
        return this.getVehiculeRepos().findAll();
    }

    public void create(Vehicule vehicule) {
        this.getVehiculeRepos().save(vehicule);
    }
}
