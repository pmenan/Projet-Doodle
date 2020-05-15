UE : SIR (Système d'Informations Repartie)
PROJET DOODLE - Backend

Objectif du projet 
L'UE SIR se solde par un projet final, c'est dans cette optique que nous avons réalisé ce projet.
la finalité étant de permettre à chaque étudiant d'avoir une meilleure aisance avec les nouvelles technologies Web.
L’objectif du projet est de construire une application de prise de RDV type doodle mais en y ajoutant un certain nombre de services.
Dans ce présent rapport, nous exposerons d'abord les fonctionnalités offertes par notre application, ensuite listerons nos choix d'outils
pour la réalisation du projet et enfin quelque liens pour le test de notre API et la base de donnée.


Fonctionnalités offertes par l'application
création et gestion de compte utilisateur
creation de sondages : il peut s'agir d'un sondage de lieu, de date ou des deux (dates et lieux)
ajout de préférences alimentataires à un sondage auquel l'on participe ou que l'on crée
envoie de mails à tous les participants après validation du sondage.

Choix des outils et technologie
Eclipse comme IDE
Maven pour la gestion des dépendances
Spring pour la génération du squelette de notre projet
Swagger pour la documentation de l'Api 
H2 pour la base de donnée memoire.
Advanced Rest client pour tester nos routes

Lien de tests
lancer l'application puis :
tapez http://localhost:8080/h2 pour accèder à la base de données 

Quelques lien pour test de l'api

/*creer un  user (Methode POST)*/
http://localhost:8080/users/

/*créer un sondage pour le user ayant id = 1 (Methode POST)*/
http://localhost:8080/users/1/sondages/

/*créer date (Methode POST)*/
http://localhost:8080/users/createDate

/*ajouter une date à un sondage :sondage de date pour un participant*/
http://localhost:8080/users/1/sondages/162/dates/161

/*Ajouter un lieu à un sondage : sondage de lieu (id_sondage = 2) avec ID Lieu (id_lieu = 97) (Methode POST)*/
http://localhost:8080/users/1/sondages/2/lieux/97

/*Modifier le lieu d un sondage de lieu (Methode PUT)*/
http://localhost:8080/users/130/sondages/34/lieux/97

/*afficher les details(libelle, description, ...) d'un sondage à partir de son ID (id = 34 ici) (Methode GET)*/
http://localhost:8080/users/sondages/34

/*valider le sondage à partir de son ID (Methode POST)*/
http://localhost:8080/users/1/sondages/34/validate

/*afficher la liste des sondages du user ayant id =1 (Methode GET)*/
http://localhost:8080/users/1/sondages/

/*créer une préférence (Methode POST)*/
http://localhost:8080/users/createPreference

/*Afficher tous les sondages (Methode GET*/
http://localhost:8080/sondages


Auteurs
Patrick MENAN
Yannick ECTHE

