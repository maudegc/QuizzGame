package com.example.quiznat.présentation.vue

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quiznat.R
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.présentation.présentateur.Présentateur_fin_partie

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_fin.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_fin : Fragment() {
    lateinit var _btnShare: ImageButton
    lateinit var _btnAcceuil: ImageButton
    lateinit var _btnRecommencer: ImageButton
    lateinit var _messageFin: TextView
    lateinit var _scoreFin: TextView
    lateinit var _présentateur: Présentateur_fin_partie
    lateinit var _scoreAnimauxFin: TextView
    lateinit var _scoreProgrammationFin: TextView
    lateinit var _scoreScienceFin: TextView
    lateinit var _scoreHistoireFin: TextView
    lateinit var _scoreSportFin: TextView
    lateinit var _scoreGeographieFin: TextView
    lateinit var _lesScores: Map<Categorie, TextView>

    lateinit var _nav: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_fin, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _messageFin = view.findViewById<TextView>(R.id.messageFin)
        _scoreFin = view.findViewById<TextView>(R.id.scoreFin)

        _scoreAnimauxFin = view.findViewById<TextView>(R.id.scoreFinAnimaux)
        _scoreProgrammationFin = view.findViewById<TextView>(R.id.scoreFinProgrammation)
        _scoreScienceFin = view.findViewById<TextView>(R.id.scoreFinScience)
        _scoreHistoireFin = view.findViewById<TextView>(R.id.scoreFinHistoire)
        _scoreSportFin = view.findViewById<TextView>(R.id.scoreFinSport)
        _scoreGeographieFin = view.findViewById<TextView>(R.id.scoreFinGeo)
        _lesScores = mapOf(
            Categorie.ANIMAUX to _scoreAnimauxFin,
            Categorie.PROGRAMMATION to _scoreProgrammationFin,
            Categorie.SCIENCE to _scoreScienceFin,
            Categorie.HISTOIRE to _scoreHistoireFin,
            Categorie.SPORT to _scoreSportFin,
            Categorie.GEOGRAPHIE to _scoreGeographieFin

        )


        _btnShare = view.findViewById<ImageButton>(R.id.btnPartager)
        _btnShare.setOnClickListener(View.OnClickListener {
            _présentateur.traiterBoutonPartager()
        })

        _btnAcceuil = view.findViewById<ImageButton>(R.id.btnQuitter)
        _btnAcceuil.setOnClickListener(View.OnClickListener {
            _présentateur.traiterBoutonAcceuil()
        })

        _btnRecommencer = view.findViewById<ImageButton>(R.id.btnRejouer)
        _btnRecommencer.setOnClickListener(View.OnClickListener {
            _présentateur.traiterBoutonRecommencer()
        })
        _présentateur = Présentateur_fin_partie(this)
        _présentateur.initialiserVue()
        _nav = Navigation.findNavController(view)

    }

    fun afficherMessageFin(aGagne: Boolean) {
        if (aGagne) {
            _messageFin.setText("Félicitations !");
        } else {
            _messageFin.setText("Vous avez perdu");
        }

    }

    fun naviguerEcranCatégorie() {
        _nav.navigate(R.id.fragment_catégorie)
    }

    fun naviguerEcranAcceuil() {
        _nav.navigate(R.id.fragment_accueil)
    }

    fun partagerScore(score: Int, nom: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            var message = nom + " joue présentement au superquiz et a eu " + score + " points!"
            putExtra(Intent.EXTRA_TEXT, message)


        }

        val shareIntent = Intent.createChooser(sendIntent, "Partager mon score")
        startActivity(shareIntent)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun afficherScore(lesScores: Map<Categorie, Int>) {
        var scoreTotal = lesScores.values.sum()
        _scoreFin.setText("" + scoreTotal)
        lesScores.forEach { categorie, score ->
            _lesScores[categorie]?.setText("" + score)
        }

    }


}