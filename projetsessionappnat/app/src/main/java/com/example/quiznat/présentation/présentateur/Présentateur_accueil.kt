package com.example.quiznat.présentation.présentateur

import com.example.quiznat.data.remote.SourceDeDonnéesAPI
import com.example.quiznat.présentation.modèle.ModèleJoueur
import com.example.quiznat.présentation.vue.Fragment_accueil

/**
 * classe Présentateur_accueil contient les méthodes qui affichent de la vue
 *
 * @param _vue
 */
class Présentateur_accueil(val _vue: Fragment_accueil) {
    private val _modèle = ModèleJoueur

    /**
     * Déconnecte le joueur
     * Remet le modèle à null
     * Envoit à la page de login
     *
     * */
    fun seDeconnecter() {
        _modèle.joueur = null
        _vue.naviguerÉcranLogin()
    }

    fun afficherÉcranCategorie() {
        _vue.naviguerÉcranCategorie()
    }

    fun afficherÉcranLogin() {
        _vue.naviguerÉcranLogin()
    }

    fun afficherÉcranClassement() {
        _vue.naviguerÉcranClassement()
    }

    fun afficherPointage() {
        _vue.montrerPointageJoueur(_modèle.joueur?.getTotalScore().toString())
    }

    fun afficherNomUtilisateur() {
        _vue.montrerNomUtilisateur(_modèle.joueur?.nom.toString())
    }
}