package com.example.quiznat.présentation.présentateur

import android.os.Looper.getMainLooper
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.classement.ISourceDeDonnéesClassementTest
import com.example.quiznat.domaine.interacteur.classement.InteracteurAcquisitionDeDonnéesClassement
import com.example.quiznat.présentation.modèle.ModèleClassement
import com.example.quiznat.présentation.vue.Fragment_classement
import com.example.quiznat.présentation.vue.Fragment_login
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonClassement
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonQuiz
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class Présentateur_classementTest {

    @Test
    fun testClassementParCategorieProgrammation() {
        val mockVue = mock(Fragment_classement::class.java)
        val presentateur = Présentateur_classement(mockVue)
        val sourceBidon = SourceDeDonnéesBidonClassement()

        presentateur.setSource(sourceBidon)
        presentateur.classementParCatégorie(Categorie.PROGRAMMATION)
        presentateur._modèle.listeJoueur = sourceBidon.classementJoueurs()

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockVue).afficherMeilleurJoueurs(
            presentateur._modèle.listeJoueur,
            presentateur._modèle.categorieClassement
        )
    }

    @Test
    fun testClassementParCategorieGeographie() {
        val mockVue = mock(Fragment_classement::class.java)
        val presentateur = Présentateur_classement(mockVue)
        val sourceBidon = SourceDeDonnéesBidonClassement()

        presentateur.setSource(sourceBidon)
        presentateur.classementParCatégorie(Categorie.GEOGRAPHIE)
        presentateur._modèle.listeJoueur = sourceBidon.classementJoueurs()

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockVue).afficherMeilleurJoueurs(
            presentateur._modèle.listeJoueur,
            presentateur._modèle.categorieClassement
        )
    }

    @Test
    fun testClassementParCategorieScience() {
        val mockVue = mock(Fragment_classement::class.java)
        val presentateur = Présentateur_classement(mockVue)
        val sourceBidon = SourceDeDonnéesBidonClassement()

        presentateur.setSource(sourceBidon)
        presentateur.classementParCatégorie(Categorie.SCIENCE)
        presentateur._modèle.listeJoueur = sourceBidon.classementJoueurs()

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockVue).afficherMeilleurJoueurs(
            presentateur._modèle.listeJoueur,
            presentateur._modèle.categorieClassement
        )
    }

    @Test
    fun testClassementParCategorieHistoire() {
        val mockVue = mock(Fragment_classement::class.java)
        val presentateur = Présentateur_classement(mockVue)
        val sourceBidon = SourceDeDonnéesBidonClassement()

        presentateur.setSource(sourceBidon)
        presentateur.classementParCatégorie(Categorie.HISTOIRE)
        presentateur._modèle.listeJoueur = sourceBidon.classementJoueurs()

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockVue).afficherMeilleurJoueurs(
            presentateur._modèle.listeJoueur,
            presentateur._modèle.categorieClassement
        )
    }

    @Test
    fun testClassementParCategorieSport() {
        val mockVue = mock(Fragment_classement::class.java)
        val presentateur = Présentateur_classement(mockVue)
        val sourceBidon = SourceDeDonnéesBidonClassement()

        presentateur.setSource(sourceBidon)
        presentateur.classementParCatégorie(Categorie.SPORT)
        presentateur._modèle.listeJoueur = sourceBidon.classementJoueurs()

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockVue).afficherMeilleurJoueurs(
            presentateur._modèle.listeJoueur,
            presentateur._modèle.categorieClassement
        )
    }

    @Test
    fun testClassementParCategorieAnimaux() {
        val mockVue = mock(Fragment_classement::class.java)
        val presentateur = Présentateur_classement(mockVue)
        val sourceBidon = SourceDeDonnéesBidonClassement()

        presentateur.setSource(sourceBidon)
        presentateur.classementParCatégorie(Categorie.ANIMAUX)
        presentateur._modèle.listeJoueur = sourceBidon.classementJoueurs()


        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()

        verify(mockVue).afficherMeilleurJoueurs(
            presentateur._modèle.listeJoueur,
            presentateur._modèle.categorieClassement
        )
    }
}