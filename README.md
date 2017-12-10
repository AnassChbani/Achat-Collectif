# Achat-Collectif
Projet J2EE : Un système d'achat collectif
Vous êtes chargé de modéliser et développer une application web pour les achats collectifs. L'application est destinée à tout le monde sur le net, dont les utilisateurs peuvent devenir des clients en effectuant une inscription. Le principe est très simple, il se base la création d'un sujet d'achat d'un produit avec une description détaillée. Par la suite les intéressés peuvent s'adhérer à ce sujet tout en garantissant une diminution de prix à chaque fois le nombre des adhérents augmente. Les règles de gestion peuvent être classées en quelques points:
 Un sujet est créer par un administrateur ou un client;
 Un sujet est supprimé par un administrateur ou son créateur s'il s'agit d'un client;
 Un sujet a une durée de vie pendant laquelle il est visible sur le site avec toutes les informations, y compris le temps qui reste et le nombre des adhérents;
 A chaque modification du descriptif ou l'ajout d'un nouveau adhérent, tous les autres doivent recevoir un email de notification (il faut utiliser le Publish/subscribe –installation d'un serveur mail si necéssaire);
 Les sujets sont classés par rubriques, et aussi trouvables par une recherche (intégration de ce composant est souhaitable;
 Le prix doit obligatoirement diminuer avec les adhésions;
 Après l'échéance d'un deal, les utilisateurs reçoivent un email pour le paiement en ligne dans un délai de 48h (simulation);
 Un deal expiré, doit être supprimer et notifier par la suite les utilisateur;
 Chaque produit doit avoir une image et une partie en bas pour les commentaires.
Votre mission consiste à :
1. Modéliser le cahier de charge et proposer un schéma pour la base de données ;
2. Création de l'application dans un environnement J2EE en utilisant les frameworks que nous avons vu Strut/Hibernate (vous pouvez utiliser d'autre);
3. Simplifier le maximum l'utilisation de l'application:
a. La convivialité;
b. L'utilisation des images et d'animation;
c. Réduire le nombre de clic;
d. De différentes vues selon le profil de l'utilisateur.
4. Fournir des options des statistiques sur les deals assurés/non assurés, sur les catégories
les plus populaires/mois populaires, les régions géographiques les plus importantes en
terme d'achat…;
a. Des représentations graphiques sont souhaitables (diagramme et graphe);
5. Un niveau de sécurité est requis:
a. Authentification et sa gestion (3 tentatives, mot de passe ayant au mon un
Majuscule et un chiffre);
b. Un cryptage est souhaité lors de l'échange entre le client et le serveur.
