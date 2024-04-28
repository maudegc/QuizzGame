package com.example.quiznat.sourceDeDonnées

import android.util.Log
import com.example.quiznat.data.remote.RetrofitService
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.classement.ISourceDeDonnéesClassementTest
import retrofit2.Call
import java.io.IOException

class SourceDeDonnéesClassementAPI : ISourceDeDonnéesClassementTest {
    /**
     * Fonction qui permet de retourner la liste de joueurs qui seront dans le classement
     *
     * @return la liste de joueurs pour le classement
     */
    override fun classementJoueurs(): List<Joueur>? {
        var res: List<Joueur>? = null
        val call: Call<List<Joueur>> = RetrofitService.getDonnées.joueurs()
        try {
            res = call.execute().body()
            Log.d("RETROFIT", "SUCCESS")
        } catch (e: IOException) {
            Log.d("ERREUR", e.message.toString())
        }
        return res as List<Joueur>
    }


}