package com.example.quiznat.domaine.interacteur.Joueur

import com.example.quiznat.domaine.entité.Joueur

interface ISourceDeDonnéesJoueurs {
    fun getJoueurParNom(nom: String): Joueur
    fun getJoueurs(): List<Joueur>
    fun ajouterJoueur(joueur: Joueur): Joueur
    fun modifierJoueur(joueur: Joueur?): Int?
}
