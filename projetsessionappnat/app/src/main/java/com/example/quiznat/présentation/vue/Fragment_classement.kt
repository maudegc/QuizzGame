package com.example.quiznat.présentation.vue

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quiznat.R
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur
import com.example.quiznat.présentation.modèle.ModèleJoueur
import com.example.quiznat.présentation.présentateur.Présentateur_classement


class Fragment_classement : Fragment() {

    lateinit var _listeJoueurs: MutableList<TextView>
    lateinit var _pointageJoueur: MutableList<TextView>
    private var _pointageJoueurActuel: Joueur? = ModèleJoueur.joueur

    private val CHANNEL_ID = "i.apps.notifications"
    lateinit private var notificationManager: NotificationManager
    private val notifMotivation = "Augmentez votre rang en jouant plus ! Vous n'êtes même pas dans le top 5 !!!"
    private var categorieAnimaux: ImageView? = null
    private var categorieScience: ImageView? = null
    private var categorieHistoire: ImageView? = null
    private var categorieGeo: ImageView? = null
    private var categorieProgrammation: ImageView? = null
    private var categorieSport: ImageView? = null

    private var btnRetour: TextView? = null
    private var monScore: TextView? = null
    private var _présentateur: Présentateur_classement? = null
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_classement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationManager =
            activity?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        creerChannelNotification()

        navController = Navigation.findNavController(view)

        categorieAnimaux = view.findViewById(R.id.categorieArt)
        categorieSport = view.findViewById(R.id.categorieSport)
        categorieScience = view.findViewById(R.id.categorieScience)
        categorieProgrammation = view.findViewById(R.id.categorieTechnologie)
        categorieGeo = view.findViewById(R.id.categorieGeo)
        categorieHistoire = view.findViewById(R.id.categorieHistoire)
        btnRetour = view.findViewById(R.id.btnRetourClassement)
        monScore = view.findViewById(R.id.idScoreClassement)

        _présentateur = Présentateur_classement(this)
        _présentateur?.classementParCatégorie(Categorie.SPORT)
        activerCat(Categorie.SPORT, categorieSport!!)
        monScore?.setText(_présentateur?.getScoreParCategorie(Categorie.SPORT).toString())
        btnRetour?.setOnClickListener(View.OnClickListener {


            navController!!.navigate(R.id.fragment_accueil)


        })

        categorieAnimaux?.setOnClickListener(View.OnClickListener {

            traiterChoisirCategorie(Categorie.ANIMAUX, categorieAnimaux!!)
        })
        categorieScience?.setOnClickListener(View.OnClickListener {

            traiterChoisirCategorie(Categorie.SCIENCE, categorieScience!!)
        })
        categorieHistoire?.setOnClickListener(View.OnClickListener {
            traiterChoisirCategorie(Categorie.HISTOIRE, categorieHistoire!!)
        })
        categorieProgrammation?.setOnClickListener(View.OnClickListener {
            traiterChoisirCategorie(Categorie.PROGRAMMATION, categorieProgrammation!!)
        })
        categorieGeo?.setOnClickListener(View.OnClickListener {
            traiterChoisirCategorie(Categorie.GEOGRAPHIE, categorieGeo!!)

        })
        categorieSport?.setOnClickListener(View.OnClickListener {
            traiterChoisirCategorie(Categorie.SPORT, categorieSport!!)
        })

