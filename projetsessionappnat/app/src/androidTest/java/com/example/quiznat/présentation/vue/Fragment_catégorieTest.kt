package com.example.quiznat.présentation.vue

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.example.quiznat.MainActivity
import com.example.quiznat.R
import com.example.quiznat.domaine.entité.Joueur

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import java.util.regex.Pattern.matches
import kotlin.concurrent.thread

class Fragment_catégorieTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)

        onView(withId(R.id.NomUtilisateur)).perform(click())
        onView(withId(R.id.NomUtilisateur))
            .perform(ViewActions.typeText("Gusty"))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.MotDePasse)).perform(click())
        onView(ViewMatchers.withId(R.id.MotDePasse))
            .perform(ViewActions.typeText("lala"))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.BtnConnexion)).perform(click())
        Thread.sleep(1000)
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.BtnJouer)).perform(click())
        Thread.sleep(1000)
    }

    @Test
    fun étant_donné_un_fragment_catégorie_lorsque_je_clique_sur_une_catégorie_obtiens_image_catérogie() {
        onView(withId(R.id.btn0)).perform(click())
        Espresso.closeSoftKeyboard()
        Thread.sleep(1000)
        onView(withId(R.id.img0)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun étant_donné_un_fragment_catégorie_lorsque_je_clique_sur_une_catégorie_obtiens_écran_du_quiz() {
        onView(withId(R.id.btn0)).perform(click())
        Espresso.closeSoftKeyboard()
        Thread.sleep(1000)
        onView(withId(R.id.fragment_quiz))
    }

    @Test
    fun testAffichageÉcranCatégorie() {
        onView(withId(R.id.titre)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btn0)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btn1)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btn2)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btn3)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btn4)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.btn5)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.img0)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.img1)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.img2)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.img3)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.img4)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.img5)).check(
            ViewAssertions.matches(
                withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )

    }

}