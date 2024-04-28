package com.example.quiznat.data.remote

import android.database.Observable
import retrofit2.Call
import com.example.quiznat.domaine.entité.Joueur
import retrofit2.Response
import retrofit2.http.*

/**
 * Interface des pour les jouers de la BD
 */
interface IJoueurApi {
    @GET("Joueurs")
    fun joueurs(): Call<List<Joueur>>

    @GET("JoueurParNom/{nom}")
    fun joueur(@Path("nom") nom: String): Call<List<Joueur>>

    @POST("ajouter")
    fun ajouterJoueur(@Body joueur: Joueur): Call<Joueur>

    @PUT("modifier")
    fun modifierJoueur(@Body joueur: Joueur?): Call<Int>
}