package com.example.quiznat.présentation.présentateur

import com.example.quiznat.présentation.vue.Fragment_login
import android.os.Looper.getMainLooper
import android.util.Log
import androidx.fragment.app.testing.FragmentScenario
import androidx.lifecycle.Lifecycle
import androidx.test.platform.app.InstrumentationRegistry
import com.example.quiznat.R
import com.example.quiznat.présentation.vue.Fragment_accueil
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonJoueur
import junit.framework.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class Présentateur_loginTest {
    @Test
    fun `étant donné un nom vide et un mot de passe saisit, lorsque je me connecte, j'obtiens un message d'erreur approprié`() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)

        presentateur.seConnecter("", "crosemont")

        verify(mockVue).alert("Insérez votre nom")
        verify(mockVue).naviguerÉcranLogin()
    }

    @Test
    fun `étant donné un nom saisit et un mot de passe vide, lorsque je me connecte, j'obtiens un message d'erreur apprprié`() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)

        presentateur.seConnecter("Toto", "")

        verify(mockVue).alert("Insérez votre mot de passe")
        verify(mockVue).naviguerÉcranLogin()
    }

    @Test
    fun `étant donné un nom et un mot de passe vide, lorsque je me connecte, j'obtiens un message d'erreur approprié`() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)

        presentateur.seConnecter("", "")

        verify(mockVue).alert("Insérez vos informations")
        verify(mockVue).naviguerÉcranLogin()
    }

    @Test
    fun `étant donné un nom invalide et un mot de passe valide, lorsque je me connecte, j'obtiens un message d'erreur approprié`() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)
        val sourceBidon = SourceDeDonnéesBidonJoueur()

        presentateur.setSource(sourceBidon)
        presentateur.seConnecter("fff", "crosemont")

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()

        verify(mockVue).alert("Le nom ou le mot de passe est invalide")
        verify(mockVue).naviguerÉcranLogin()

    }

    @Test
    fun `étant donné un nom valide et un mot de passe invalide, lorsque je me connecte, j'obtiens un message d'erreur approprié`() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)
        val sourceBidon = SourceDeDonnéesBidonJoueur()

        presentateur.setSource(sourceBidon)
        presentateur.seConnecter("Maude", "Toto")

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()

        verify(mockVue).alert("Le nom ou le mot de passe est invalide")
        verify(mockVue).naviguerÉcranLogin()
    }

    @Test
    fun `étant donné un nom invalide et un mot de passe invalide, lorsque je me connecte, j'obtiens un message d'erreur approprié`() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)
        val sourceBidon = SourceDeDonnéesBidonJoueur()

        presentateur.setSource(sourceBidon)
        presentateur.seConnecter("Tata", "Toto")

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()

        verify(mockVue).alert("Le nom ou le mot de passe est invalide")
        verify(mockVue).naviguerÉcranLogin()
    }

    @Test
    fun `étant donné un nom valide et un mot de passe valide, lorsque je me connecte, j'obtiens la vue accueil`() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)
        val sourceBidon = SourceDeDonnéesBidonJoueur()

        presentateur.setSource(sourceBidon)
        presentateur.seConnecter("Maude", "crosemont")

        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()

        verify(mockVue).naviguerÉcranAccueil()
    }

    @Test
    fun testAfficherÉcranInscription() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)

        presentateur.afficherÉcranInscription()

        verify(mockVue).naviguerÉcranInscription()
    }

    @Test
    fun testAfficherÉcranAccueil() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)

        presentateur.afficherÉcranAccueil()

        verify(mockVue).naviguerÉcranAccueil()
    }

    @Test
    fun testAfficherÉcranLogin() {
        val mockVue = mock(Fragment_login::class.java)
        val presentateur = Présentateur_login(mockVue)

        presentateur.afficherÉcranLogin()

        verify(mockVue).naviguerÉcranLogin()
    }
}