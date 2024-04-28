package com.example.quiznat.présentation.vue

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quiznat.R
import com.example.quiznat.présentation.présentateur.Présentateur_login

class Fragment_login : Fragment() {
    private var txtUtilisateur: EditText? = null
    private var txtMotDePasse: EditText? = null
    private var btnConnexion: Button? = null
    private var creerCompte: TextView? = null

    private var connecter = false

    private var _présentateur: Présentateur_login? = null
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtUtilisateur = view.findViewById(R.id.NomUtilisateur)
        txtMotDePasse = view.findViewById(R.id.MotDePasse)
        btnConnexion = view.findViewById(R.id.BtnConnexion)
        creerCompte = view.findViewById(R.id.CreerCompte)

        navController = Navigation.findNavController(view)

        _présentateur = Présentateur_login(this)

        btnConnexion?.setOnClickListener(View.OnClickListener {
            if (connecter == false) {
                _présentateur!!.seConnecter(
                    txtUtilisateur!!.text.toString(),
                    txtMotDePasse!!.text.toString()
                )
                connecter = true
            } else {
                _présentateur!!.afficherÉcranLogin()
                connecter = false
            }
        })

        creerCompte?.setOnClickListener(View.OnClickListener {
            _présentateur!!.afficherÉcranInscription()

        })

    }

    fun naviguerÉcranAccueil() {
        navController!!.navigate(R.id.fragment_accueil)
    }

    fun naviguerÉcranInscription() {
        navController!!.navigate(R.id.fragment_inscription)
    }

    fun naviguerÉcranLogin() {
        navController!!.navigate(R.id.fragment_login)
    }

    fun alert(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this.context)
        alertDialog.setTitle("Erreur")
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton(
            "Ok"
        ) { _, _ ->
            Toast.makeText(this.context, "Alert dialog closed.", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton(
            "Cancel"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }
}