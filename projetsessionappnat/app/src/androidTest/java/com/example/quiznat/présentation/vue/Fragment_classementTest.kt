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

class Fragment_classementTest {

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

        Espresso.onView(ViewMatchers.withId(R.id.Classement)).perform(ViewActions.click())
        Thread.sleep(1000)
    }

    @Test
    fun afficherClassementCategorieProgrammation() {
        Espresso.onView(ViewMatchers.withId(R.id.categorieTechnologie)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.idScoreClassement))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun afficherClassementCategorieSport() {
        Espresso.onView(ViewMatchers.withId(R.id.categorieSport)).perform(ViewActions.click())
    }

    @Test
    fun afficherClassementCategorieAnimaux() {
        Espresso.onView(ViewMatchers.withId(R.id.categorieArt)).perform(ViewActions.click())
    }

    @Test
    fun afficherClassementCategorieGeo() {
        Espresso.onView(ViewMatchers.withId(R.id.categorieGeo)).perform(ViewActions.click())
    }

    @Test
    fun afficherClassementCategorieScience() {
        Espresso.onView(ViewMatchers.withId(R.id.categorieScience)).perform(ViewActions.click())
    }

    @Test
    fun afficherClassementCategorieHistoire() {
        Espresso.onView(ViewMatchers.withId(R.id.categorieHistoire)).perform(ViewActions.click())
    }
}