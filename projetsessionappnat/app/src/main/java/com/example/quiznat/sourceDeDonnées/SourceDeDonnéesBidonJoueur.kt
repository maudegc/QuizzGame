package com.example.quiznat.sourceDeDonnées

import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.Joueur.ISourceDeDonnéesJoueurs

class SourceDeDonnéesBidonJoueur() : ISourceDeDonnéesJoueurs {
    override fun getJoueurParNom(nom: String): Joueur {
        var joueur = Joueur("Maude", "crosemont")
        return joueur
    }

    override fun getJoueurs(): List<Joueur> {
        var joueurs = ArrayList<Joueur>()

        joueurs.add(Joueur("Maude", "crosemont"))
        joueurs.add(Joueur("Gus Gus", "lala"))
        joueurs.add(Joueur("Maxime", "toto"))

        return joueurs
    }

    override fun ajouterJoueur(joueur: Joueur): Joueur {
        return joueur
    }

    override fun modifierJoueur(joueur: Joueur?): Int? {
        return 1
    }
}

