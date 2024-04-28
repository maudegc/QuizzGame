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
import com.example.quiznat.présentation.présentateur.Présentateur_inscription

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_inscription.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_inscription : Fragment() {
    private var txtUtilisateur: EditText? = null
    private var txtMotDePasse: EditText? = null
    private var txtConfirmerMotPasse: EditText? = null
    private var btnCréer: Button? = null
    private var seConnecter: TextView? = null


    private var _présentateur: Présentateur_inscription? = null
    var navController: NavController? = null

    fun setPrésentateur(présentateur: Présentateur_inscription) {
        _présentateur = présentateur
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inscription, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtUtilisateur = view.findViewById(R.id.NomUtilisateurInscription)
        txtMotDePasse = view.findViewById(R.id.MotDePasse1)
        txtConfirmerMotPasse = view.findViewById(R.id.MotDePasse2)
        btnCréer = view.findViewById(R.id.BtnCreer)
        seConnecter = view.findViewById(R.id.Connecter)

        navController = Navigation.findNavController(view)

        _présentateur = Présentateur_inscription(this)

        btnCréer?.setOnClickListener(View.OnClickListener {
            _présentateur!!.créerCompte(
                txtUtilisateur!!.text.toString(),
                txtMotDePasse!!.text.toString(),
                txtConfirmerMotPasse!!.text.toString()
            )

        })
        seConnecter?.setOnClickListener(View.OnClickListener {
            naviguerÉcranLogin()
        })

    }

    fun naviguerÉcranAccueil() {
        navController!!.navigate(R.id.fragment_accueil)
    }

    fun naviguerÉcranLogin() {
        navController!!.navigate(R.id.fragment_login)
    }

    fun naviguerÉcranInscription() {
        navController!!.navigate(R.id.fragment_inscription)
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