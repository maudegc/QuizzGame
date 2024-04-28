package com.example.quiznat.présentation.présentateur


import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.quiznat.data.remote.SourceDeDonnéesAPI
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.domaine.entité.Question

import com.example.quiznat.domaine.entité.Reponse
import com.example.quiznat.domaine.interacteur.Joueur.InteracteurAcquisitionDeJoueurs
import com.example.quiznat.domaine.interacteur.quiz.ISourceDeDonnéesQuizTest
import com.example.quiznat.domaine.interacteur.quiz.InteracteurAcquisitionDeDonnéesQuiz
import com.example.quiznat.présentation.modèle.ModèleQuiz
import com.example.quiznat.présentation.vue.Fragment_quiz
import com.example.quiznat.présentation.modèle.ModèleCatégorie
import com.example.quiznat.présentation.modèle.ModèleJoueur
import com.example.quiznat.sourceDeDonnées.SourceDeDonnéesQuizAPI
import java.lang.Exception

/**
 * classe Présentateur_quiz contient les méthodes concernant le quiz
 *
 * @param _vue
 */
class Présentateur_quiz(val _vueQuiz: Fragment_quiz?) {
    private var _source: ISourceDeDonnéesQuizTest = SourceDeDonnéesQuizAPI()
    private var _sourceJoueurAPI = SourceDeDonnéesAPI()


    val _modèle: ModèleQuiz = ModèleQuiz
    val _modèleJoueur: ModèleJoueur = ModèleJoueur
    var leJoueur: Joueur? = _modèleJoueur.joueur
    var questionSuivante: Question? = null
    var reponsesQuestion: List<Reponse>? = null
    private var filEsclave: Thread? = null
    private var filEsclave2: Thread? = null
    private val handlerRéponse: Handler
    private val MSG_CONFIRME = 0
    private val MSG_REPONSE = 1


    fun setSource(source: ISourceDeDonnéesQuizTest) {
        _source = source
    }

    init {
        handlerRéponse = object : Handler() {

            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                filEsclave = null
                filEsclave2 = null
                if (msg.what == MSG_CONFIRME) {
                    _vueQuiz?.afficherQuestion(_modèle.uneQuestion)
                    _vueQuiz?.afficherReponses(reponsesQuestion)
                }

            }
        }
    }

    /**
     * Fonction qui permet de donner la question de la catégorie courante
     *
     * @param categorie
     * */
    fun questionSuivante(categorie: Categorie?) {
        filEsclave = Thread {
            var msg: Message? = null
            try {
                questionSuivante =
                    InteracteurAcquisitionDeDonnéesQuiz(_source).uneQuestionParCategorie(categorie)
                _modèle.uneQuestion = questionSuivante
                reponseSuivante(_modèle.uneQuestion?.idQuestion)
                msg = handlerRéponse.obtainMessage(MSG_CONFIRME, questionSuivante)
            } catch (e: Exception) {
                Log.d("ERREUR PRÉSENTATEUR", e.message.toString())

            }
            handlerRéponse.sendMessage(msg!!)
        }

        filEsclave!!.start()
    }

    /**
     * Fonction qui permet de donner les réponses de la question courante
     *
     * @param idQuestion
     * */
    fun reponseSuivante(idQuestion: Int?) {

        filEsclave = Thread {
            var msg: Message? = null
            try {
                _modèle.viderListeReponses()
                reponsesQuestion =
                    InteracteurAcquisitionDeDonnéesQuiz(_source).getLesReponsesDeUneQuestion(
                        idQuestion
                    )
                _modèle.lesReponses = reponsesQuestion

                msg = handlerRéponse.obtainMessage(MSG_CONFIRME, reponsesQuestion)
            } catch (e: Exception) {
                Log.d("ERREUR PRÉSENTATEUR", e.message.toString())

            }
            handlerRéponse.sendMessage(msg!!)
        }

        filEsclave!!.start()
    }

    /**
     * Fonction qui permet l'ajout de point selon la catégorie
     *
     * @param laCategorie
     * */
    fun ajoutPointsSelonCategorie(laCategorie: Categorie?) {
        when (laCategorie) {
            Categorie.SPORT -> {

                leJoueur?.scoreSport = leJoueur?.scoreSport!!.inc()
                _modèle.lesScores[Categorie.SPORT] = _modèle.lesScores[Categorie.SPORT]!!.inc()
            }
            Categorie.PROGRAMMATION -> {
                leJoueur?.scoreProgrammation = leJoueur?.scoreProgrammation!!.inc()
                _modèle.lesScores[Categorie.PROGRAMMATION] =
                    _modèle.lesScores[Categorie.PROGRAMMATION]!!.inc()
            }
            Categorie.HISTOIRE -> {
                leJoueur?.scoreHistoire = leJoueur?.scoreHistoire!!.inc()
                _modèle.lesScores[Categorie.HISTOIRE] =
                    _modèle.lesScores[Categorie.HISTOIRE]!!.inc()
            }
            Categorie.SCIENCE -> {
                leJoueur?.scoreScience = leJoueur?.scoreScience!!.inc()
                _modèle.lesScores[Categorie.SCIENCE] = _modèle.lesScores[Categorie.SCIENCE]!!.inc()
            }
            Categorie.GEOGRAPHIE -> {
                leJoueur?.scoreGeo = leJoueur?.scoreGeo!!.inc()
                _modèle.lesScores[Categorie.GEOGRAPHIE] =
                    _modèle.lesScores[Categorie.GEOGRAPHIE]!!.inc()
            }
            Categorie.ANIMAUX -> {
                leJoueur?.scoreAnimaux = leJoueur?.scoreAnimaux!!.inc()
                _modèle.lesScores[Categorie.ANIMAUX] = _modèle.lesScores[Categorie.ANIMAUX]!!.inc()
            }
        }
        var joueurActuel = _modèleJoueur.joueur

        filEsclave = Thread {
            var msg: Message? = null
            try {

                var reponse =
                    InteracteurAcquisitionDeJoueurs(_sourceJoueurAPI).modifierJoueur(joueurActuel)
                msg = handlerRéponse.obtainMessage(MSG_CONFIRME, reponse)

            } catch (e: Exception) {
                Log.d("ERREUR PRÉSENTATEUR", e.message.toString())

            }
            handlerRéponse.sendMessage(msg!!)
        }
        filEsclave!!.start()
    }

    /**
     * Fonction qui permet d'obtenir la catégorie courante
     *
     * @return la catégorie courante
     * */
    fun getCategorieCourante(): Categorie {
        return ModèleCatégorie.categorieCourate
    }

    /**
     * Fonction qui permet d'obtenir le nom du joueur courant
     *
     * @return
     */
    fun getNomJoueurCourant(): String? {
        return ModèleJoueur.joueur?.nom
    }

    /**
     * Fonction qui permet d'obtenir le score du joueur courant
     *
     * @return
     */
    fun getScoreJoueurCourant(): Int? {
        return _modèle.lesScores.values.sum()
    }

    /**
     * Fonction qui permet de définir la catégorie comme réussie
     * */
    fun reussiCategorie() {
        ModèleCatégorie.completerCategorie(ModèleCatégorie.categorieCourate)
    }

    /**
     * Fonction qui permet de savoir quel est le nom de la reponse choisit
     *
     * @param id la position
     * @return
     */
    fun GetReponseParId(id: Int): String {
        return _modèle.lesReponses?.find { it.idReponse == id }!!.nomReponse
    }

}