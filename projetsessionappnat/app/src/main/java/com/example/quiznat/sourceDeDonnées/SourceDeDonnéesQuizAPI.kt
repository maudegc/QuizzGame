package com.example.quiznat.sourceDeDonnées

import android.util.Log
import com.example.quiznat.data.remote.RetrofitService
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse
import com.example.quiznat.domaine.interacteur.quiz.ISourceDeDonnéesQuizTest
import retrofit2.Call
import java.io.IOException

class SourceDeDonnéesQuizAPI : ISourceDeDonnéesQuizTest {
    /**
     * Fonction qui permet d'aller chercher les question d'une catégories spécifique
     *
     * @param categorie la catégorie choisit par l'utilisateur
     * @return les questions de la catégorie
     */
    override fun getLesQuestionsUneCategorie(categorie: Categorie): List<Question>? {
        var res: List<Question>? = null
        val call: Call<List<Question>> = RetrofitService.getDonnéesQuiz.questions(categorie)
        try {
            res = call.execute().body()
            Log.d("RETROFIT", "SUCCESS QUESTION")
        } catch (e: IOException) {
            Log.d("ERREUR", e.message.toString())
        }
        return res as List<Question>
    }

    /**
     * Fonction qui permet d'aller chercher les répônses à travers le service dépendament de la question
     *
     * @param idQuestion le id de la question
     * @return les choix de réponses correspondant à cette question
     */
    override fun getLesReponsesUneQuestion(idQuestion: Int?): List<Reponse>? {
        var res: List<Reponse>? = null
        val call: Call<List<Reponse>> = RetrofitService.getDonnéesQuiz.reponses(idQuestion)
        try {
            res = call.execute().body()
            Log.d("RETROFIT", "SUCCESS REPONSE")
        } catch (e: IOException) {
            //Toast.makeText(e.message, "NETWORK FAILURE", Toast.LENGTH_SHORT).show()
            Log.d("ERREUR", e.message.toString())
        }
        return res as List<Reponse>
    }
}