*****************
*** Prérequis ***
*****************

- java 7 ou 8

*******************
*** Description ***
*******************

Le répertoire "src/" contient 2 applications bouchons pour le test des serveurs :

- le bouchon permettant le test du serveur côté web sous forme d’un client TCP.
  Celui-ci se trouve dans le répertoire "clientandroid",
	
- le bouchon permettant le test du serveur côté Android sous la forme d’un serveur TCP.
  Celui-ci se trouve dans le répertoire "serveurweb".

********************************
*** Compilation et exécution ***
********************************

- ouvrir un terminal
- se placer dans le répertoire "src/"
- entrer les commandes suivantes en fonction de l’application souhaitée

*** Client : pour le test du serveur côté web

javac clientandroid/ClientAndroid.java
java clientandroid.ClientAndroid

*** Serveur : pour le test du serveur côté android

javac serveurweb/ServeurWeb.java
java serveurweb.ServeurWeb
