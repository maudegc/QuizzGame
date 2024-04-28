package com.example.quiznat.présentation.vue

import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.quiznat.MainActivity
import com.example.quiznat.R
import com.example.quiznat.domaine.entité.Joueur

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class Fragment_finTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)

        onView(withId(R.id.NomUtilisateur)).perform(click())
        onView(withId(R.id.NomUtilisateur))
            .perform(typeText("Gusty"))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.MotDePasse)).perform(click())
        onView(withId(R.id.MotDePasse))
            .perform(typeText("lala"))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.BtnConnexion)).perform(click())
        Thread.sleep(1000)
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.BtnJouer)).perform(click())
        Thread.sleep(1000)
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.btn0)).perform(click())
        Thread.sleep(3000)
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.boutonReponse1)).perform(click())
        Thread.sleep(1000)
    }
    @Test
    fun testAffichageÉcranFin() {
        onView(withId(R.id.messageFin)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.scoreFin)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.scoreFinScience)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.scoreFinAnimaux)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.scoreFinHistoire)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.scoreFinSport)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.scoreFinProgrammation)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.scoreFinGeo)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btnRejouer)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btnQuitter)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btnPartager)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )

    }
}

