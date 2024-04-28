package com.example.quiznat.présentation.présentateur

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.présentation.modèle.ModèleCatégorie
import com.example.quiznat.présentation.vue.Fragment_fin
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonJoueur
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class Présentateur_fin_partieTest {
    @Test
    fun `étant donne un presentateur, lorsque je traite le bouton recommencer le Quiz se reinitialise`() {
        val mockModele = mock(ModèleCatégorie::class.java)
        val mockVue = mock(Fragment_fin::class.java)
        val presentateur = Présentateur_fin_partie(mockVue)
        presentateur._modeleCategorie = mockModele

        presentateur.traiterBoutonRecommencer()

        verify(mockModele).réinitialiser()
    }

    @Test
    fun `étant donne un presentateur, lorsque je clique sur le bouton recommencer je navigue dans la page categorieQuiz`() {
        val mockVue = mock(Fragment_fin::class.java)
        val presentateur = Présentateur_fin_partie(mockVue)

        presentateur.traiterBoutonRecommencer()

        verify(mockVue).naviguerEcranCatégorie()
    }

    @Test
    fun `étant donne un presentateur, lorsque je traite le bouton Acceuil le Quiz se reinitialise`() {
        val mockModele = mock(ModèleCatégorie::class.java)
        val mockVue = mock(Fragment_fin::class.java)
        val presentateur = Présentateur_fin_partie(mockVue)
        presentateur._modeleCategorie = mockModele

        presentateur.traiterBoutonAcceuil()

        verify(mockModele).réinitialiser()
    }

    @Test
    fun `étant donne un presentateur, lorsque je clique sur le bouton Acceuil je navigue dans la page categorieQuiz`() {
        val mockVue = mock(Fragment_fin::class.java)
        val presentateur = Présentateur_fin_partie(mockVue)

        presentateur.traiterBoutonAcceuil()

        verify(mockVue).naviguerEcranAcceuil()
    }

    @Test
    fun `étant donné un présentateurFin et un quiz perdant, lorsque j'initialise ma vue elle appelle la methode afficher message fin`() {
        val mockVue = mock(Fragment_fin::class.java)
        val presentateur = Présentateur_fin_partie(mockVue)

        presentateur.initialiserVue()

        verify(mockVue).afficherMessageFin(false)
    }

    @Test
    fun `étant donné un présentateurFin avec le joueur bidon Maude et les scores a 0, lorsque j'initialise ma vue elle appelle la methode afficher score`() {
        val mockVue = mock(Fragment_fin::class.java)
        val presentateur = Présentateur_fin_partie(mockVue)
        presentateur.joueur = SourceDeDonnéesBidonJoueur().getJoueurParNom("Maude")
        presentateur.initialiserVue()

        verify(mockVue).afficherScore(
            mapOf(
                Categorie.SCIENCE to 0,
                Categorie.HISTOIRE to 0,
                Categorie.PROGRAMMATION to 0,
                Categorie.GEOGRAPHIE to 0,
                Categorie.SPORT to 0,
                Categorie.ANIMAUX to 0
            )
        )

    }
}