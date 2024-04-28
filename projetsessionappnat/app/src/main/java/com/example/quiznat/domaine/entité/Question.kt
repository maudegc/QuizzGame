package com.example.quiznat.domaine.entité

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Classe Question
 *
 * @param idQuestion
 * @param nomQuestion
 * @param idBonneReponse
 * @param categorie
 * @constructor crée une question avec les paramètres donnés
 */
class Question(
    @Expose @SerializedName("id_question") var idQuestion: Int,
    @Expose @SerializedName("nom_question") var nomQuestion: String,
    @Expose @SerializedName("id_bonne_reponse") var idBonneReponse: Int,
    @Expose @SerializedName("categorie") var categorie: Categorie
) {


}