package com.example.quiznat.présentation.vue

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.quiznat.MainActivity
import com.example.quiznat.R
import org.junit.Before
import org.junit.Test

class Fragment_quizTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUpLogin() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)

        Espresso.onView(ViewMatchers.withId(R.id.NomUtilisateur)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.NomUtilisateur))
            .perform(ViewActions.typeText("Maxime"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.MotDePasse)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.MotDePasse))
            .perform(ViewActions.typeText("Chevalier"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.BtnConnexion)).perform(ViewActions.click())
        Thread.sleep(1000)

        Espresso.onView(ViewMatchers.withId(R.id.BtnJouer)).perform(ViewActions.click())
        Thread.sleep(1000)
    }

    @Test
    fun étant_donné_un_fragment_quiz_lorsque_je_clique_sur_le_bouton0_categorie_jobtiens_écran_quiz_de_cette_categorie() {
        Espresso.onView(ViewMatchers.withId(R.id.btn0)).perform(ViewActions.click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.fragment_quiz))
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.laQuestion))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun étant_donné_un_fragment_quiz_lorsque_je_clique_sur_le_bouton1_categorie_jobtiens_écran_quiz_de_cette_categorie() {
        Espresso.onView(ViewMatchers.withId(R.id.btn1)).perform(ViewActions.click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.fragment_quiz))
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.laQuestion))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun étant_donné_un_fragment_quiz_lorsque_je_clique_sur_le_bouton2_categorie_jobtiens_écran_quiz_de_cette_categorie() {
        Espresso.onView(ViewMatchers.withId(R.id.btn2)).perform(ViewActions.click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.fragment_quiz))
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.laQuestion))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun étant_donné_un_fragment_quiz_lorsque_je_clique_sur_le_bouton3_categorie_jobtiens_écran_quiz_de_cette_categorie() {
        Espresso.onView(ViewMatchers.withId(R.id.btn3)).perform(ViewActions.click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.fragment_quiz))
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.laQuestion))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun étant_donné_un_fragment_quiz_lorsque_je_clique_sur_le_bouton4_categorie_jobtiens_écran_quiz_de_cette_categorie() {
        Espresso.onView(ViewMatchers.withId(R.id.btn4)).perform(ViewActions.click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.fragment_quiz))
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.laQuestion))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun étant_donné_un_fragment_quiz_lorsque_je_clique_sur_le_bouton5_categorie_jobtiens_écran_quiz_de_cette_categorie() {
        Espresso.onView(ViewMatchers.withId(R.id.btn5)).perform(ViewActions.click())
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.fragment_quiz))
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.laQuestion))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }
}