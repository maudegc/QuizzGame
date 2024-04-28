package com.example.quiznat.présentation.vue

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.quiznat.MainActivity
import com.example.quiznat.R
import org.junit.Before
import org.junit.Test

class Fragment_accueilTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUpLogin() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)

        onView(withId(R.id.NomUtilisateur)).perform(click())
        onView(withId(R.id.NomUtilisateur)).perform(typeText("Maude"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.MotDePasse)).perform(click())
        onView(withId(R.id.MotDePasse)).perform(typeText("crosemont"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.BtnConnexion)).perform(click())
        Thread.sleep(1000)
    }

    @Test
    fun testAffichageJoueurNomEtPointage() {
        onView(withId(R.id.NomUtilisateurAccueil)).check(matches(withText("Maude")))
        onView(withId(R.id.Pointage)).check(matches(withText("62")))
    }

    @Test
    fun testAffichageÉcranAccueil() {
        onView(withId(R.id.LogoAccueil)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.TitreAccueil)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.BtnJouer)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.BtnDeconnexion)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.TxtPointage)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.TxtClassement)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.Classement)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}