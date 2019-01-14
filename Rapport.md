# Rapport 


## Statistiques

En l'état, l'extracteur permet de créer 694 fichiers csv (dont 2 fichiers contenant les informations sur les nombre de lignes et colonnes des fichiers csv,
ainsi que l'ensemble des titres). Les statistiques sur les fichiers sont les suivantes :


* Nombre minimal de colonnes : 0
* Nombre maximal de colonnes : 333
* Nombre moyen de colonnes : 18,05
* Variance du nombre de colonnes : 33.4


* Nombre minimal de lignes : 0
* Nombre maximal de lignes : 702
* Nombre moyen de lignes : 60.4
* Variance du nombre de lignes : 104.65

Il y a 131 tableaux vides.

Le titre de colonne vide apparaît 93 fois dans les tableaux.

### Limites de l'extracteur

Les tests effectués sur l'URL Canon nous indique que le nombre de lignes et de colonnes est bien respecté (les colonnes et les lignes ont été comptées à la main pour être comparées à ce qui a été fait par l'extracteur).


L'extracteur permet d'avoir les tabelaux de la classe "wikitable sortable" dont les titres sont dans des balises "th" et les autres lignes dans des balises "td".

Dans le cas d'un tableau contenant 2 titres similaires, l'hypothèse qui a été faite est la suivante : les tableaux sont cohérents, donc le seul titre qui peut apparaitre en plusieurs fois est le titre vide. Dans ce cas, un des titres est retiré dans la liste des titres. Ceci pose un problème si le doublon se trouve au milieu d'autres titres car cela provoque un décalage. Cette option pourrait être améliorée en rajoutant un suffixe à un titre, ce qui permettrait de gérer tous les cas de doublons.


Les tableaux n'étant pas gérés par l'extracteur sont :

* les tableaux contenus dans d'autres tableaux,
* les tableaux contenant des caractères spéciaux
* les tableaux n'étant pas de la classe "wikitable sortable"
* les tableaux dont les balises de titres ne sont pas "th"
* d'autres cas non répertoriés


### Conclusion

Certains tableaux sont exploitables, cependant une grande partie reste inexploitable, soit par absence d'informations, soit par présence d'informations erronées.