        initilaliserJoueurs(view)
        initialiserPointage(view)
    }

    /**
     * Fonction qui permet de traiter le choix de la catégorie fait par l'utilisateur
     *
     * @param cat la catégorie choisit par l'utilisateur
     * @param catIcone l'îcone de la catégorie chosiit
     */
    fun traiterChoisirCategorie(cat: Categorie, catIcone: ImageView) {
        _présentateur?.classementParCatégorie(cat)
        desactiverToutesLesCats()
        activerCat(cat, catIcone!!)
        monScore?.setText(_présentateur?.getScoreParCategorie(cat).toString())
    }

    /**
     *Fonction qui permet d'initialiser les joueurs présent dans le classement
     *
     * @param vue fragment du classement
     */
    fun initilaliserJoueurs(vue: View) {
        _listeJoueurs = mutableListOf()
        for (i in 0 until 5) {

            var unJoueur = vue.findViewWithTag("j" + i) as TextView
            _listeJoueurs.add(i, unJoueur)


        }
    }

    /**
     * Initialisation des pointages des joueurs dans le classement (top5)
     *
     * @param vue fragment du classement
     */
    fun initialiserPointage(vue: View) {
        _pointageJoueur = mutableListOf()
        for (i in 0 until 5) {

            var unPointage = vue.findViewWithTag("p" + i) as TextView
            _pointageJoueur.add(i, unPointage)
        }
    }

    /**
     * Fonction qui permet d'afficher les meilleurs joueurs de la catégorie choisit
     *
     * @param listeJoueurs liste du classement des joueurs selon la catégorie
     * @param laCategorie catégorie choisit par l'utilisateur préalablement
     */
    fun afficherMeilleurJoueurs(listeJoueurs: List<Joueur>?, laCategorie: Categorie?) {
        if (listeJoueurs != null) {

            for (joueur in listeJoueurs) {
                if (_pointageJoueurActuel?.getTotalScore()!! <= listeJoueurs?.get(4)
                        ?.getTotalScore()!!
                ) {
                    lancerUneNotification(
                        "Motivation",
                        "Ton score total est de : " + _pointageJoueurActuel?.getTotalScore()!! + " ce n'est pas suffisant pour être dans le top 5!!! Augmentez votre rang en jouant plus !"
                    )
                } else {
                    lancerUneNotification(
                        "Félication",
                        "Bravo !!! Tu es dans le top 5 des meilleurs scores totaux avec un score de : " + _pointageJoueurActuel?.getTotalScore()!!
                    )

                }
            }
        }
        for (i in 0 until 5) {
            _listeJoueurs[i].text = listeJoueurs?.get(i)?.nom

        }
        when (laCategorie) {
            Categorie.SPORT -> {

                for (i in 0 until 5) {
                    _pointageJoueur[i]?.text = listeJoueurs?.get(i)?.scoreSport.toString()
                }
            }

            Categorie.PROGRAMMATION -> {

                if (_pointageJoueurActuel?.scoreProgrammation!! <= listeJoueurs?.get(4)?.scoreProgrammation!!) {
                    lancerUneNotification(
                        "Motivation",
                        notifMotivation
                    )

                }
                for (i in 0 until 5) {
                    _pointageJoueur[i]?.text = listeJoueurs?.get(i)?.scoreProgrammation.toString()
                }

            }
            Categorie.HISTOIRE -> {

                if (_pointageJoueurActuel?.scoreHistoire!! <= listeJoueurs?.get(4)?.scoreHistoire!!) {
                    lancerUneNotification("Motivation", notifMotivation)

                }
                for (i in 0 until 5) {
                    _pointageJoueur[i]?.text = listeJoueurs?.get(i)?.scoreHistoire.toString()
                }

            }
            Categorie.SCIENCE -> {

                if (_pointageJoueurActuel?.scoreScience!! <= listeJoueurs?.get(4)?.scoreScience!!) {
                    lancerUneNotification("Motivation", notifMotivation)

                }
                for (i in 0 until 5) {
                    _pointageJoueur[i]?.text = listeJoueurs?.get(i)?.scoreScience.toString()
                }
            }
            Categorie.GEOGRAPHIE -> {

                if (_pointageJoueurActuel?.scoreGeo!! <= listeJoueurs?.get(4)?.scoreGeo!!) {
                    lancerUneNotification("Motivation", notifMotivation)

                }
                for (i in 0 until 5) {
                    _pointageJoueur[i]?.text = listeJoueurs?.get(i)?.scoreGeo.toString()
                }
            }

            Categorie.ANIMAUX -> {
                if (_pointageJoueurActuel?.scoreAnimaux!! <= listeJoueurs?.get(4)?.scoreAnimaux!!) {
                    lancerUneNotification("Motivation", notifMotivation)

                }
                for (i in 0 until 5) {
                    _pointageJoueur[i]?.text = listeJoueurs?.get(i)?.scoreAnimaux.toString()
                }
            }
        }
    }

    /**
     * Fonction qui permet d'envoyer une notification
     *
     * @param titre titre de la notification qui sera envoyer
     * @param message message de la notification qui sera envoyer
     */
    fun lancerUneNotification(titre: String, message: String) {


        var builder = context?.let {
            NotificationCompat.Builder(it, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(titre)
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText(message)
                )
        }
        if (builder != null) {
            notificationManager.notify(1234, builder.build())
        }

    }

    private fun creerChannelNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = CHANNEL_ID
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            notificationManager.createNotificationChannel(channel)

        }

    }


    /**
     *  Fonction qui permet de d'action l'icône de la catégorie choisit par l'utilisateur
     *
     * @param cat catégorie sélectionner par l'utilisateur
     * @param imageCat image de la catégorie quand celle-ci est sélectionner
     */
    fun activerCat(cat: Categorie, imageCat: ImageView) {
        var id = resources.getIdentifier(
            cat.categorie, "drawable",
            context?.getPackageName()
        )
        imageCat.setImageResource(id)

    }
    /*
        Fonction qui permet de desactiver les icônes des catégories qui ne sont pas choisit par l'utilisateur pour le classement
     */
    fun desactiverToutesLesCats() {
        var idAnimaux = resources.getIdentifier(
            "animauxoff", "drawable",
            context?.getPackageName()
        )
        categorieAnimaux?.setImageResource(idAnimaux)

        var idProgramation = resources.getIdentifier(
            "programmationoff", "drawable",
            context?.getPackageName()
        )
        categorieProgrammation?.setImageResource(idProgramation)

        var idScience = resources.getIdentifier(
            "scienceoff", "drawable",
            context?.getPackageName()
        )
        categorieScience?.setImageResource(idScience)

        var idHistoire = resources.getIdentifier(
            "histoireoff", "drawable",
            context?.getPackageName()
        )
        categorieHistoire?.setImageResource(idHistoire)

        var idSport = resources.getIdentifier(
            "sportoff", "drawable",
            context?.getPackageName()
        )
        categorieSport?.setImageResource(idSport)

        var idGeo = resources.getIdentifier(
            "geographieoff", "drawable",
            context?.getPackageName()
        )
        categorieGeo?.setImageResource(idGeo)
    }
}