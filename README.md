# Tetris
Un tetris beau. Si vous voulez une version moche, veuillez visiter : https://github.com/Drainman/SirTet

Ce Tetris est un projet de qualité logicielle. Il a pour but de s'exercer aux tests.
Il est primordial de se rendre compte qu'il est plus important d'avoir peu de code testé et fonctionnel que beaucoup de code non testé et  potentiellement bugué.

Dans ce projet, nous avons réalisé et testé :
- un plateau de 10x24
- 7 pièces différentes de 4 blocs
- les rotations des pièces
- le game over
- la suppression des lignes complètes
- le comptage des points
- l'augmentation de la difficulté par niveau plus rapide
- l'affichage (en Swing)

Méthode de test : JUnit

Contrôles :
Flèche droite/gauche : déplacement
Flèche haut : rotation
Flèches bas : accélerer la pièce
Barre d'espace : "drop" de la pièces

Afin de tester le jeux, nous avons du passé de nombreux attributs et fonctions en publique.
Nous n'avons pas pu tester les contrôles avec JUnit car ils appelent des KeyListener.


Réalisé par :
Thibaud Germain
Valentin Detcheberry
