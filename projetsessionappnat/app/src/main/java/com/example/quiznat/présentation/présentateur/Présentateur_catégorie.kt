package com.example.quiznat.présentation.présentateur

import android.os.CountDownTimer
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.présentation.vue.Fragment_catégorie
import com.example.quiznat.présentation.modèle.ModèleCatégorie

/**
 * classe Présentateur_catégorie contient les méthodes concernant les catégories
 *
 * @param _vue
 */
class Présentateur_catégorie(val _vue: Fragment_catégorie) {
    var _modele = ModèleCatégorie

    /**
     * Initialise la vue
     */
    fun initialiserVue() {
        if (_modele.aGagne()) {
            _vue.naviguerÉcranFin()

        } else {
            _modele.melanger()

        }
    }

    /**
     * Choisit une catégorie selon la position
     * Envoit à la vue catégorie
     *
     * @param position
     */
    fun choisirCategorie(position: Int): Categorie {
        var categorie = _modele.choisirCategorie(position)
        _vue.disableBoutons()
        _vue.afficherCategorie(categorie, position)
        object : CountDownTimer(2000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                _vue.naviguerÉcranQuiz()
            }
        }.start()
        return categorie
    }

    /**
     * Obtenir toutes les catégories actives
     */
    fun activerCategories(): List<Categorie> {
        return _modele.getCategorieActive()
    }

    fun activerCategorie(categorie: Categorie) {
        _modele.completerCategorie(categorie)
    }
}