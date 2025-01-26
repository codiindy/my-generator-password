# Générateur de Mots de Passe

Ce projet est un générateur de mots de passe unique, sécurisé et personnalisé. Il permet à l'utilisateur d'entrer deux mots de son choix, de définir la longueur du mot de passe, et de recevoir un mot de passe généré combinant ces informations.

## Technologies utilisées

- **Frontend** :
  - Vue.js avec Vite
  - Tailwind CSS pour le design
- **Backend** :
  - Java avec Spring Boot (pour générer les mots de passe côté serveur)
  
## Fonctionnalités

- Génération de mots de passe basés sur deux mots personnels choisis par l'utilisateur.
- Possibilité de spécifier la longueur minimale du mot de passe (minimum 12 caractères).
- Interface utilisateur simple et moderne avec Vue.js et Tailwind CSS.
- Fonction de copie du mot de passe généré dans le presse-papiers.
- Bouton de rafraîchissement pour générer un nouveau mot de passe.

## Prérequis

Avant de commencer, assurez-vous que vous avez installé les outils suivants :

- **Node.js** et **npm** pour le frontend.
- **Java** et **Maven** ou **Gradle** pour le backend (Spring Boot).
  
## Installation

### Frontend

1. Clonez ce dépôt sur votre machine locale :
   ```bash
   git clone https://github.com/ton-utilisateur/generateur-mots-de-passe.git
