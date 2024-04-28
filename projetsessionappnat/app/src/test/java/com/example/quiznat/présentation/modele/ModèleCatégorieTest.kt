package com.example.quiznat.présentation.modele

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.présentation.modèle.ModèleCatégorie
import junit.framework.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

class ModèleCatégorieTest {
    @Test
    fun `étant donné un modèle instancié lorsque je choisit une catégorie a a position 0 la catégorie courante devient celle a la position 0`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        var CategorieA0 = modèle.tableauCat.categoriesTab[0]
        modèle.choisirCategorie(0)
        assertEquals(CategorieA0, modèle.categorieCourate)
    }

    @Test
    fun `étant donné un modèle instancié lorsque je choisit une catégorie a a position -1 j'obtiens une erreur`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        var messageErreur = ""
        try {
            modèle.choisirCategorie(-1)
        } catch (e: IllegalArgumentException) {
            messageErreur = e.message.toString()
        }
        assertEquals("La position doit être entre 0 et le nombre de catégories(6)", messageErreur)
    }

    @Test
    fun `étant donné un modèle instancié lorsque je choisit une catégorie a a position 6 j'obtiens une erreur`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        var messageErreur = ""
        try {
            modèle.choisirCategorie(6)
        } catch (e: IllegalArgumentException) {
            messageErreur = e.message.toString()
        }
        assertEquals("La position doit être entre 0 et le nombre de catégories(6)", messageErreur)
    }

    @Test
    fun `étant donné un modèle avec aucune categorie active, lorsque je cherche les categories actives j'obtient une liste vide`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        var listCategoriesActives = modèle.getCategorieActive()
        assertEquals(0, listCategoriesActives.count())
    }

    @Test
    fun `étant donné un modèle avec la categorie animaux active, lorsque je cherche les categories actives j'obtient une liste de taille 1`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        modèle.completerCategorie(Categorie.ANIMAUX)
        var listCategoriesActives = modèle.getCategorieActive()
        assertEquals(1, listCategoriesActives.count())
        modèle.réinitialiser()
    }

    @Test
    fun `étant donné un modèle avec la categorie art et science active, lorsque je cherche les categories actives j'obtient une liste de taille 2`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        modèle.completerCategorie(Categorie.ANIMAUX)
        modèle.completerCategorie(Categorie.SCIENCE)
        var listCategoriesActives = modèle.getCategorieActive()
        assertEquals(2, listCategoriesActives.count())
        modèle.réinitialiser()
    }

    @Test
    fun `étant donné un modèle avec la categorie animaux active, lorsque je cherche les categories actives j'obtient une liste avec la categorie animaux`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        modèle.completerCategorie(Categorie.ANIMAUX)
        var listCategoriesActives = modèle.getCategorieActive()
        assertTrue(listCategoriesActives.contains(Categorie.ANIMAUX))
        modèle.réinitialiser()

    }

    @Test
    fun `étant donné un modèle avec la categorie art et science active, lorsque je cherche les categories actives j'obtient une liste avec les catégories art et science`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        modèle.completerCategorie(Categorie.ANIMAUX)
        modèle.completerCategorie(Categorie.SCIENCE)
        var listCategoriesActives = modèle.getCategorieActive()
        assertTrue(listCategoriesActives.containsAll(listOf(Categorie.ANIMAUX, Categorie.SCIENCE)))
        modèle.réinitialiser()

    }

    @Test
    fun `étant donné un modèle avec toutes les catégories complétées,lorsque j'éxécute a gagné, j'obtiens true `() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        Categorie.values().forEach {
            modèle.completerCategorie(it)
        }
        assertTrue(modèle.aGagne())
        modèle.réinitialiser()
    }

    @Test
    fun `étant donné un modèle avec 2 catégories complétées,lorsque j'éxécute a gagné, j'obtiens false`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        modèle.completerCategorie(Categorie.ANIMAUX)
        modèle.completerCategorie(Categorie.SCIENCE)
        assertFalse(modèle.aGagne())
        modèle.réinitialiser()
    }

    @Test
    fun `étant donné un modèle avec acune catégories complétées,lorsque j'éxécute a gagné, j'obtiens false`() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        assertFalse(modèle.aGagne())
        modèle.réinitialiser()
    }

    @Test
    fun `étant donné un modèle avec toutes les catégories complétées,lorsque je réinitialise, toutes les categories retourne a false `() {
        var modèle: ModèleCatégorie = ModèleCatégorie
        Categorie.values().forEach {
            modèle.completerCategorie(it)
        }
        modèle.réinitialiser()
        val nbrDeFalse =
            ModèleCatégorie.tableauCat.categorieComplete.count { entry: Map.Entry<Categorie, Boolean> -> entry.value == false }
        assertEquals(6, nbrDeFalse)
    }
}