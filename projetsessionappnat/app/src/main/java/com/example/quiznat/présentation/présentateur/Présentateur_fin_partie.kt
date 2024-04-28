package com.example.quiznat.présentation.présentateur

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.présentation.modèle.ModèleCatégorie
import com.example.quiznat.présentation.modèle.ModèleJoueur
import com.example.quiznat.présentation.modèle.ModèleQuiz
import com.example.quiznat.présentation.vue.Fragment_fin

/**
 * classe Présentateur_fin_partie contient les méthodes concernant la fin de la partie
 *
 * @param _vue
 */
class Présentateur_fin_partie(val _vue: Fragment_fin) {
    var joueur = ModèleJoueur.joueur
    var _modeleCategorie = ModèleCatégorie

    /**
     * Affiche Le message de la fin et le score de la partie
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun initialiserVue() {
        _vue.afficherMessageFin(ModèleCatégorie.aGagne())
        if (joueur != null) {
            var lesScores = ModèleQuiz.lesScores
            _vue.afficherScore(lesScores)
        }
    }

    /**
     * Réinitialise le Quiz et envoit a l'écran quiz
     */
    fun traiterBoutonRecommencer() {
        _modeleCategorie.réinitialiser()
        _vue.naviguerEcranCatégorie()

    }
    /**
     * Réinitialise le Quiz et envoit a l'écran acceuil
     */
    fun traiterBoutonAcceuil() {
        _modeleCategorie.réinitialiser()
        _vue.naviguerEcranAcceuil()
    }
    /**
     * Permet de partager son score a la fin de la partie
     */
    fun traiterBoutonPartager() {
        var scoreTotal = ModèleQuiz.lesScores.values.sum()
        var nom = joueur?.nom
        if (scoreTotal != null && nom != null) {
            _vue.partagerScore(scoreTotal, nom)
        }
    }
}