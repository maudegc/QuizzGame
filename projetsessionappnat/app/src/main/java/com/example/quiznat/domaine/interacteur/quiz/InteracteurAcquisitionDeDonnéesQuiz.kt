package com.example.quiznat.domaine.interacteur.quiz

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse

/**
 * Classe InteracteurAcquisitionDeDonnéesQuiz intéragit avec l'Api
 * afin d'acquérir les données concernant les questions et réponeses
 *
 * @param _source
 */
class InteracteurAcquisitionDeDonnéesQuiz(var _source: ISourceDeDonnéesQuizTest?) {
    var _listeQuestion: List<Question>? = null
    var _listeReponses: List<Reponse>? = null

    fun getLesReponsesDeUneQuestion(idQuestion: Int?): List<Reponse>? {
        var idQuestion = idQuestion
        var listeReponse = _source?.getLesReponsesUneQuestion(idQuestion)
        _listeReponses = listeReponse
        return listeReponse
    }

    fun uneQuestionParCategorie(categorie: Categorie?): Question? {

        when (categorie) {
            Categorie.SPORT -> {
                var listeQuestionsSport = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = (0..9).random()
                var questionSport = listeQuestionsSport?.get(rnds)
                var id = questionSport?.nomQuestion
                return questionSport
            }
            Categorie.PROGRAMMATION -> {
                var listeQuestionProgrammation = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = (0..9).random()
                var questionProgrammation = listeQuestionProgrammation?.get(rnds)
                var id = questionProgrammation?.nomQuestion
                return questionProgrammation
            }
            Categorie.HISTOIRE -> {
                var listeQuestionsHistoire = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = (0..9).random()
                var questionHistoire = listeQuestionsHistoire?.get(rnds)
                var id = questionHistoire?.nomQuestion
                return questionHistoire
            }
            Categorie.SCIENCE -> {
                var listeQuestionsScience = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = (0..9).random()
                var questionScience = listeQuestionsScience?.get(rnds)
                var id = questionScience?.nomQuestion
                return questionScience
            }
            Categorie.GEOGRAPHIE -> {
                var listeQuestionsGeographie = _source?.getLesQuestionsUneCategorie(categorie)

                val rnds = (0..9).random()
                var questionGeo = listeQuestionsGeographie?.get(rnds)
                var id = questionGeo?.nomQuestion
                return questionGeo
            }
            Categorie.ANIMAUX -> {
                var listeQuestionsAnimaux = _source?.getLesQuestionsUneCategorie(categorie)

                val rnds = (0..9).random()
                var questionAnimaux = listeQuestionsAnimaux?.get(rnds)
                var id = questionAnimaux?.nomQuestion
                return questionAnimaux
            }
            else -> {
                return null
            }
        }
    }

    fun uneQuestionParCategorieTest(categorie: Categorie?, nbrAleatoire: Int): Question? {

        when (categorie) {
            Categorie.SPORT -> {
                var listeQuestionsSport = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = nbrAleatoire
                var questionSport = listeQuestionsSport?.get(rnds)
                var id = questionSport?.nomQuestion
                return questionSport
            }
            Categorie.PROGRAMMATION -> {
                var listeQuestionProgrammation = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = nbrAleatoire
                var questionProgrammation = listeQuestionProgrammation?.get(rnds)
                var id = questionProgrammation?.nomQuestion
                return questionProgrammation
            }
            Categorie.HISTOIRE -> {
                var listeQuestionsHistoire = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = nbrAleatoire
                var questionHistoire = listeQuestionsHistoire?.get(rnds)
                var id = questionHistoire?.nomQuestion
                return questionHistoire
            }
            Categorie.SCIENCE -> {
                var listeQuestionsScience = _source?.getLesQuestionsUneCategorie(categorie)
                val rnds = nbrAleatoire
                var questionScience = listeQuestionsScience?.get(rnds)
                var id = questionScience?.nomQuestion
                return questionScience
            }
            Categorie.GEOGRAPHIE -> {
                var listeQuestionsGeographie = _source?.getLesQuestionsUneCategorie(categorie)

                val rnds = nbrAleatoire
                var questionGeo = listeQuestionsGeographie?.get(rnds)
                var id = questionGeo?.nomQuestion
                return questionGeo
            }
            Categorie.ANIMAUX -> {
                var listeQuestionsAnimaux = _source?.getLesQuestionsUneCategorie(categorie)

                val rnds = nbrAleatoire
                var questionAnimaux = listeQuestionsAnimaux?.get(rnds)
                var id = questionAnimaux?.nomQuestion
                return questionAnimaux
            }
            else -> {
                return null
            }
        }
    }
}