
package Vue;

import Controlleur.ControleurPiocheJoueur;
import Model.Croupier;
import Model.Joueur;
import Model.JoueurHumain;
import Model.Robots;
import Model.TablePioche;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.PaquetFactory;


public class GUIBJ extends JFrame {

    /**
     * joueurs participant  à la partie
     */
    private static Joueur humain;
    /**
     * joueurs participant  à la partie
     */
    private static Joueur robot;
    /**
     * joueurs participant  à la partie
     */
    private static Joueur robot2;
    /**
     * le croupier du jeu
     */
    private static Croupier croupier;
    /**
     * liste des joueurs gagnants
     */
    private static Set<Joueur> listeGagnants;
    /**
     * instance de la classe qui contient la pioche 
     */
    private static TablePioche tablePioche;
    /**
     *  instance du classe ControleurPiocheJoueur
     */
    private static ControleurPiocheJoueur controleJeu;
    /**
     * bouton pour commencer la partie
     */
    private static JButton boutonCommencer = new JButton("commencer");
    /**
     * bouton pour  demander une carte
     */
    private static JButton boutonDemanderCarte = new JButton("demandé une carte");
    /**
     * bouton pour passer le tour
     */
    private static JButton boutonPasserTour = new JButton("passer votre tour ");
    /**
     * bouton pour doubler la mise du joueur humain 
     */
    private static JButton boutonDoublerMise = new JButton("doublé la mise");
    /**
     * contenaire de la fenêtre 
     */
    private static Container cp;
    /**
     * le contenue  du message du PopUp qui s'affiche  à la fin jeu
     */
    private static JOptionPane message;
    /**
     * Jlabel qui affiche la mise du joueur 
     */
    private static JLabel jMise;
    /**
     * constructeur de la fenêtre 
     */
    public GUIBJ() {
        /**
         * joueur réel son nom donnée:"Humain" et une mise de 1000 euros 
         */
        humain = new JoueurHumain("Humain", 1000);
        /**
         * premier joueur fictif avec un nom : "Joueur1" et une mise de 5000 euros
         */
        robot = new Robots("Joueur1", 5000);
        /**
         * deuxième joueur fictif avec un nom : "Joueur2" et une mise de 500 euros
         */
        robot2 = new Robots("Joueur2", 500);
        /**
         * la liste des joueurs donné au croupier -- initialement vide 
         */
        List<Joueur> listJoueurs = new ArrayList<Joueur>();
        /**
         * ajout du joueur humain à la liste 
         */
        listJoueurs.add(humain);
        /**
         * ajout du premier robot à la liste des joueurs
         */
        listJoueurs.add(robot);
        /**
         * ajout du deuxième robot à la liste des joueurs
         */
        listJoueurs.add(robot2);
        /**
         * instanciation de la classe TablePioche en lui passant au constructeur un paquet de 52 cartes 
         */
        tablePioche = new TablePioche(PaquetFactory.createPaquet(52));
        /**
         * on mélonge la pioche(paquet des cartes) de la table 
         */
        tablePioche.getPioche().melanger();
        /**
         * l'instanciation du croupier en lui passant la liste des joueurs et l'instance de TablePioche 
         * qui contient la pioche d'où il va tirer les cartes pour distribuer 
         */
        croupier = new Croupier("Croupier", 10000, listJoueurs, tablePioche);
        /**
         * l'instanciation du controleur en lui passant l'instance de la classe Croupier 
         */
        controleJeu = new ControleurPiocheJoueur(croupier);
        /**
         * la vue de la main du joueur humain 
         */
        VueJoueur vueMainJoueur = new VueJoueur(humain.getMainJoueur());
        /**
         * la vue du joueur robot 1
         */
        VueJoueur vueRobot = new VueJoueur(robot.getMainJoueur());
        /**
         * la vue du joueur robot 2
         */
        VueJoueur vueRobot2 = new VueJoueur(robot2.getMainJoueur());
        /**
         * la vue du croupier 
         */
        VueJoueur vueCroupier = new VueJoueur(croupier.getMainJoueur());
        /**
         * un JLabel pour afficher la maise du joueur humain
         */
        jMise = new JLabel("Vous, "+" Mise : "+controleJeu.getCroupier().getListPlayer().get(0).getMise()+"euros");
        /**
         * ajout du JLabel  a la vue 
         */
        vueMainJoueur.add(jMise);
        /**
         * un JLabel pour afficher la mise du croupier  et on l'ajoute  dans sa vue du 
         */
        vueCroupier.add(new JLabel("Croupier"));
        
        /**
         * un JLabel pour afficher la mise du joueur robot1  et on l'ajoute  dans sa vue 
         * 
         */
        vueRobot.add(new JLabel("Joueur1, "+" Mise : "+robot.getMise()+"euros"));
        /**
         * un JLabel pour afficher la mise du joueur robot2  et on l'ajoute  dans sa vue 
         */
        vueRobot2.add(new JLabel("Joueur2, "+" Mise : "+robot2.getMise()+"euros"));
        /**
         * bouton pour demander une carte est désactivé avant que la partie commence 
         */
        boutonDemanderCarte.setEnabled(false);
        /**
         * bouton pour passer le tour est désactivé avant que la partie commence 
         */
        boutonPasserTour.setEnabled(false);
         /**
         * bouton pour doublé la mise du joueur humain est désactivé avant que la partie commence
         */
        boutonDoublerMise.setEnabled(false);
        /**
         * ajoute un écouteur au bouton pour commencer la partie 
         * quand on click sur ce bouton  il se désactive, est les autres s'activent
         * une distribution initial se fait 
         */
        boutonCommencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleJeu.distribuerInit();
                boutonCommencer.setEnabled(false);
                boutonDoublerMise.setEnabled(true);
                boutonDemanderCarte.setEnabled(true);
                boutonPasserTour.setEnabled(true);
            }
        });
        
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(0,1,0,5));

        /**
         * Ajout d'écouteur au bouton pour demande une carte.
         * à chaque clique une carte est distribué à la main du joueur humain 
         * le bouton pour doublé la mise du joueur humain se désactive. 
         */
        boutonDemanderCarte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controleJeu.supprimeJoueursPerdants(controleJeu.getCroupier().getListPlayer());
                controleJeu.donnerCarte(humain);
                
                boutonDoublerMise.setEnabled(false);
                
            }

        });
        /**
         * Ajout d'écouteur au bouton pour doubler la mise.
         * en cliquant sur le bouton la mise du joueur humain se double le vue se met à jour et ce bouton se désactive 
         * et le bouton pour demander une carte aussi.
         * 
         */
        boutonDoublerMise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(controleJeu.getCroupier().getJoueurCourant()instanceof JoueurHumain){
                    controleJeu.getCroupier().getListPlayer().get(0).doublerSaMise();
                    jMise.setText("Vous, "+" Mise : "+controleJeu.getCroupier().getListPlayer().get(0).getMise()+"euros");
                    boutonDoublerMise.setEnabled(false);
                    boutonDemanderCarte.setEnabled(false);
                }
            }
        });
        /**
         * Ajout d'écouteur au bouton pour passer le tour du joueur humain.
         * en cliquant sur le bouton le croupier passe au joueur suivant qui est dans ça liste des joueurs.
         * tout les boutons seront désactivés.
         * la boucle while : 
         *      tant que le joueurCourant -attribut du croupier- n'est pas l'humain 
         *      et le jeu  n'est pas terminer -gameOver()renvoie false-, on donne au robot tour pour jouer
         *      et si le poid de la main du croupier est inférieur à 17 il va demandé une carte (selon les régles du jeux)
         * condition :
         *          si le jeu n'est pas encore terminé -controleJeu.gameOver()==false-, les boutons se réactives 
         *          si le jeu est terminer  un PopUp s'affiche content le joueur ou la liste des joueurs gagnants
         */
        boutonPasserTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleJeu.getCroupier().donnerTour();

                boutonDemanderCarte.setEnabled(false);
                boutonPasserTour.setEnabled(false);

                while (controleJeu.getCroupier().getJoueurCourant() != humain && controleJeu.gameOver() == false){
                        controleJeu.gestionRobots();
                     if (controleJeu.getCroupier().getPoids() < 17){
                        controleJeu.donnerCarte(controleJeu.getCroupier());
                    }
                }
                if (controleJeu.gameOver() == false) {
                    boutonDemanderCarte.setEnabled(true);
                    boutonPasserTour.setEnabled(true);
                    } else{
                        listeGagnants = new HashSet<Joueur>(controleJeu.gagnants());

                        String chaine ="le(s) gagnant(s):";
                        for(Joueur j: listeGagnants){
                            if(j instanceof Croupier){
                                chaine+="\n"+j.getNomJoueur()+" CAISSE :"+j.getMise()+"euros\n";
                            }else{
                                chaine+="\n"+j.getNomJoueur()+"  Gain :"+j.getMise()/2+"euros\n";
                            }
                        }
                    JOptionPane.showMessageDialog(cp, chaine, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                   
                }
            }
        });
       
        //ajout des vues au contenaire 
        cp.add(vueCroupier);
        cp.add(vueRobot);
        cp.add(vueRobot2);
        
        /**
         * l'instanciation d'un JPanel avec le LayoutManager: GridLayout, avec 4 lignes et une colonne
         * chaque ligne pour vue 
         */
        JPanel pan1 = new JPanel(new GridLayout(0,4,5,0));
        pan1.add(boutonDemanderCarte );
        pan1.add(boutonCommencer);
        pan1.add(boutonPasserTour);
        pan1.add(boutonDoublerMise);
        /**
         * mettre  couleur au  fond de la vue du joueur humain
         */
        vueMainJoueur.setBackground(Color.pink);
        cp.add(vueMainJoueur);
        cp.add(pan1);

        this.setSize(1000, 700);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
