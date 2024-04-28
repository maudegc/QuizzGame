package com.example.quiznat.domaine.interacteur.classement

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.présentation.modèle.ModèleClassement
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonClassement
import junit.framework.Assert.*
import org.junit.Assert
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertThat
import org.junit.Test

class InteracteurAcquisitionDeDonnéesClassementTest {
    @Test
    fun testMéthodeClassementParCategorieParCategorieProgrammation() {
        var source: ISourceDeDonnéesClassementTest = object : ISourceDeDonnéesClassementTest {
            override fun classementJoueurs(): List<Joueur>? {

                var joueur1 = Joueur("Maude", "crosemont")
                var joueur2 = Joueur("Jean", "crosemont")
                var joueur3 = Joueur("Maxime", "crosemont")
                var joueur4 = Joueur("Gusty", "crosemont")
                var joueur5 = Joueur("Patrick", "crosemont")
                joueur1.scoreProgrammation = 5
                joueur2.scoreProgrammation = 10
                joueur3.scoreProgrammation = 2
                joueur4.scoreProgrammation = 1
                joueur5.scoreProgrammation = 6
                return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)


            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesClassement(source)

        val listeJoueurs = interacteur.classementParCategorie(Categorie.PROGRAMMATION)
        for (i in 0 until 5) {
            assertNotNull(listeJoueurs?.get(i))
            assertNotNull(interacteur.classementParCategorie(Categorie.PROGRAMMATION)?.get(i))
            assertEquals(
                listeJoueurs?.get(i)?.nom,
                interacteur.classementParCategorie(Categorie.PROGRAMMATION)?.get(i)?.nom
            )
        }
    }


    @Test
    fun testMéthodeClassementParCategorieParCategorieScience() {
        var source: ISourceDeDonnéesClassementTest = object : ISourceDeDonnéesClassementTest {
            override fun classementJoueurs(): List<Joueur>? {

                var joueur1 = Joueur("Maude", "crosemont")
                var joueur2 = Joueur("Jean", "crosemont")
                var joueur3 = Joueur("Maxime", "crosemont")
                var joueur4 = Joueur("Gusty", "crosemont")
                var joueur5 = Joueur("Patrick", "crosemont")
                joueur1.scoreScience = 4
                joueur2.scoreScience = 3
                joueur3.scoreScience = 15
                joueur4.scoreScience = 3
                joueur5.scoreScience = 4
                return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)


            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesClassement(source)

        val listeJoueurs = interacteur.classementParCategorie(Categorie.SCIENCE)
        for (i in 0 until 5) {
            assertNotNull(listeJoueurs?.get(i))
            assertNotNull(interacteur.classementParCategorie(Categorie.SCIENCE)?.get(i))
            assertEquals(
                listeJoueurs?.get(i)?.nom,
                interacteur.classementParCategorie(Categorie.SCIENCE)?.get(i)?.nom
            )
        }
    }

    @Test
    fun testMéthodeClassementParCategorieParCategorieHistoire() {
        var source: ISourceDeDonnéesClassementTest = object : ISourceDeDonnéesClassementTest {
            override fun classementJoueurs(): List<Joueur>? {

                var joueur1 = Joueur("Maude", "crosemont")
                var joueur2 = Joueur("Jean", "crosemont")
                var joueur3 = Joueur("Maxime", "crosemont")
                var joueur4 = Joueur("Gusty", "crosemont")
                var joueur5 = Joueur("Patrick", "crosemont")
                joueur1.scoreHistoire = 4
                joueur2.scoreHistoire = 3
                joueur3.scoreHistoire = 15
                joueur4.scoreHistoire = 3
                joueur5.scoreHistoire = 4
                return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)


            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesClassement(source)

        val listeJoueurs = interacteur.classementParCategorie(Categorie.HISTOIRE)
        for (i in 0 until 5) {
            assertNotNull(listeJoueurs?.get(i))
            assertNotNull(interacteur.classementParCategorie(Categorie.HISTOIRE)?.get(i))
            assertEquals(
                listeJoueurs?.get(i)?.nom,
                interacteur.classementParCategorie(Categorie.HISTOIRE)?.get(i)?.nom
            )
        }

    }

    @Test
    fun testMéthodeClassementParCategorieParCategorieAnimaux() {
        var source: ISourceDeDonnéesClassementTest = object : ISourceDeDonnéesClassementTest {
            override fun classementJoueurs(): List<Joueur>? {

                var joueur1 = Joueur("Maude", "crosemont")
                var joueur2 = Joueur("Jean", "crosemont")
                var joueur3 = Joueur("Maxime", "crosemont")
                var joueur4 = Joueur("Gusty", "crosemont")
                var joueur5 = Joueur("Patrick", "crosemont")
                joueur1.scoreAnimaux = 21
                joueur2.scoreAnimaux = 32
                joueur3.scoreAnimaux = 1
                joueur4.scoreAnimaux = 3
                joueur5.scoreAnimaux = 4
                return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)


            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesClassement(source)

        val listeJoueurs = interacteur.classementParCategorie(Categorie.ANIMAUX)
        for (i in 0 until 5) {
            assertNotNull(listeJoueurs?.get(i))
            assertNotNull(interacteur.classementParCategorie(Categorie.ANIMAUX)?.get(i))
            assertEquals(
                listeJoueurs?.get(i)?.nom,
                interacteur.classementParCategorie(Categorie.ANIMAUX)?.get(i)?.nom
            )
        }
    }

    @Test
    fun testMéthodeClassementParCategorieParCategorieGeographie() {
        var source: ISourceDeDonnéesClassementTest = object : ISourceDeDonnéesClassementTest {
            override fun classementJoueurs(): List<Joueur>? {

                var joueur1 = Joueur("Maude", "crosemont")
                var joueur2 = Joueur("Jean", "crosemont")
                var joueur3 = Joueur("Maxime", "crosemont")
                var joueur4 = Joueur("Gusty", "crosemont")
                var joueur5 = Joueur("Patrick", "crosemont")
                joueur1.scoreGeo = 12
                joueur2.scoreGeo = 5
                joueur3.scoreGeo = 1
                joueur4.scoreGeo = 2
                joueur5.scoreGeo = 4
                return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)


            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesClassement(source)

        val listeJoueurs = interacteur.classementParCategorie(Categorie.GEOGRAPHIE)
        for (i in 0 until 5) {
            assertNotNull(listeJoueurs?.get(i))
            assertNotNull(interacteur.classementParCategorie(Categorie.GEOGRAPHIE)?.get(i))
            assertEquals(
                listeJoueurs?.get(i)?.nom,
                interacteur.classementParCategorie(Categorie.GEOGRAPHIE)?.get(i)?.nom
            )
        }
    }

    @Test
    fun testMéthodeClassementParCategorieParCategorieSport() {
        var source: ISourceDeDonnéesClassementTest = object : ISourceDeDonnéesClassementTest {
            override fun classementJoueurs(): List<Joueur>? {

                var joueur1 = Joueur("Maude", "crosemont")
                var joueur2 = Joueur("Jean", "crosemont")
                var joueur3 = Joueur("Maxime", "crosemont")
                var joueur4 = Joueur("Gusty", "crosemont")
                var joueur5 = Joueur("Patrick", "crosemont")
                joueur1.scoreSport = 3
                joueur2.scoreSport = 12
                joueur3.scoreSport = 4
                joueur4.scoreSport = 1
                joueur5.scoreSport = 2
                return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)


            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesClassement(source)

        val listeJoueurs = interacteur.classementParCategorie(Categorie.SPORT)
        for (i in 0 until 5) {
            assertNotNull(listeJoueurs?.get(i))
            assertNotNull(interacteur.classementParCategorie(Categorie.SPORT)?.get(i))
            assertEquals(
                listeJoueurs?.get(i)?.nom,
                interacteur.classementParCategorie(Categorie.SPORT)?.get(i)?.nom
            )
        }
    }

    @Test
    fun testMéthodeClassementParCategorieParCategorieInexistante() {
        var source: ISourceDeDonnéesClassementTest = object : ISourceDeDonnéesClassementTest {
            override fun classementJoueurs(): List<Joueur>? {

                var joueur1 = Joueur("Maude", "crosemont")
                var joueur2 = Joueur("Jean", "crosemont")
                var joueur3 = Joueur("Maxime", "crosemont")
                var joueur4 = Joueur("Gusty", "crosemont")
                var joueur5 = Joueur("Patrick", "crosemont")
                joueur1.scoreScience = 3
                joueur2.scoreScience = 2
                joueur3.scoreScience = 1
                joueur4.scoreScience = 5
                joueur5.scoreScience = 3
                return mutableListOf(joueur1, joueur2, joueur3, joueur4, joueur5)


            }

        }

        var interacteur = InteracteurAcquisitionDeDonnéesClassement(source)

        val listeJoueurs = interacteur.classementParCategorie(Categorie.SCIENCE)
        for (i in 0 until 5) {
            assertNotNull(listeJoueurs?.get(i))
            assertNotNull(interacteur.classementParCategorie(Categorie.SCIENCE)?.get(i))
            assertEquals(
                listeJoueurs?.get(i)?.nom,
                interacteur.classementParCategorie(Categorie.SCIENCE)?.get(i)?.nom
            )
        }
    }
}