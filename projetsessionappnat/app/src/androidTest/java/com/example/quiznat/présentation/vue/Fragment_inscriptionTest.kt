package com.example.quiznat.présentation.vue

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.quiznat.MainActivity
import com.example.quiznat.R

import org.junit.Before
import org.junit.Test

class Fragment_inscriptionTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUpInscription() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
        onView(withId(R.id.CreerCompte)).perform(click())
    }

    @Test
    fun testInscription() {
        onView(withId(R.id.NomUtilisateurInscription)).perform(click())
        onView(withId(R.id.NomUtilisateurInscription)).perform(typeText("Toto"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.MotDePasse1)).perform(click())
        onView(withId(R.id.MotDePasse1)).perform(typeText("tata"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.MotDePasse2)).perform(click())
        onView(withId(R.id.MotDePasse2)).perform(typeText("tata"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.BtnCreer)).perform(click())
        Thread.sleep(1000)

        onView(withId(R.id.NomUtilisateurAccueil)).check(matches(withText("Toto")))
        onView(withId(R.id.Pointage)).check(matches(withText("0")))
    }

    @Test
    fun testAfficherÉcranInscription() {
        onView(withId(R.id.NomUtilisateurInscription)).check(matches(withText("")))
        onView(withId(R.id.MotDePasse1)).check(matches(withText("")))
        onView(withId(R.id.MotDePasse2)).check(matches(withText("")))
        onView(withId(R.id.BtnCreer)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.BtnCreer)).check(matches(withText("Créer compte")))
        onView(withId(R.id.Titre)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.Titre)).check(matches(withText("Créer un compte")))
        onView(withId(R.id.Logo)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}