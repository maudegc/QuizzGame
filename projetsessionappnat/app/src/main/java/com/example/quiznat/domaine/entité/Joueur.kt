package com.example.quiznat.domaine.entité

import java.util.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Classe Joueur
 *
 * @param nom_joueur
 * @param nom_mot_passe
 * @constructor crée un joueur avec un nom et un mot de passe
 */
class Joueur(
    @Expose
    @SerializedName("nom_joueur")
    val nom: String,
    @Expose
    @SerializedName("mot_passe")
    val motDePasse: String
) {
    @Expose
    @SerializedName("id_joueur")
    var idJoueur: Int = 0

    @Expose
    @SerializedName("score_science")
    var scoreScience: Int

    @Expose
    @SerializedName("score_histoire")
    var scoreHistoire: Int

    @Expose
    @SerializedName("score_sport")
    var scoreSport: Int

    @Expose
    @SerializedName("score_animaux")
    var scoreAnimaux: Int

    @Expose
    @SerializedName("score_geo")
    var scoreGeo: Int

    @Expose
    @SerializedName("score_programmation")
    var scoreProgrammation: Int

    init {
        scoreScience = 0
        scoreHistoire = 0
        scoreSport = 0
        scoreAnimaux = 0
        scoreGeo = 0
        scoreProgrammation = 0
    }


    /**
     * Confirme si le joueur se connecte
     *
     * @param nom
     * @param motDePasse
     * @return un boolean si le joueur réussit à se connecter
     * */
    fun confirmeConnection(nom: String, motDePasse: String): Boolean {
        var connecté = false
        if (this.nom == nom && this.motDePasse == motDePasse) {
            connecté = true
        }
        return connecté
    }

    /**
     * Total du score du joueur
     *
     * @return le score total du joueur
     * */
    fun getTotalScore(): Int {
        return scoreProgrammation + scoreAnimaux + scoreHistoire + scoreScience + scoreSport + scoreGeo
    }
}