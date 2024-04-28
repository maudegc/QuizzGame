package com.example.quiznat.présentation.présentateur

import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.quiznat.data.remote.SourceDeDonnéesAPI
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.Joueur.ISourceDeDonnéesJoueurs
import com.example.quiznat.domaine.interacteur.Joueur.InteracteurAcquisitionDeJoueurs

import com.example.quiznat.présentation.modèle.ModèleJoueur
import com.example.quiznat.présentation.vue.Fragment_login
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonJoueur
import java.lang.Exception

/**
 * classe Présentateur_login contient les méthodes concernant le login
 *
 * @param _vue
 */
class Présentateur_login(val _vue: Fragment_login) {
    private val _modèle = ModèleJoueur
    private var _source: ISourceDeDonnéesJoueurs = SourceDeDonnéesAPI()
    private var filEsclave: Thread? = null
    private val handlerRéponse: Handler
    private val MSG_CONFIRME = 0
    private val MSG_INFO_INVALIDE = 1

    fun setSource(source: ISourceDeDonnéesJoueurs) {
        _source = source
    }

    init {
        handlerRéponse = object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                filEsclave = null
                if (msg.what == MSG_CONFIRME) {
                    _vue.naviguerÉcranAccueil()
                } else if (msg.what == MSG_INFO_INVALIDE) {
                    _vue.alert("Le nom ou le mot de passe est invalide")
                    _vue.naviguerÉcranLogin()
                }
            }
        }
    }

    /**
     * Permet de se connecter
     *
     * @param nom
     * @param motPasse
     */
    fun seConnecter(nom: String, motPasse: String) {
        var joueur: Joueur? = null
        if (nom != "" || motPasse != "") {
            if (nom != "") {
                if (motPasse != "") {
                    filEsclave = Thread {
                        var msg: Message? = null
                        try {
                            joueur = InteracteurAcquisitionDeJoueurs(_source).joueurParNom(nom)
                            _modèle.joueur = joueur
                            if (joueur != null) {
                                if (_modèle.joueur!!.confirmeConnection(nom, motPasse)) {
                                    msg = handlerRéponse.obtainMessage(MSG_CONFIRME)
                                } else {
                                    msg = handlerRéponse.obtainMessage(MSG_INFO_INVALIDE)
                                }
                            } else {
                                msg = handlerRéponse.obtainMessage(MSG_INFO_INVALIDE)
                            }
                        } catch (e: Exception) {
                            Log.d("ERREUR PRÉSENTATEUR", e.message.toString())
                            msg = handlerRéponse.obtainMessage(MSG_INFO_INVALIDE)
                        }
                        handlerRéponse.sendMessage(msg!!)
                    }
                    filEsclave!!.start()
                } else {
                    _vue.alert("Insérez votre mot de passe")
                    _vue.naviguerÉcranLogin()
                }
            } else {
                _vue.alert("Insérez votre nom")
                _vue.naviguerÉcranLogin()
            }
        } else {
            _vue.alert("Insérez vos informations")
            _vue.naviguerÉcranLogin()
        }
    }

    fun afficherÉcranInscription() {
        _vue.naviguerÉcranInscription()
    }

    fun afficherÉcranAccueil() {
        _vue.naviguerÉcranAccueil()
    }

    fun afficherÉcranLogin() {
        _vue.naviguerÉcranLogin()
    }
}
