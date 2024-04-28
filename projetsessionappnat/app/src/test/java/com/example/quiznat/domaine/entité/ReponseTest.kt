package com.example.quiznat.domaine.entité

import junit.framework.Assert.assertEquals
import org.junit.Test

class ReponseTest {
    @Test
    fun testAccesseurIdReponse() {
        val reponse = Reponse(27, "L’hyperglycémie", 7)
        assertEquals(27, reponse.idReponse)
    }

    @Test
    fun testAccesseurNomReponse() {
        val reponse = Reponse(1, "Un os", 1)
        assertEquals("Un os", reponse.nomReponse)
    }

    @Test
    fun testAccesseuridQuestion() {
        val reponse = Reponse(21, "Blaise Pascal", 6)
        assertEquals(6, reponse.idQuestion)
    }

}