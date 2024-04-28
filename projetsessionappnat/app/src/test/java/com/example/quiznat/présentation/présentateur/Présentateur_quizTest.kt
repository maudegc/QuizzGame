package com.example.quiznat.présentation.présentateur

import android.os.Looper
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.présentation.vue.Fragment_quiz
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonQuiz
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class Présentateur_quizTest {
    @Test
    fun testQuestionSuivanteAvecCategorieScience() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()
        val question = Question(1, "Qu'est-ce que la Commune de Paris ?", 82, Categorie.SCIENCE)

        presentateur.setSource(sourceBidon)
        presentateur.questionSuivante(Categorie.SCIENCE);
        presentateur.reponseSuivante(1)
        presentateur._modèle.uneQuestion = question

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).afficherQuestion(presentateur._modèle.uneQuestion)
    }

    @Test
    fun testQuestionSuivanteAvecCategorieHistoire() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()
        val question = Question(50, "Qu'est-ce que la Commune de Paris ?", 82, Categorie.HISTOIRE)

        presentateur.setSource(sourceBidon)
        presentateur.questionSuivante(Categorie.HISTOIRE)
        presentateur.reponseSuivante(50)
        presentateur._modèle.uneQuestion = question

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).afficherQuestion(presentateur._modèle.uneQuestion)
    }

    @Test
    fun testQuestionSuivanteAvecCategorieGeographie() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()
        val question = Question(
            17,
            "Quel est le plus grand pays du continent africain ?",
            66,
            Categorie.GEOGRAPHIE
        )

        presentateur.setSource(sourceBidon)
        presentateur.questionSuivante(Categorie.GEOGRAPHIE)
        presentateur.reponseSuivante(17)
        presentateur._modèle.uneQuestion = question

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).afficherQuestion(presentateur._modèle.uneQuestion)
    }

    @Test
    fun testQuestionSuivanteAvecCategorieSport() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()
        val question =
            Question(10, "Quel est le sport le plus populaire au monde ?", 5, Categorie.SPORT)

        presentateur.setSource(sourceBidon)
        presentateur.questionSuivante(Categorie.SPORT)
        presentateur.reponseSuivante(10)
        presentateur._modèle.uneQuestion = question

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).afficherQuestion(presentateur._modèle.uneQuestion)
    }

    @Test
    fun testQuestionSuivanteAvecCategorieProgrammation() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()
        val question = Question(
            12,
            "Quel langage est le plus utilisé en programmation ?",
            5,
            Categorie.PROGRAMMATION
        )

        presentateur.setSource(sourceBidon)
        presentateur.questionSuivante(Categorie.PROGRAMMATION)
        presentateur.reponseSuivante(12)
        presentateur._modèle.uneQuestion = question

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).afficherQuestion(presentateur._modèle.uneQuestion)
    }

    @Test
    fun testQuestionSuivanteAvecCategorieAnimaux() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()
        val question = Question(18, "Quel est l'animal le plus dangereux ?", 5, Categorie.ANIMAUX)

        presentateur.setSource(sourceBidon)
        presentateur.questionSuivante(Categorie.ANIMAUX)
        presentateur.reponseSuivante(18)
        presentateur._modèle.uneQuestion = question

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).afficherQuestion(presentateur._modèle.uneQuestion)
    }

    @Test
    fun testReponsesSuivanteAvecQuestionExistante() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()

        presentateur.setSource(sourceBidon)
        presentateur.reponseSuivante(0)
        presentateur._modèle.lesReponses = sourceBidon.getLesReponsesUneQuestion(0)

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).afficherReponses(presentateur._modèle.lesReponses)
    }

    @Test
    fun testReponsesSuivanteAvecQuestionIexistante() {
        val mockVue = mock(Fragment_quiz::class.java)
        val presentateur = Présentateur_quiz(mockVue)
        val sourceBidon = SourceDeDonnéesBidonQuiz()

        presentateur.setSource(sourceBidon)
        presentateur.reponseSuivante(3)
        presentateur._modèle.lesReponses = sourceBidon.getLesReponsesUneQuestion(3)

        Thread.sleep(1000)
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        verify(mockVue).afficherReponses(presentateur._modèle.lesReponses)
    }

}