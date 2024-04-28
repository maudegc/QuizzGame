package com.example.quiznat.présentation.vue

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quiznat.R
import com.example.quiznat.domaine.entité.Question
import com.example.quiznat.domaine.entité.Reponse
import com.example.quiznat.présentation.présentateur.Présentateur_quiz

class Fragment_quiz : Fragment() {

    private var btnReponse1: Button? = null
    private var btnReponse2: Button? = null
    private var btnReponse3: Button? = null
    private var btnReponse4: Button? = null
    lateinit var lesBoutons: List<Button>
    private var laQuestion: TextView? = null
    private var laCategorie: TextView? = null
    private var nomJoueur: TextView? = null
    private var scoreJoueur: TextView? = null
    private var _présentateur: Présentateur_quiz? = null
    var idBonneReponse = _présentateur?.questionSuivante?.idBonneReponse
    var idQuestion = _présentateur?.questionSuivante?.idQuestion
    var idReponseSelectionner: Int? = null
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnReponse1 = view.findViewById(R.id.boutonReponse1)
        btnReponse2 = view.findViewById(R.id.boutonReponse2)
        btnReponse3 = view.findViewById(R.id.boutonReponse3)
        btnReponse4 = view.findViewById(R.id.boutonReponse4)
        lesBoutons = listOf(btnReponse1, btnReponse2, btnReponse3, btnReponse4) as List<Button>
        _présentateur = Présentateur_quiz(this)
        navController = Navigation.findNavController(view)

        laQuestion = view.findViewById(R.id.laQuestion) as TextView
        nomJoueur = view.findViewById(R.id.nomJoueur) as TextView
        scoreJoueur = view.findViewById(R.id.points) as TextView
        laCategorie = view.findViewById(R.id.categorie) as TextView

        _présentateur?.questionSuivante(_présentateur?.getCategorieCourante())
        nomJoueur!!.text = _présentateur!!.getNomJoueurCourant()
        scoreJoueur!!.text = _présentateur!!.getScoreJoueurCourant().toString()

        btnReponse1?.setOnClickListener(View.OnClickListener {
            traiterChoisirReponse(0)
        })
        btnReponse2?.setOnClickListener(View.OnClickListener {
            traiterChoisirReponse(1)
        })
        btnReponse3?.setOnClickListener(View.OnClickListener {
            traiterChoisirReponse(2)
        })
        btnReponse4?.setOnClickListener(View.OnClickListener {
            traiterChoisirReponse(3)
        })

        afficherCategorie()
    }

    /**
     * Fonction qui permet de traiter le choix de réponse selon la réponse qu'il a décider
     *
     * @param position la position de la réponse choisit
     */
    fun traiterChoisirReponse(position: Int) {
        idBonneReponse = _présentateur?.questionSuivante?.idBonneReponse
        idReponseSelectionner = _présentateur?.reponsesQuestion?.get(position)?.idReponse

        boutonIncliquable()
        if (idBonneReponse == idReponseSelectionner) {

            lesBoutons[position]?.setBackgroundColor(Color.parseColor("#388E3C"))
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    boutonIncliquable()
                    _présentateur!!.ajoutPointsSelonCategorie(_présentateur!!.getCategorieCourante())
                    _présentateur!!.reussiCategorie()
                    navController!!.navigate(R.id.fragment_catégorie)
                },
                1000 // value in milliseconds
            )
            Log.d("reponse", "voici la bonne reponse")
        } else {
            boutonIncliquable()
            lesBoutons[position]?.setBackgroundColor(Color.parseColor("#FF0505"))
            lesBoutons.find { it.text == _présentateur?.GetReponseParId(idBonneReponse!!) }
                ?.setBackgroundColor(Color.parseColor("#388E3C"))


            Handler(Looper.getMainLooper()).postDelayed(
                {
                    boutonIncliquable()
                    navController!!.navigate(R.id.fragment_fin)
                },
                1000 // value in milliseconds
            )
        }
    }

    /**
     * Fonction qui permet de rendre les boutons incliquable après que l'utilisateur à fait son choix
     *
     */
    fun boutonIncliquable() {

        btnReponse1?.setEnabled(false);
        btnReponse2?.setEnabled(false);
        btnReponse3?.setEnabled(false);
        btnReponse4?.setEnabled(false);
    }

    /**
     * Fonction qui permet d'afficher la question courante
     *
     * @param uneQuestion la question courante
     */
    fun afficherQuestion(uneQuestion: Question?) {
        laQuestion?.text = uneQuestion?.nomQuestion.toString()
    }

    /**
     * Fonction qui permet d'afficher la catégorie courante
     *
     */
    fun afficherCategorie() {
        laCategorie?.text = _présentateur?.getCategorieCourante()!!.categorie
    }

    /**
     * Fonction qui permet d'afficher les réponses
     *
     * @param lesReponse les réponses d'une question
     */
    fun afficherReponses(lesReponse: List<Reponse>?) {
        for (i in 0..3) {
            var uneReponse = lesReponse?.get(i)

            if (i == 0) {
                btnReponse1?.text = uneReponse?.nomReponse
            } else if (i == 1) {
                btnReponse2?.text = uneReponse?.nomReponse
            } else if (i == 2) {
                btnReponse3?.text = uneReponse?.nomReponse
            } else if (i == 3) {
                btnReponse4?.text = uneReponse?.nomReponse
            }
        }
    }
}