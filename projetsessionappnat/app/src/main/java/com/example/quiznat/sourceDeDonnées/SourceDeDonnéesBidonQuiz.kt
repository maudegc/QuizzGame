package com.example.quiznat.sourceDeDonnées

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse
import com.example.quiznat.domaine.interacteur.quiz.ISourceDeDonnéesQuizTest
import com.example.quiznat.domaine.interacteur.quiz.SourceDeDonnéesQuiz

class SourceDeDonnéesBidonQuiz() : ISourceDeDonnéesQuizTest {
    /**
     * Fonction qui permet d'aller chercher les question tout dépendament de la catégorie choisit
     *
     * @param categorie catégorie choisit par l'utilisateur
     * @return retourne la liste de question correspondant à la catégorie
     */
    override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {

        when (categorie) {
            Categorie.SPORT -> {
                var listeQuestionSport = mutableListOf(
                    Question(
                        10,
                        "Quel est le sport le plus populaire au monde ?",
                        5,
                        Categorie.SPORT
                    ),
                    Question(2, "Quelle est la marque de la pomme", 2, Categorie.SPORT)

                )
                return listeQuestionSport

            }
            Categorie.PROGRAMMATION -> {

                var listeQuestionProgrammation = mutableListOf(
                    Question(
                        12,
                        "Quel langage est le plus utilisé en programmation ?",
                        5,
                        Categorie.PROGRAMMATION
                    ),
                    Question(2, "Quelle est la marque de la pomme", 2, Categorie.PROGRAMMATION)

                )
                return listeQuestionProgrammation
            }
            Categorie.SCIENCE -> {
                var listeQuestionScience = mutableListOf(
                    Question(1, "Qu'est-ce que la Commune de Paris ?", 82, Categorie.SCIENCE),
                    Question(2, "Quelle est la marque de la pomme", 2, Categorie.SCIENCE)

                )
                return listeQuestionScience

            }
            Categorie.HISTOIRE -> {

                var listeQuestionHistoire = mutableListOf(
                    Question(50, "Qu'est-ce que la Commune de Paris ?", 82, Categorie.HISTOIRE),
                    Question(2, "Quelle est la marque de la pomme", 2, Categorie.HISTOIRE)

                )
                return listeQuestionHistoire
            }

            Categorie.GEOGRAPHIE -> {

                var listeQuestionGeographie = mutableListOf(
                    Question(
                        17,
                        "Quel est le plus grand pays du continent africain ?",
                        66,
                        Categorie.GEOGRAPHIE
                    ),
                    Question(
                        2,
                        "Sur une carte au 1:250.00, combien représente un centimètre ?",
                        2,
                        Categorie.GEOGRAPHIE
                    )

                )
                return listeQuestionGeographie
            }
            Categorie.ANIMAUX -> {

                var listeQuestionAnimaux = mutableListOf(
                    Question(18, "Quel est l'animal le plus dangereux ?", 5, Categorie.ANIMAUX),
                    Question(2, "Quelle est la marque de la pomme", 2, Categorie.ANIMAUX)

                )
                return listeQuestionAnimaux
            }

        }
        return null

    }

    /**
     * Fonction qui permet d'afficher les réponses dépendamment de la question
     *
     * @param idQuestion id de la question
     * @return retourne tout les choix de réponses correspondant à la question
     */
    override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
        if (idQuestion == 0) {
            var listeReponses = mutableListOf(
                Reponse(1, "Microsoft", 0),
                Reponse(3, "Twitter", 0),
                Reponse(2, "Apple°", 0),
                Reponse(4, "Facebook", 0)


            )
            return listeReponses
        } else if (idQuestion == 1) {
            var listeReponses = mutableListOf(
                Reponse(57, "l'Asie", 1),
                Reponse(58, "L'Europe", 1),
                Reponse(59, "L'Afrique", 1),
                Reponse(4, "L'Amérique", 1)
            )
            return listeReponses
        }
        return null
    }


}