package com.example.quiznat.présentation.présentateur


import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.interacteur.classement.ISourceDeDonnéesClassementTest
import com.example.quiznat.domaine.interacteur.classement.InteracteurAcquisitionDeDonnéesClassement
import com.example.quiznat.présentation.modèle.ModèleClassement
import com.example.quiznat.présentation.modèle.ModèleJoueur
import com.example.quiznat.présentation.vue.Fragment_classement
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesClassementAPI
import java.lang.Exception

/**
 * classe Présentateur_classement contient les méthodes concernant le classement
 *
 * @param _vue
 */
class Présentateur_classement(val _VueClassement: Fragment_classement) {
    var _source: ISourceDeDonnéesClassementTest = SourceDeDonnéesClassementAPI()
    val _modèle: ModèleClassement = ModèleClassement
    val _modèleJouer: ModèleJoueur = ModèleJoueur
    private var filEsclave: Thread? = null
    private val handlerRéponse: Handler
    var listeClassement: List<Joueur>? = null
    private val MSG_CONFIRME = 0
    private val MSG_ERREUR = 1
    private val MSG_INFO_INVALIDE = 2

    fun setSource(source: ISourceDeDonnéesClassementTest) {
        _source = source
    }

    init {
        handlerRéponse = object : Handler() {

            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                filEsclave = null
                if (msg.what == MSG_CONFIRME) {
                    _VueClassement?.afficherMeilleurJoueurs(
                        _modèle.listeJoueur,
                        _modèle.categorieClassement
                    )
                }
            }
        }
    }

    /**
     * Fonction qui permet d'intéragir avec les données et de les envoyer au modèle
     *
     * @param categorie la catégorie choisit par l'utilisateur
     */
    fun classementParCatégorie(categorie: Categorie?) {

        filEsclave = Thread {
            var msg: Message? = null
            try {
                listeClassement =
                    InteracteurAcquisitionDeDonnéesClassement(_source).classementParCategorie(
                        categorie
                    )
                _modèle.listeJoueur = listeClassement
                _modèle.categorieClassement = categorie
                msg = handlerRéponse.obtainMessage(MSG_CONFIRME, listeClassement)
            } catch (e: Exception) {
                Log.d("ERREUR PRÉSENTATEUR", e.message.toString())

            }
            handlerRéponse.sendMessage(msg!!)
        }
        filEsclave!!.start()
    }

    /**
     * Fonction qui permet de retourner le score tout dépendamment de la catégorie choisit
     *
     * @param cat la catégorie choisit par l'utilsiateur
     * @return retourne le score de la catégorie choisit
     */
    fun getScoreParCategorie(cat: Categorie): Int? {
        when (cat) {
            Categorie.ANIMAUX -> return _modèleJouer.joueur?.scoreAnimaux
            Categorie.PROGRAMMATION -> return _modèleJouer.joueur?.scoreProgrammation
            Categorie.GEOGRAPHIE -> return _modèleJouer.joueur?.scoreGeo
            Categorie.SPORT -> return _modèleJouer.joueur?.scoreSport
            Categorie.HISTOIRE -> return _modèleJouer.joueur?.scoreHistoire
            Categorie.SCIENCE -> return _modèleJouer.joueur?.scoreScience

        }
    }
}