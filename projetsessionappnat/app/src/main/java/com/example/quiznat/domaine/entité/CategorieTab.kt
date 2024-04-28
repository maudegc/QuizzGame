package com.example.quiznat.domaine.entité

import java.util.*
import kotlin.random.Random

/**
 * Classe CategorieTab est une liste de catégorie
 *
 * @constructor crée un une table boolean de toutes les catégories à false et
 * une un array de string avec toutes les catégorie à l'intérieur
 */
class CategorieTab {

    var categorieComplete: MutableMap<Categorie, Boolean>
    val categoriesTab: Array<Categorie>

    init {
        categorieComplete = mutableMapOf()
        categorieComplete[Categorie.SCIENCE] = false
        categorieComplete[Categorie.HISTOIRE] = false
        categorieComplete[Categorie.ANIMAUX] = false
        categorieComplete[Categorie.SPORT] = false
        categorieComplete[Categorie.PROGRAMMATION] = false
        categorieComplete[Categorie.GEOGRAPHIE] = false

        categoriesTab = arrayOf(
            Categorie.SCIENCE,
            Categorie.HISTOIRE,
            Categorie.ANIMAUX,
            Categorie.SPORT,
            Categorie.PROGRAMMATION,
            Categorie.GEOGRAPHIE
        )
    }

    /**
     * Met la catégorie à true
     *
     * @param categorie
     * */
    fun completerCategorie(categorie: Categorie) {
        categorieComplete[categorie] = true
    }

    /**
     * Met la catégorie à false
     *
     * @param categorie
     * */
    fun decocherCategorie(categorie: Categorie) {
        categorieComplete[categorie] = false
    }

    /**
     * Mélange les catégories
     * */
    fun melanger() {
        categoriesTab.shuffle()
    }


}