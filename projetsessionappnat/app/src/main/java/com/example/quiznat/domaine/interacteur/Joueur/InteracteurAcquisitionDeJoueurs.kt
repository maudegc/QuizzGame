package com.example.quiznat.domaine.interacteur.Joueur

import com.example.quiznat.domaine.entité.Joueur

/**
 * Classe InteracteurAcquisitionDeJoueurs intéragit avec l'Api
 * afin d'acquérir les données concernant le joueur
 *
 * @param _source
 */
class InteracteurAcquisitionDeJoueurs(var _source: ISourceDeDonnéesJoueurs?) {
    fun joueurParNom(nom: String): Joueur {
        return _source!!.getJoueurParNom(nom)
    }

    fun joueurs(): List<Joueur> {
        return _source!!.getJoueurs()
    }

    fun ajoutJoueur(joueur: Joueur): Joueur {
        return _source!!.ajouterJoueur(joueur)
    }

    fun modifierJoueur(joueur: Joueur?): Int? {
        return _source!!.modifierJoueur(joueur)
    }
}

