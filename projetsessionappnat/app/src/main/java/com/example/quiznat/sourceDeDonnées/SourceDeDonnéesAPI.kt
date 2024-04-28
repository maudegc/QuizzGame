package com.example.quiznat.data.remote

import android.util.Log
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.Joueur.ISourceDeDonnéesJoueurs
import retrofit2.Call
import java.io.IOException

class SourceDeDonnéesAPI : ISourceDeDonnéesJoueurs {
    override fun getJoueurs(): List<Joueur> {
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

    override fun getJoueurParNom(nom: String): Joueur {
        var res: List<Joueur>? = null
        val call: Call<List<Joueur>> = RetrofitService.getDonnées.joueur(nom)
        Log.d("CALL EXECUTED", call.isExecuted.toString())
        try {
            res = call.execute().body()
            Log.d("RETROFIT", "SUCCESS")
        } catch (e: Exception) {
            Log.d("ERREUR DANS SOURCE API", e.message.toString())
        }

        val joueur = res!!.get(0)

        return joueur
    }

    override fun ajouterJoueur(joueur: Joueur): Joueur {
        val call: Call<Joueur> = RetrofitService.getDonnées.ajouterJoueur(joueur)
        var joueur: Joueur? = null
        try {
            joueur = call.execute().body()
            Log.d("RETROFIT AJOUT", "SUCCESS")
        } catch (e: Exception) {
            Log.d("ERREUR SOURCE API AJOUT", e.message.toString())
        }
        return joueur!!
    }

    override fun modifierJoueur(joueur: Joueur?): Int? {

        var call: Call<Int> = RetrofitService.getDonnées.modifierJoueur(joueur)
        var res: Int? = null
        try {
            res = call.execute().body()
            Log.d("RETROFIT MODIFIER", "SUCCESS")
        } catch (e: Exception) {
            Log.d("ERREUR  API MODIFIER", e.message.toString())
        }
        return res!!
    }


}