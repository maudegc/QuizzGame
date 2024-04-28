package com.example.quiznat.présentation.vue

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.quiznat.MainActivity
import com.example.quiznat.R
import org.junit.Rule
import org.junit.Test

class Fragment_loginTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAffichageLoginSansNomEtMotPasseVide() {
        onView(withId(R.id.NomUtilisateur))
            .check(
                matches(
                    withText("")
                )
            )
        onView(withId(R.id.MotDePasse))
            .check(
                matches(
                    withText("")
                )
            )
        onView(withId(R.id.BtnConnexion))
            .check(
                matches(
                    withText("Se connecter")
                )
            )
    }

    @Test
    fun testInsertionJoueur() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)

        onView(withId(R.id.NomUtilisateur))
            .perform(click())
            .perform(typeText("Maude"))
            .check(matches(withText("Maude")))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.MotDePasse))
            .perform(click())
            .perform(typeText("crosemont"))
            .check(matches(withText("crosemont")))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.BtnConnexion))
            .perform(click())
        Espresso.closeSoftKeyboard()
        Thread.sleep(1000)
        onView(withId(R.id.NomUtilisateurAccueil)).check(matches(withText("Maude")))
        onView(withId(R.id.Pointage)).check(matches(withText("62")))
    }
}