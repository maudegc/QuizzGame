package com.example.quiznat.présentation.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quiznat.R
import com.example.quiznat.présentation.présentateur.Présentateur_accueil

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_accueil.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_accueil : Fragment() {
    private var txtNomJoueur: TextView? = null
    private var pointage: TextView? = null
    private var classement: TextView? = null
    private var btnJouer: ImageButton? = null
    private var btnDeconnexion: ImageButton? = null
    private var _présentateur: Présentateur_accueil? = null
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_accueil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtNomJoueur = view.findViewById(R.id.NomUtilisateurAccueil)
        pointage = view.findViewById(R.id.Pointage)
        classement = view.findViewById(R.id.Classement)
        btnJouer = view.findViewById(R.id.BtnJouer)
        btnDeconnexion = view.findViewById(R.id.BtnDeconnexion)
        navController = Navigation.findNavController(view)

        _présentateur = Présentateur_accueil(this)
        _présentateur!!.afficherNomUtilisateur()
        _présentateur!!.afficherPointage()

        btnJouer?.setOnClickListener(View.OnClickListener {
            _présentateur!!.afficherÉcranCategorie()
        })
        btnDeconnexion?.setOnClickListener(View.OnClickListener {
            _présentateur!!.seDeconnecter()
        })
        classement?.setOnClickListener(View.OnClickListener {
            _présentateur!!.afficherÉcranClassement()
        })
    }

    fun naviguerÉcranClassementComplet() {
        navController!!.navigate(R.id.fragment_classement)
    }

    fun naviguerÉcranCategorie() {
        navController!!.navigate(R.id.fragment_catégorie)
    }

    fun naviguerÉcranLogin() {
        navController!!.navigate(R.id.fragment_login)
    }

    fun naviguerÉcranClassement() {
        navController!!.navigate(R.id.fragment_classement)
    }

    fun montrerNomUtilisateur(nom: String) {
        txtNomJoueur!!.setText(nom)
    }

    fun montrerPointageJoueur(pointageJoueur: String) {
        pointage!!.setText(pointageJoueur)
    }
}