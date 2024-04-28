package com.example.quiznat.présentation.présentateur

import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.présentation.vue.Fragment_accueil
import com.example.quiznat.présentation.vue.Fragment_login

import junit.framework.TestCase
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class Présentateur_accueilTest {
    @Test
    fun testSeDeconnecter() {
        val mockVue = mock(Fragment_accueil::class.java)
        val presentateur = Présentateur_accueil(mockVue)
        presentateur.seDeconnecter()
        Mockito.verify(mockVue).naviguerÉcranLogin()
    }

    @Test
    fun testAfficherÉcranCatégorie() {
        val mockVue = mock(Fragment_accueil::class.java)
        val presentateur = Présentateur_accueil(mockVue)
        presentateur.afficherÉcranCategorie()
        Mockito.verify(mockVue).naviguerÉcranCategorie()
    }

    @Test
    fun testAfficherÉcranLogin() {
        val mockVue = mock(Fragment_accueil::class.java)
        val presentateur = Présentateur_accueil(mockVue)
        presentateur.afficherÉcranLogin()
        Mockito.verify(mockVue).naviguerÉcranLogin()
    }

    @Test
    fun testAfficherÉcranClassement() {
        val mockVue = mock(Fragment_accueil::class.java)
        val presentateur = Présentateur_accueil(mockVue)
        presentateur.afficherÉcranClassement()
        Mockito.verify(mockVue).naviguerÉcranClassement()
    }

    @Test
    fun testAfficherPointage() {
        val mockVue = mock(Fragment_accueil::class.java)
        val presentateur = Présentateur_accueil(mockVue)
        presentateur.afficherPointage()
        Mockito.verify(mockVue).montrerPointageJoueur("null")
    }

    @Test
    fun testAfficherNom() {
        val mockVue = mock(Fragment_accueil::class.java)
        val presentateur = Présentateur_accueil(mockVue)
        presentateur.afficherNomUtilisateur()
        Mockito.verify(mockVue).montrerNomUtilisateur("null")
    }
}