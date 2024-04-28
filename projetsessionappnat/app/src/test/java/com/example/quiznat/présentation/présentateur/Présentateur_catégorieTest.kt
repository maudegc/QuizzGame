package com.example.quiznat.présentation.présentateur

import android.os.Looper
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.présentation.modèle.ModèleCatégorie
import com.example.quiznat.présentation.vue.Fragment_catégorie
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse

import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class Présentateur_catégorieTest {
    @Test
    fun testInitialiserVueSiGagant() {
        val mockVue = mock(Fragment_catégorie::class.java)
        val mockModele = mock(ModèleCatégorie::class.java)
        val presentateur = Présentateur_catégorie(mockVue)

        presentateur._modele = mockModele
        `when`(mockModele.aGagne()).thenReturn(true)
        presentateur.initialiserVue()

        verify(mockVue).naviguerÉcranFin()
    }

    @Test
    fun testInitialiserVueSiPerd() {
        val mockVue = mock(Fragment_catégorie::class.java)
        val presentateur = Présentateur_catégorie(mockVue)
        val mockModele = mock(ModèleCatégorie::class.java)

        presentateur._modele = mockModele
        `when`(mockModele.aGagne()).thenReturn(false)
        presentateur.initialiserVue()

        verify(mockModele).melanger()
    }

    @Test
    fun testChoisirCatégorie() {
        val mockVue = mock(Fragment_catégorie::class.java)
        val presentateur = Présentateur_catégorie(mockVue)

        val categorie = presentateur.choisirCategorie(0)

        verify(mockVue).disableBoutons()
        verify(mockVue).afficherCategorie(Categorie.SCIENCE, 0)
        assertEquals(Categorie.SCIENCE, categorie)
    }

    @Test
    fun testActiverCategories() {
        val mockVue = mock(Fragment_catégorie::class.java)
        val presentateur = Présentateur_catégorie(mockVue)
        val mockModele = mock(ModèleCatégorie::class.java)

        mockModele.getCategorieActive()
        presentateur.activerCategories()

        verify(mockModele).getCategorieActive()
    }

    @Test
    fun testActiverCategorie() {
        val mockVue = mock(Fragment_catégorie::class.java)
        val presentateur = Présentateur_catégorie(mockVue)
        val mockModele = mock(ModèleCatégorie::class.java)

        mockModele.completerCategorie(Categorie.SCIENCE)
        presentateur._modele = mockModele
        presentateur.activerCategories()

        verify(mockModele).completerCategorie(Categorie.SCIENCE)
    }

}