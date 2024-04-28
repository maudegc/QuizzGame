package com.example.quiznat.domaine.interacteur.quiz

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse

interface ISourceDeDonnéesQuizTest {

    fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>?
    fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>?
}