<strong>#BlackJack <br>
Présentation du jeu :<br>
     BlackJack est un jeu implémenté en Java en utilisant la librerie d'interface graphique SWING.Pour mettre en pratique les connaissances acquises,j'ai implémenté dans le projet certains patterns : Modèle-Vue-Contrôleur(MVC), le Pattern Observer et le pattern Factory. <br>
     D’abord j'ai implémenté une librairie ‘carte’ qu’j'ai manipulée dans le projet de Blackjack,elle contient l'ensemble des objets de base: Carte,Paquet de cartes et leurs vues.<br>    
    Le jeu  consiste à faire jouer un croupier (qui représente la banque) contre plusieurs joueurs. Notre application fait jouer un humain et deux robots contre le croupier qui lui-même est un robot.
Au début, l’utilisateur appuie sur le bouton ‘commencer’ pour démarrer le jeu. En suite le croupier distribue 2 cartes à chaque joueur puis il prend lui aussi 2 cartes.
Le joueur humain est le premier à jouer il a la possibilité de demander une carte, doubler sa mise ou passer son tour. Le joueur ne peut doubler sa mise seulement après la distribution initiale des cartes. S’il passe son tour, alors c’est le tour des robots qui eux aussi peuvent décider de demander une carte ou de passer leurs tours de manière automatique.
Pour le croupier, tant qu’il n’a pas atteint 17 points il doit tirer une carte à chaque tour de jeu. S’il dépasse 17 points alors le jeu se termine, si un joueur dépasse 21 points il est éliminé d’office. En fin de jeu, on a une liste des gagnants suivants leurs points en comparaison avec le croupier qui lui aussi peut gagner ou perdre.
Le croupier gagne si au moins un joueur a perdu et perds si tous les joueurs ont gagné.<br><br>

       
<strong/>
