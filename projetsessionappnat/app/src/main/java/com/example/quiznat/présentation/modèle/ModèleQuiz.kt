package com.example.quiznat.présentation.modèle

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse
import com.example.quiznat.domaine.interacteur.quiz.InteracteurAcquisitionDeDonnéesQuiz
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonQuiz

/**
 * Objet ModèleQuiz contient un quiz avec les questions et réponses
 *
 */
object ModèleQuiz {

    var uneQuestion: Question? = null
    var lesReponses: List<Reponse>? = null
    var lesScores = mutableMapOf<Categorie, Int>(
        Categorie.SCIENCE to 0,
        Categorie.HISTOIRE to 0,
        Categorie.PROGRAMMATION to 0,
        Categorie.GEOGRAPHIE to 0,
        Categorie.SPORT to 0,
        Categorie.ANIMAUX to 0
    )

    fun viderListeReponses() {
        lesReponses = null
    }

}