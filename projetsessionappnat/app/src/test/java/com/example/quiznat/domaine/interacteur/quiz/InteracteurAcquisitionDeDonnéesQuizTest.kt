package com.example.quiznat.domaine.interacteur.quiz

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse
import junit.framework.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class InteracteurAcquisitionDeDonnéesQuizTest {
    @Test
    fun TestGetLesQuestionUneCategorieAvecScience() {
        var source: ISourceDeDonnéesQuizTest = object : ISourceDeDonnéesQuizTest {
            override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
                if (categorie == Categorie.SCIENCE) {
                    return mutableListOf(
                        Question(1, "Qu'est-ce que le diaphragme ?", 82, Categorie.SCIENCE),
                        Question(
                            2,
                            "Combien de satellites naturels gravitent autour de la Terre ?",
                            2,
                            Categorie.SCIENCE
                        )
                    )
                } else {
                    return null
                }


            }

            override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
                TODO("Not yet implemented")
            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesQuiz(source)

        var question = interacteur.uneQuestionParCategorieTest(Categorie.SCIENCE, 0)

        Assert.assertNotNull(question)
        Assert.assertNotNull(interacteur.uneQuestionParCategorieTest(Categorie.SCIENCE, 0))
        Assert.assertEquals(
            question?.nomQuestion,
            interacteur.uneQuestionParCategorieTest(Categorie.SCIENCE, 0)?.nomQuestion
        )
    }

    @Test
    fun TestGetLesQuestionUneCategorieAvecHistoire() {
        var source: ISourceDeDonnéesQuizTest = object : ISourceDeDonnéesQuizTest {
            override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
                if (categorie == Categorie.HISTOIRE) {
                    return mutableListOf(
                        Question(
                            3,
                            "Qui a dirigé le syndicat polonais Solidarnosc dans les années 80 ?",
                            32,
                            Categorie.HISTOIRE
                        ),
                        Question(5, "Qu'est-ce que la Commune de Paris ?", 43, Categorie.HISTOIRE)
                    )
                } else {
                    return null
                }


            }

            override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
                TODO("Not yet implemented")
            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesQuiz(source)

        var question = interacteur.uneQuestionParCategorieTest(Categorie.HISTOIRE, 0)

        Assert.assertNotNull(question)
        Assert.assertNotNull(interacteur.uneQuestionParCategorieTest(Categorie.HISTOIRE, 0))
        Assert.assertEquals(
            question?.nomQuestion,
            interacteur.uneQuestionParCategorieTest(Categorie.HISTOIRE, 0)?.nomQuestion
        )
    }

    @Test
    fun TestGetLesQuestionUneCategorieAvecAnimaux() {
        var source: ISourceDeDonnéesQuizTest = object : ISourceDeDonnéesQuizTest {
            override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
                if (categorie == Categorie.ANIMAUX) {
                    return mutableListOf(
                        Question(4, "Qu’est-ce qu’une pipistrelle?", 12, Categorie.ANIMAUX),
                        Question(
                            7,
                            "Quelle race de chien est Bill, fidèle compagnon de Boule?",
                            33,
                            Categorie.ANIMAUX
                        )
                    )
                } else {
                    return null
                }


            }

            override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
                TODO("Not yet implemented")
            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesQuiz(source)

        var question = interacteur.uneQuestionParCategorieTest(Categorie.ANIMAUX, 0)

        Assert.assertNotNull(question)
        Assert.assertNotNull(interacteur.uneQuestionParCategorieTest(Categorie.ANIMAUX, 0))
        Assert.assertEquals(
            question?.nomQuestion,
            interacteur.uneQuestionParCategorieTest(Categorie.ANIMAUX, 0)?.nomQuestion
        )
    }

    @Test
    fun TestGetLesQuestionUneCategorieAvecProgrammation() {
        var source: ISourceDeDonnéesQuizTest = object : ISourceDeDonnéesQuizTest {
            override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
                if (categorie == Categorie.PROGRAMMATION) {
                    return mutableListOf(
                        Question(
                            15,
                            "Qu’est-ce qu’un attribut de classe?",
                            13,
                            Categorie.PROGRAMMATION
                        ),
                        Question(
                            32,
                            "Quelle assertion se rapproche le plus du concept d’héritage?",
                            54,
                            Categorie.PROGRAMMATION
                        )
                    )
                } else {
                    return null
                }


            }

            override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
                TODO("Not yet implemented")
            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesQuiz(source)

        var question = interacteur.uneQuestionParCategorieTest(Categorie.PROGRAMMATION, 0)

        Assert.assertNotNull(question)
        Assert.assertNotNull(interacteur.uneQuestionParCategorieTest(Categorie.PROGRAMMATION, 0))
        Assert.assertEquals(
            question?.nomQuestion,
            interacteur.uneQuestionParCategorieTest(Categorie.PROGRAMMATION, 0)?.nomQuestion
        )
    }

    @Test
    fun TestGetLesQuestionUneCategorieAvecSport() {
        var source: ISourceDeDonnéesQuizTest = object : ISourceDeDonnéesQuizTest {
            override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
                if (categorie == Categorie.SPORT) {
                    return mutableListOf(
                        Question(
                            44,
                            "Quel sport a été inventé par un pasteur canadien installé dans le Massachusetts ?",
                            33,
                            Categorie.SPORT
                        ),
                        Question(
                            29,
                            "Quel pays a remporté la Coupe du monde de Football en 1998 ?",
                            34,
                            Categorie.SPORT
                        )
                    )
                } else {
                    return null
                }


            }

            override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
                TODO("Not yet implemented")
            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesQuiz(source)

        var question = interacteur.uneQuestionParCategorieTest(Categorie.SPORT, 0)

        Assert.assertNotNull(question)
        Assert.assertNotNull(interacteur.uneQuestionParCategorieTest(Categorie.SPORT, 0))
        Assert.assertEquals(
            question?.nomQuestion,
            interacteur.uneQuestionParCategorieTest(Categorie.SPORT, 0)?.nomQuestion
        )
    }

    @Test
    fun TestGetLesQuestionUneCategorieAvecGeographie() {
        var source: ISourceDeDonnéesQuizTest = object : ISourceDeDonnéesQuizTest {
            override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
                if (categorie == Categorie.GEOGRAPHIE) {
                    return mutableListOf(
                        Question(
                            34,
                            "Quel continent compte le plus grand nombre de pays ?",
                            37,
                            Categorie.GEOGRAPHIE
                        ),
                        Question(
                            49,
                            "Quel est le fleuve qui a le plus fort débit au monde ?",
                            39,
                            Categorie.GEOGRAPHIE
                        )
                    )
                } else {
                    return null
                }
            }

            override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
                TODO("Not yet implemented")
            }
        }

        var interacteur = InteracteurAcquisitionDeDonnéesQuiz(source)

        var question = interacteur.uneQuestionParCategorieTest(Categorie.GEOGRAPHIE, 0)

        Assert.assertNotNull(question)
        Assert.assertNotNull(interacteur.uneQuestionParCategorieTest(Categorie.GEOGRAPHIE, 0))
        Assert.assertEquals(
            question?.nomQuestion,
            interacteur.uneQuestionParCategorieTest(Categorie.GEOGRAPHIE, 0)?.nomQuestion
        )
    }

    @Test
    fun TestGetLesReponsesDeUneQuestionAvecUneQuestion() {
        var source: ISourceDeDonnéesQuizTest = object : ISourceDeDonnéesQuizTest {
            override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
                TODO("Not yet implemented")
            }

            override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
                if (idQuestion == 1) {
                    return mutableListOf(

                        Reponse(1, "Un os", 2),
                        Reponse(2, "Un muscle", 2),
                        Reponse(3, "une vertebre", 2),
                        Reponse(4, "Un tendon", 2)
                    )
                } else if (idQuestion == 2) {
                    return mutableListOf(
                        Reponse(57, "l'Asie", 1),
                        Reponse(58, "L'Europe", 1),
                        Reponse(59, "L'Afrique", 1),
                        Reponse(4, "L'Amérique", 1)
                    )
                }
                return null
            }
        }

        var interacteur = InteracteurAcquisitionDeDonnéesQuiz(source)
        var question = Question(1, "Qu'est-ce que le diaphragme ?", 2, Categorie.SCIENCE);
        var listeReponses = interacteur.getLesReponsesDeUneQuestion(question.idQuestion)

        for (i in 0 until 4) {
            Assert.assertNotNull(listeReponses)
            Assert.assertNotNull(interacteur.getLesReponsesDeUneQuestion(question.idQuestion))
            Assert.assertEquals(
                listeReponses?.get(i)?.nomReponse,
                interacteur.getLesReponsesDeUneQuestion(question.idQuestion)?.get(i)?.nomReponse
            )
        }
    }
}

