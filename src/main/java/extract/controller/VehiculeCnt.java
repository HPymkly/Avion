package extract.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import extract.vehicule.Vehicule;
import extract.vehicule.VehiculeSer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@RestController
@EqualsAndHashCode(callSuper = true)
public class VehiculeCnt extends Cnt {
    @Autowired
    VehiculeSer vehiculeSer;

    @PutMapping("/vehicule/{id}")
    public String update(@PathVariable String id, @RequestBody Vehicule v) {
        try {
            v.setId(Integer.parseInt(id));
            this.getVehiculeSer().create(v);
            return this.getGson().toJson(v);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @DeleteMapping("/vehicule/{id}")
    public String delete(@PathVariable String id) {
        try {
            this.getVehiculeSer().delete(Integer.parseInt(id));
            return "ok";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/vehicule/{id}")
    public String getOne(@PathVariable String id) {
        try {
            Vehicule v = this.getVehiculeSer().getById(Integer.parseInt(id));
            return this.getGson().toJson(v);
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @GetMapping("/vehicule")
    public String getAll() {
        List<Vehicule> ans = this.getVehiculeSer().list();
        return this.getGson().toJson(ans);
    }

    @PostMapping("/vehicule")
    public String create(@RequestBody Vehicule vehicule) {
        this.getVehiculeSer().create(vehicule);
        return "ok";
    }
}
