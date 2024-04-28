package com.example.quiznat.domaine.entité

import junit.framework.Assert.*
import org.junit.Test
import org.junit.experimental.categories.Categories

class CategorieTabTest {
    @Test
    fun `etant donné une categorieTab, lorsqu'on instancie on obtient un dictionnaire de 6 categories a false`() {
        var tab: CategorieTab = CategorieTab()
        var nbrFalse = 0
        tab.categorieComplete.values.forEach {
            if (it == false) {
                nbrFalse++
            }
        }
        assertEquals(6, nbrFalse)
    }

    @Test
    fun `etant donné une categorieTab, lorsqu'on instancie on obtient un dictionnaire qui a pour cle les 6 categories de la classe Categorie`() {
        var tab: CategorieTab = CategorieTab()
        var contientToutesLesCategories =
            tab.categorieComplete.keys.containsAll(Categorie.values().toList())
        assertTrue(contientToutesLesCategories)
    }

    @Test
    fun `etant donné une categorieTab, lorsqu'on instancie on obtient un tableau contenant les 6 categories de la classe Categorie`() {
        var tab: CategorieTab = CategorieTab()
        var nbrCategorie = 0
        Categorie.values().forEach {
            if (tab.categoriesTab.contains(it)) {
                nbrCategorie++
            }
        }
        assertEquals(6, nbrCategorie)
    }

    @Test
    fun `etant donné une categorieTab instancie,lorsqu'on complete une categorie sa valeur dans categorie complete est true`() {
        var tab: CategorieTab = CategorieTab()
        tab.completerCategorie(Categorie.ANIMAUX)
        var estComplete = tab.categorieComplete[Categorie.ANIMAUX]
        if (estComplete != null) {
            assertTrue(estComplete)
        }
    }

    @Test
    fun `etant donné une categorieTab instancie,lorsqu'on decoche une categorie sa valeur dans categorie complete est false`() {
        var tab: CategorieTab = CategorieTab()
        tab.decocherCategorie(Categorie.ANIMAUX)
        var estComplete = tab.categorieComplete[Categorie.ANIMAUX]
        if (estComplete != null) {
            assertFalse(estComplete)
        }
    }

    @Test
    fun `etant donné une categorieTab instancie,lorsqu'on melange, on obtient une liste avec des categories placés differement`() {
        var tab: CategorieTab = CategorieTab()
        var categorieTabAvantMelange = tab.categoriesTab.clone()
        tab.melanger()
        var categorieTabMelange = tab.categoriesTab
        assertFalse(categorieTabAvantMelange == categorieTabMelange)

    }
}