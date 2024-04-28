package com.example.quiznat.domaine.interacteur.joueur

import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.Joueur.InteracteurAcquisitionDeJoueurs
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonJoueur
import junit.framework.Assert.assertEquals

import org.junit.Test

class InteracteurAcquisitionDeJoueursTest() {
    @Test
    fun getJoueurParNom() {
        val source = SourceDeDonnéesBidonJoueur()
        assertEquals("Maude", InteracteurAcquisitionDeJoueurs(source).joueurParNom("Maude").nom)
    }

    @Test
    fun getJoueurs() {
        val source = SourceDeDonnéesBidonJoueur()
        val joueurs = InteracteurAcquisitionDeJoueurs(source).joueurs()
        for (i in 0 until joueurs.size) {
            assertEquals(joueurs[i].nom, InteracteurAcquisitionDeJoueurs(source).joueurs()[i].nom)
        }
    }

    @Test
    fun ajouterJoueur() {
        val source = SourceDeDonnéesBidonJoueur()
        val joueur = Joueur("Toto", "tata")
        assertEquals("Toto", InteracteurAcquisitionDeJoueurs(source).ajoutJoueur(joueur).nom)
    }
}