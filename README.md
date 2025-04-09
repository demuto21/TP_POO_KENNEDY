FEZE DJOUMESSI FRED TERELL 3GI

Le projet que j'ai développé est une application Java qui permet de gérer des équipements (téléphones) d'occasion. Il est conçu pour vérifier si un équipement a été signalé comme volé en se basant sur son numéro de série. Voici les principales fonctionnalités :

1. Base de données MySQL : Une base de données appelée `EquipementDB` a été créée avec une table `Equipement`, qui contient les informations sur chaque équipement (nom, type, marque, modèle, numéro de série, statut de volé/non-volé).

2. Classes DAO : Des classes DAO (Data Access Object) permettent d'interagir avec la base de données. Elles gèrent l'ajout de nouveaux équipements, la recherche par numéro de série et la mise à jour du statut des équipements (par exemple, marquer un équipement comme volé).

3. Connexion à MySQL : Le projet est connecté à MySQL via le JDBC, permettant à l'application Java de communiquer avec la base de données pour effectuer les opérations sur les équipements.

4. Gestion des équipements : L'application permet d'ajouter de nouveaux équipements à la base de données, de rechercher un équipement existant par son numéro de série, et de modifier son statut (volé ou non volé).
