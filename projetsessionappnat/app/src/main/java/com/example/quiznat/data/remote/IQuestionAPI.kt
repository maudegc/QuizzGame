package com.example.quiznat.data.remote

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface IQuestionAPI {
    @Streaming
    @GET("questionsParCat/{categorie}")
    fun questions(@Path("categorie") categorie: Categorie): Call<List<Question>>

    @Streaming
    @GET("reponseParQuestionId/{idQuestion}")
    fun reponses(@Path("idQuestion") idQuestion: Int?): Call<List<Reponse>>

}