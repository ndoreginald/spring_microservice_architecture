package org.ms.produitservice.repository;

import org.ms.produitservice.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController 
public interface ProduitRepository extends JpaRepository<Produit,Long> {
	@RestResource (path="/byName")
	Page<Produit> findByNameContains(@Param("mc") String name , Pageable pageable);
}
