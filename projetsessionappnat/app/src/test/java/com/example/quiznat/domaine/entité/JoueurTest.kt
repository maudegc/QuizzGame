package com.example.quiznat.domaine.entité

import junit.framework.Assert.*
import junit.framework.TestCase
import org.junit.Test

class JoueurTest {
    @Test
    fun testAccesseurNomJoueur() {
        val joueur = Joueur("Maude", "crosemont")
        assertEquals("Maude", joueur.nom)
    }

    @Test
    fun testAccesseurMotPasse() {
        val joueur = Joueur("Maude", "crosemont")
        assertEquals("crosemont", joueur.motDePasse)
    }

    @Test
    fun testAccesseurScoreScience() {
        val joueur = Joueur("Toto", "bobo")
        joueur.scoreScience = 10
        assertEquals(10, joueur.scoreScience)
    }

    @Test
    fun testConfirmeConnectionTrue() {
        val nom = "Toto"
        val motPasse = "bobo"
        val joueur = Joueur("Toto", "bobo")
        assertTrue(joueur.confirmeConnection(nom, motPasse))
    }

    @Test
    fun testConfirmeConnectionFalse() {
        val nom = "Toto"
        val motPasse = "bobo"
        val joueur = Joueur("Bobo", "toto")
        assertFalse(joueur.confirmeConnection(nom, motPasse))
    }

    @Test
    fun testGetScoreTotal() {
        val joueur = Joueur("Toto", "tata")
        joueur.scoreScience = 3
        joueur.scoreHistoire = 2
        joueur.scoreProgrammation = 5

        assertEquals(10, joueur.getTotalScore())
    }
}