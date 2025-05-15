# 📦 Candidature - Microservice de gestion d'utilisateurs avec Kafka

Ce projet a été réalisé dans le cadre d'une candidature technique.  
Il s'agit d'un **microservice simple** permettant de **créer, activer, désactiver et supprimer des utilisateurs**, avec **envoi d'événements Kafka** à chaque action.

## ⚙️ Technologies utilisées

- **Java 17**
- **Spring Boot**
- **Kafka (via Docker)**
- **PostgreSQL (via Docker)**
- **Test unitaire avec JUnit et AssertJ**
- Architecture DDD découpée : `controller`, `service`, `domain`, `infrastructure`

## 🧱 Architecture

Le projet suit une séparation des responsabilités selon DDD :

presentation/
└── controller/ → API REST
└── kafka/ → Listener

application/
└── service/ → Logique métier (UserService)

domain/
├── model/ → Entité métier User
├── event/ → Événements (UserCreatedEvent, etc.)
└── exception/ → Exceptions

infrastructure/
├── entity/ → Entités JPA/hibernate (UserEntity)
├── repository/ → Interfaces Spring Data JPA (PostgresUserRepository)
└── kafka/ → Publisher

## 🚀 Fonctionnalités

- **POST /users** : Créer un utilisateur
- **DELETE /users/{id}** : Supprimer un utilisateur
- **PATCH /users/{id}/activate** : Activer un utilisateur
- **PATCH /users/{id}/deactivate** : Désactiver un utilisateur
- À chaque action, un événement Kafka est envoyé sur le topic `push.user`

## 🧪 Tests

- Tests unitaires sur le service métier (`UserService`)
- Mise en place prévue des **tests d’intégration complets** (BDD + Kafka)

## 🐳 Démarrage avec Docker

Le projet est prévu pour fonctionner avec **PostgreSQL** et **Kafka** exécutés localement via Docker.  
Il suffit de démarrer les services requis (via `docker-compose` par exemple) avant de lancer l'application.


## 🔜 Améliorations prévues

    Traitements Kafka réels

    Tests d’intégration complets (controller + BDD + Kafka)

    Swagger/OpenAPI pour la documentation

    Sécurité (Spring Security + token)