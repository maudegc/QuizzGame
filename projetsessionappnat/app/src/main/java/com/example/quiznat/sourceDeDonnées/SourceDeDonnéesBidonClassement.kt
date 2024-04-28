package com.example.quiznat.sourceDeDonnées

import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.classement.ISourceDeDonnéesClassementTest

class SourceDeDonnéesBidonClassement() : ISourceDeDonnéesClassementTest {
    /**
    Fonction qui permet de renvoyer une liste des 5 meilleurs joueurs bidon
     */
    override fun classementJoueurs(): List<Joueur>? {

        var joueur1 = Joueur("Maxime", "crosemont")
        var joueur2 = Joueur("Maude", "crosemont")
        var joueur3 = Joueur("Gusty", "crosemont")
        var joueur4 = Joueur("Patrick", "crosemont")
        var joueur5 = Joueur("Jean", "crosemont")
        joueur1.scoreProgrammation = 5
        joueur2.scoreProgrammation = 10
        joueur3.scoreProgrammation = 2
        joueur4.scoreProgrammation = 1
        joueur5.scoreProgrammation = 6

        joueur1.scoreScience = 17
        joueur2.scoreScience = 15
        joueur3.scoreScience = 12
        joueur4.scoreScience = 13
        joueur5.scoreScience = 1

        joueur1.scoreSport = 1
        joueur2.scoreSport = 2
        joueur3.scoreSport = 3
        joueur4.scoreSport = 4
        joueur5.scoreSport = 5

        joueur1.scoreGeo = 6
        joueur2.scoreGeo = 7
        joueur3.scoreGeo = 6
        joueur4.scoreGeo = 4
        joueur5.scoreGeo = 3

        joueur1.scoreHistoire = 12
        joueur2.scoreHistoire = 10
        joueur3.scoreHistoire = 4
        joueur4.scoreHistoire = 5
        joueur5.scoreHistoire = 6

        joueur1.scoreAnimaux = 5
        joueur2.scoreAnimaux = 10
        joueur3.scoreAnimaux = 22
        joueur4.scoreAnimaux = 12
        joueur5.scoreAnimaux = 6

        return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)
    }
}