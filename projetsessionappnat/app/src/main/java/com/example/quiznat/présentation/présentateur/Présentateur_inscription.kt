package com.example.quiznat.présentation.présentateur

import android.os.Handler
import android.os.Message
import com.example.quiznat.data.remote.SourceDeDonnéesAPI
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.Joueur.ISourceDeDonnéesJoueurs
import com.example.quiznat.domaine.interacteur.Joueur.InteracteurAcquisitionDeJoueurs
import com.example.quiznat.présentation.modèle.ModèleJoueur
import com.example.quiznat.présentation.vue.Fragment_inscription
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesBidonJoueur
import java.lang.Exception

/**
 * classe Présentateur_inscription contient les méthodes concernant l'inscription
 *
 * @param _vue
 */
class Présentateur_inscription(val _vue: Fragment_inscription) {
    private val _modèle = ModèleJoueur
    private var _source: ISourceDeDonnéesJoueurs = SourceDeDonnéesAPI()
    private var filEsclave: Thread? = null
    private val handlerRéponse: Handler
    private val MSG_CONFIRME = 0
    private val MSG_ERREUR = 1
    private val MSG_JOUEUR_EXISTANT = 2

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
                } else if (msg.what == MSG_JOUEUR_EXISTANT) {
                    _vue.alert("Le nom existe déjà")
                } else if (msg.what == MSG_ERREUR) {
                    _vue.alert("Erreur d'accès à l'API!!!")
                }
            }
        }
    }

    /**
     * Permet de créer un compte
     *
     * @param nom
     * @param motPasse1
     * @param motPasse2
     */
    fun créerCompte(nom: String, motPasse1: String, motPasse2: String) {
        var joueurExistant = false
        if (nom != "") {
            if (motPasse1 != "") {
                if (motPasse2 != "") {
                    if (motPasse1 == motPasse2) {
                        filEsclave = Thread {
                            var msg: Message? = null
                            try {
                                val joueurs = InteracteurAcquisitionDeJoueurs(_source).joueurs()
                                joueurs.forEach {
                                    if (it.nom.lowercase() == nom.lowercase()) {
                                        joueurExistant = true
                                        msg = handlerRéponse.obtainMessage(MSG_JOUEUR_EXISTANT)
                                    }
                                }
                                if (!joueurExistant) {
                                    val j = Joueur(nom, motPasse1)
                                    val joueur =
                                        InteracteurAcquisitionDeJoueurs(_source).ajoutJoueur(j)
                                    _modèle.joueur = joueur
                                    msg = handlerRéponse.obtainMessage(MSG_CONFIRME)
                                }
                            } catch (e: Exception) {
                                msg = handlerRéponse.obtainMessage(MSG_ERREUR, e)
                            }
                            handlerRéponse.sendMessage(msg!!)
                        }
                        filEsclave!!.start()
                    } else {
                        _vue.alert("Mots de passe différents")
                    }
                } else {
                    _vue.alert("Confirmez votre mot de passe")
                }
            } else {
                _vue.alert("Insérez un mot de passe")
            }
        } else {
            _vue.alert("Insérez un nom")
        }
    }

    fun afficherÉcranAccueil() {
        _vue.naviguerÉcranAccueil()
    }

    fun afficherÉcranLogin() {
        _vue.naviguerÉcranLogin()
    }

    fun afficherÉcranInscription() {
        _vue.naviguerÉcranInscription()
    }
}