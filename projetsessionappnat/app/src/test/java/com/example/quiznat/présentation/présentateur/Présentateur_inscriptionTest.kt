package com.example.quiznat.présentation.présentateur

import android.os.Looper
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.présentation.vue.Fragment_inscription
import com.example.quiznat.présentation.vue.Fragment_login
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonJoueur
import org.mockito.Mockito.verify
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class Présentateur_inscriptionTest {
    @Test
    fun `étant donné un nom vide, un mot de passe saisit et une confirmation du mot de passe saisit, lorsque je m'inscris, j'obtiens un message d'erreur approprié`() {
        val mockVue = Mockito.mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)

        presentateur.créerCompte("", "crosemont", "crosemont")

        verify(mockVue).alert("Insérez un nom")
    }

    @Test
    fun `étant donné un nom saisit, un mot de passe vide et une confirmation du mot de passe saisit, lorsque je m'inscris, j'obtiens un message d'erreur approprié`() {
        val mockVue = Mockito.mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)

        presentateur.créerCompte("Toto", "", "crosemont")

        verify(mockVue).alert("Insérez un mot de passe")
    }

    @Test
    fun `étant donné un nom saisit, un mot de passe saisit et une confirmation du mot de passe vide, lorsque je m'inscris, j'obtiens un message d'erreur approprié`() {
        val mockVue = Mockito.mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)

        presentateur.créerCompte("Toto", "crosemont", "")

        verify(mockVue).alert("Confirmez votre mot de passe")
    }

    @Test
    fun `étant donné un nom saisit, un mot de passe différent de la confirmation du mot de passe, lorsque je m'inscris, j'obtiens un message d'erreur approprié`() {
        val mockVue = Mockito.mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)

        presentateur.créerCompte("Toto", "crosemont", "ros")

        verify(mockVue).alert("Mots de passe différents")
    }

    @Test
    fun `étant donné un nom saisit déjà existant, lorsque je m'inscris, j'obtiens un message d'erreur approprié`() {
        val mockVue = mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)
        val sourceBidon = SourceDeDonnéesBidonJoueur()

        presentateur.setSource(sourceBidon)
        presentateur.créerCompte("Maude", "c", "c")

        Thread.sleep(100)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).alert("Le nom existe déjà")
    }

    @Test
    fun `étant donné un nom saisit non existant, lorsque je m'inscris, j'obtiens un nouveau joueur et l'écran d'accueil`() {
        val mockVue = Mockito.mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)
        val sourceBidon = SourceDeDonnéesBidonJoueur()


        presentateur.setSource(sourceBidon)
        presentateur.créerCompte("Toto", "tata", "tata")

        Thread.sleep(100)
        Shadows.shadowOf(Looper.getMainLooper()).idle()

        verify(mockVue).naviguerÉcranAccueil()
    }

    @Test
    fun testAfficherÉcranAccueil() {
        val mockVue = Mockito.mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)

        presentateur.afficherÉcranAccueil()

        verify(mockVue).naviguerÉcranAccueil()
    }

    @Test
    fun testAfficherÉcranLogin() {
        val mockVue = Mockito.mock(Fragment_inscription::class.java)
        val presentateur = Présentateur_inscription(mockVue)

        presentateur.afficherÉcranLogin()

        verify(mockVue).naviguerÉcranLogin()
    }
}