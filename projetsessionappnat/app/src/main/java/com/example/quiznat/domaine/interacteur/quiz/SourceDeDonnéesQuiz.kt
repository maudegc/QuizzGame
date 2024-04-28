package com.example.quiznat.domaine.interacteur.quiz


import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse

interface SourceDeDonnéesQuiz {
    val questionSport: Question?
    val questionHistoire: Question?
    val questionTechnologie: Question?
    val questionGeographie: Question?
    val questionScience: Question?
    val questionArt: Question?
    val listeReponses: List<Reponse>?
}