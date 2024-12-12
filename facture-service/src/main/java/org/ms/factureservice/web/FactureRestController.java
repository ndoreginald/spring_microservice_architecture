package org.ms.factureservice.web;

import java.util.List;

import org.ms.factureservice.entities.Facture;
import org.ms.factureservice.feign.ClientServiceClient;
import org.ms.factureservice.feign.ProduitServiceClient;
import org.ms.factureservice.model.Client;
import org.ms.factureservice.model.Produit;
import org.ms.factureservice.feign.ProduitServiceClient;
import org.ms.factureservice.repository.FactureLigneRepository;
import org.ms.factureservice.repository.FactureRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactureRestController {
	private FactureRepository factureRepository;
	private FactureLigneRepository factureLigneRepository;
	private ClientServiceClient clientServiceClient;
	private ProduitServiceClient produitServiceClient;

	public FactureRestController(FactureRepository factureRepository, FactureLigneRepository factureLigneRepository,
			ClientServiceClient clientServiceClient, ProduitServiceClient produitServiceClient) {

		this.factureRepository = factureRepository;
		this.factureLigneRepository = factureLigneRepository;
		this.clientServiceClient = clientServiceClient;
		this.produitServiceClient = produitServiceClient;
	}

	@GetMapping(path = "/full-facture/{id}")
	public Facture getFacture(@PathVariable(name = "id") Long id) {
		Facture facture = factureRepository.findById(id).get();
		Client client = clientServiceClient.findClientById(facture.getClientID());
		facture.setClient(client);
		facture.getFacturekignes().forEach(fl -> {
			Produit product = produitServiceClient.findProductById(fl.getProduitID());
			fl.setProduit(product);
		});
		return facture;
	}
	
	// Nouvelle méthode pour récupérer toutes les factures d'un client particulier
    @GetMapping(path = "/factures/client/{clientId}")
    public List<Facture> getFacturesByClientId(@PathVariable(name = "clientId") Long clientId) {
        // Récupérer toutes les factures du client spécifié
        List<Facture> factures = factureRepository.findByClientID(clientId);
        
        // Charger les détails du client et des produits pour chaque facture
        factures.forEach(facture -> {
            // Récupérer les informations du client
            Client client = clientServiceClient.findClientById(facture.getClientID());
            facture.setClient(client);
            
            // Récupérer les informations des produits dans chaque ligne de facture
            facture.getFacturekignes().forEach(fl -> {
                Produit produit = produitServiceClient.findProductById(fl.getProduitID());
                fl.setProduit(produit);
            });
        });
        return factures;
    }
	
}
