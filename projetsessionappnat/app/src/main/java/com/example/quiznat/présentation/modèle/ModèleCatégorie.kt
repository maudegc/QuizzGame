package com.example.quiznat.présentation.modèle

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.CategorieTab

/**
 * Objet ModèleCatégorie contient les méthodes des catégories
 *
 */
object ModèleCatégorie {
    val tableauCat: CategorieTab
    var categorieCourate: Categorie = Categorie.ANIMAUX

    init {
        tableauCat = CategorieTab()
    }

    /**
     * Complète la catégorie choisit
     *
     * @param categorie
     * */
    fun completerCategorie(categorie: Categorie) {
        tableauCat.completerCategorie(categorie)
    }

    /**
     * Mélange les catégories
     *
     * */
    fun melanger() {
        tableauCat.melanger()

    }

    /**
     * Choisit la catégorie selon la position choisit
     *
     * @param position
     * @return la catégorie à la position x
     * */
    fun choisirCategorie(position: Int): Categorie {
        if (position < 0 || position >= Categorie.values().count()) {
            throw IllegalArgumentException("La position doit être entre 0 et le nombre de catégories(6)")
        }
        categorieCourate = tableauCat.categoriesTab.get(position)
        return categorieCourate
    }

    /**
     * Permet de savoir quel catégorie il reste
     *
     * @return les catégories actives
     * */
    fun getCategorieActive(): List<Categorie> {
        var list: MutableList<Categorie> = mutableListOf()
        for (categorie in tableauCat.categorieComplete) {
            if (categorie.value) {
                list.add(categorie.key)
            }
        }
        return list
    }

    /**
     * Définit
     *
     * @return true si toutes les catégories ont été complétés
     * */
    fun aGagne(): Boolean {
        val nbrDeTrue =
            tableauCat.categorieComplete.count { entry: Map.Entry<Categorie, Boolean> -> entry.value == true }
        return nbrDeTrue == Categorie.values().count()
    }

    /**
     * Réinitialise les catégories
     * */
    fun réinitialiser() {
        Categorie.values().forEach { categorie ->
            tableauCat.decocherCategorie(categorie)
            ModèleQuiz.lesScores[categorie] = 0
        }
    }
}



