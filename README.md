# Wikipedia Matrix (benchmark)

Le but est d'extraire des tableaux de 300 pages wikipedia. On utilise pour cela le langage HTML des pages pour en extraire les tableaux, et les réecrire sous le format CSV. 

### Diagramme de classes

![Diagramme UML](diagramme_classes.png "Diagramme UML")

La classe principale MatrixExtractor réalise la plupart des traitements nécessaires à la lecture du fichier HTML source de la page wikipedia pour récupérer les tableaux, ainsi que l'export de ces tableaux au format csv.

Le fichier a lancé est le fichier `BenchTest.java` et les resulats seront dans le dossier `output`. 

