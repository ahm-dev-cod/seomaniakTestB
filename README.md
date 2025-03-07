# seomaniakTestB
Gestion de Projets et Tâches avec Java Spring Boot, Spring Data JPA et MySQL

## Description
Ce projet est la partie backend d'une application full-stack qui permet de gérer des projets et des tâches. Le backend est développé en Java Spring Boot, et le frontend en Angular. L'application permet de créer, lire, mettre à jour et supprimer des projets, ainsi que de filtrer les tâches par statut ou titre.

## Fonctionnalités
- Gestion des projets (CRUD)
- Relation OneToMany entre projets et tâches
- Filtrage des tâches par statut et titre

## Structure du Projet
- **backend** : Contient le code Spring Boot (entités, repositories, services, controllers, map)

## Technologies Utilisées
- **Backend** : Java Spring Boot, Spring Data JPA, H2 Database (ou MySQL)
- **Base de données** : MySQL
- **Outils** : Lombok, Spring Initializr

## Dépendances
### Backend (Spring Boot)
- Spring Web
- Spring Data JPA
- Lombok
- MySQL

  ## Installation et Configuration
### Backend (Spring Boot)
1. Cloner le dépôt : `git clone https://github.com/ahm-dev-cod/seomaniakTestB.git`
2. Accéder au dossier backend : `cd seomaniakTest`
3. Configurer la base de données dans `application.properties` pour MySQL
4. Lancer l'application : `mvn spring-boot:run`
