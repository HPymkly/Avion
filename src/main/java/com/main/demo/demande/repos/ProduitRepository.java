package com.main.demo.demande.repos;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.main.demo.demande.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    @Query(value = "select p from product p where p.value LIKE %:name%", nativeQuery = true)
    public List<Produit> findByName(@Param("name") String name);

    public List<Produit> findByValueContains(String value);
}
