# Application Cinéma

Dans la commande docker ci-dessous j'ai spécifié les ip pour la configuration avec le projet (Ça fonctionnait pas sans).

**Docker postgres**: ``docker run --name postgres --ip 172.17.0.7 -e POSTGRES_PASSWORD=admin -d postgres``

Dans le dossier sql se trouve un script pour initialiser la base de donnée.

* url=jdbc:postgresql://172.17.0.7:5432/postgres
* username=postgres
* password=admin

Sur docker desktop, sur le container postgres une fois créer dans la categorie ``exec``, on peut venir alimenter la base de donnée.
* psql -h 172.17.0.7 -U postgres
* password **admin**
* \c postgres
* Ajouter les tables et les jeux d'essai


Build le dockerfile:
* Dans le projet:
  * ``docker build -t NOMAUCHOIX:tag .``
  * ``docker run -p 8080:8080 -d NOMAUCHOIX:tag``


Lien pour la documentation openApi quand l'application est lancée:
http://localhost:8080/swagger-ui/index.html

