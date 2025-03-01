# NeoBankX - Microservices

NeoBankX est une application bancaire moderne construite avec une architecture **microservices** en utilisant **Spring Boot** et **MariaDB**.

##  Architecture du projet

Le projet est structuré en plusieurs microservices indépendants :

- **discovery-service** : Service d'enregistrement (Eureka Server)
- **gateway-service** : API Gateway pour la gestion des requêtes
- **user-service** : Gestion des utilisateurs
- **account-service** : Gestion des comptes bancaires

##  Technologies utilisées

- **Backend** : Java, Spring Boot
- **Base de données** : MariaDB
- **Service Discovery** : Eureka Server
- **API Gateway** : Spring Cloud Gateway
- **Communication interservices** : OpenFeign
- **Gestion des versions** : Git & GitHub

##  Installation & Configuration

### 1️ Prérequis
Assurez-vous d'avoir installé :
- Java 17+
- Maven 3+
- Docker (optionnel, pour MariaDB)
- Git

### 2️ Cloner le projet
```bash
 git clone https://github.com/Fatima499/NeoBankX-Microservices.git
 cd NeoBankX-Microservices
```

### 3️ Configuration de la base de données
Créer une base de données MariaDB pour chaque microservice :
```sql
CREATE DATABASE user_db;
CREATE DATABASE account_db;
```
Mettez à jour les fichiers `application.properties` dans `user-service` et `account-service` avec vos informations de connexion.

### 4️ Lancer les microservices
Démarrer chaque service dans cet ordre :
```bash
cd discovery-service
mvn spring-boot:run
```
```bash
cd gateway-service
mvn spring-boot:run
```
```bash
cd user-service
mvn spring-boot:run
```
```bash
cd account-service
mvn spring-boot:run
```

##  Documentation API
Une documentation Swagger sera bientôt ajoutée pour faciliter les tests.

##  Contribuer
Les contributions sont les bienvenues ! Clonez le projet, créez une branche et soumettez une pull request. 

##  Licence
Projet sous licence MIT.

