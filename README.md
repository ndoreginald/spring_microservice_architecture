# spring_microservice_architecture with Spring Boot

Ce projet démontre la mise en œuvre d'une architecture basée sur des microservices à l'aide de Spring Boot et des outils Spring Cloud. Chaque service est autonome, découplé, et conçu pour interagir via des API REST, avec des fonctionnalités de découverte, de gestion de configuration centralisée et de routage intelligent.

## 🛠️ Services inclus

### 1. **Client Service**
   - Gestion des informations clients.
   - CRUD complet pour les entités `Client`.
   - API REST sécurisée.

### 2. **Facture Service**
   - Gestion des factures liées aux clients.
   - Génération et suivi des factures.
   - Relation avec le `Client Service` pour les données de client.

### 3. **Produit Service**
   - Gestion des produits (CRUD).
   - Consultation des stocks et informations produits.

### 4. **Gateway Service**
   - Service de passerelle basé sur **Spring Cloud Gateway**.
   - Routage intelligent des requêtes vers les différents services.
   - Fonctionnalités de sécurité et de filtrage global.

### 5. **Eureka Discovery Service**
   - Service de registre pour la découverte et le suivi des microservices.
   - Utilise **Spring Cloud Netflix Eureka**.

### 6. **Config Service**
   - Gestion centralisée des configurations pour tous les services.
   - Basé sur **Spring Cloud Config**.
   - Chargement dynamique des propriétés des microservices depuis un dépôt Git.

## 🔑 Fonctionnalités principales
- **Découverte de services** : Utilisation de **Eureka** pour enregistrer et découvrir dynamiquement les microservices.
- **Gestion de configuration** : Configuration centralisée avec **Spring Cloud Config**.
- **Passerelle API** : Routage des requêtes et sécurité avec **Spring Cloud Gateway**.
- **Couplage faible** : Chaque service peut être déployé et mis à jour indépendamment.
- **Extensibilité** : Prêt pour des ajouts de services futurs.
