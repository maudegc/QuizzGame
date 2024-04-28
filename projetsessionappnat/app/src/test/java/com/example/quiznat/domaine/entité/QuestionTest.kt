package com.example.quiznat.domaine.entité


import com.example.quiznat.domaine.entité.Question

import junit.framework.Assert.assertEquals
import org.junit.Test

class QuestionTest {
    @Test
    fun testAccesseurIdQuestion() {
        val question = Question(
            20,
            "Sur combien de pays s'étend le désert du sahara ?",
            78,
            Categorie.GEOGRAPHIE
        )
        assertEquals(20, question.idQuestion)
    }

    @Test
    fun testAccesseurNomQuestion() {
        val question = Question(1, "Qu'est-ce que le diaphragme ?", 2, Categorie.SCIENCE)
        assertEquals("Qu'est-ce que le diaphragme ?", question.nomQuestion)
    }

    @Test
    fun testAccesseurIdBonneReponse() {
        val question =
            Question(18, "Lequel de ces pays est le plus peuplé ?", 71, Categorie.GEOGRAPHIE)
        assertEquals(71, question.idBonneReponse)
    }

    @Test
    fun testAccesseurCategorie() {
        val question = Question(
            28,
            "Qui était le premier ministre d’Israël entre 1969 et 1974 ?",
            110,
            Categorie.HISTOIRE
        )
        assertEquals("HISTOIRE", question.categorie.toString())
    }

}