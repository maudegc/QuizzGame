package com.example.quiznat.domaine.entité

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Classe Réponse
 *
 * @param idReponse
 * @param nomReponse
 * @param idQuestion
 * @constructor crée une réponse avec les paramètres donnés
 */
class Reponse(
    @Expose @SerializedName("id_reponse") var idReponse: Int,
    @Expose @SerializedName("nom_reponse") var nomReponse: String,
    @Expose @SerializedName("id_question") var idQuestion: Int
) {

}