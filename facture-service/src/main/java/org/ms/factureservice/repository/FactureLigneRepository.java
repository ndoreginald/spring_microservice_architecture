package org.ms.factureservice.repository;

import java.util.Collection;

import org.ms.factureservice.entities.FactureLigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface FactureLigneRepository extends JpaRepository<FactureLigne, Long> {

	Collection<FactureLigne> findByFactureId(Long factureId);
}
