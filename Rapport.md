# Rapport 


## Statistiques

En l'état, l'extracteur permet de créer 692 fichiers csv (dont 2 fichiers contenant les informations sur les nombre de lignes et colonnes des fichiers csv,
ainsi que l'ensemble des titres). Les statistiques sur les fichiers sont les suivantes :


* Nombre minimal de colonnes : 2
* Nombre maximal de colonnes : 30
* Nombre moyen de colonnes : 8,9
* Variance du nombre de colonnes : 4,5


* Nombre minimal de lignes : 0
* Nombre maximal de lignes : 593
* Nombre moyen de lignes : 28,1
* Variance du nombre de lignes : 39,2


Le titre de colonne vide apparaît 89 fois dans les tableaux.

### Qualités et faiblesses

Les tests effectués sur l'URL Canon nous indique que le nombre de lignes et de colonnes est bien respecté.


Le code fourni permet également de créer des tableaux à "double entrée", c'est-à-dire dont la première colonne est composée de cellules th (des titres donc) comme par exemple pour l'url 10 : "Comparison of Asian national space programm" où des dates font office de header de ligne. Par ailleurs, certaines URL renvoient un code d'erreur HTTP, ces cas sont également traités et lors de la lecture de l'url, un message est renvoyé pour préciser que l'url est inatteignable lorsque c'est le cas.


Dans le cas d'un tableau contenant 2 titres similaires, l'hypothèse qui a été faite est la suivante : les tableaux sont cohérents, donc le seul titre qui peut apparaitre en plusieurs fois est le titre vide. Dans ce cas, un des titres est retiré dans la liste des titres. Ceci pose un problème si le doublon se trouve au milieu d'autres titres car cela provoque un décalage. Cette option pourrait être améliorée en rajoutant un suffixe à un titre, ce qui permettrait de gérer tous les cas de doublons.


Les tableaux n'étant pas gérés par l'extracteur sont :

* les tableaux contenus dans d'autres tableaux,
* les tableaux contenant des caractères spéciaux
* les tableaux n'étant pas de la classe "wikitable sortable"
* les tableaux dont les balises de titres ne sont pas "th"
* d'autres cas non répertoriés


### Synthèse Générale

Certains tableaux sont exploitables, cependant une grande partie reste inexploitable, soit par absence d'informations, soit par présence d'informations erronées.
