package com.example.quiznat.présentation.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.quiznat.R
import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.présentation.présentateur.Présentateur_catégorie

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_catégorie.newInstance] factory method to
 * create an instance of this fragment.
 */

class Fragment_catégorie : Fragment(), View.OnClickListener {
    lateinit var _presentateur: Présentateur_catégorie
    lateinit var _titre: TextView
    lateinit var _images: MutableList<ImageView>
    lateinit var _imagesActivées: MutableList<ImageView>
    lateinit var _boutons: MutableList<ImageButton>
    lateinit var _nav: NavController
    lateinit var _quitter: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _nav = Navigation.findNavController(view)
        _titre = view.findViewById(R.id.titre)
        _quitter = view.findViewById(R.id.quitter)
        _quitter.setOnClickListener(View.OnClickListener {
            naviguerÉcranAcceuil()
        })
        _presentateur = Présentateur_catégorie(this)
        _presentateur.initialiserVue()

        initialiserBoutons(view)
        initialiserImages(view)
        initialiserBarresCategoriesActives(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categorie, container, false)
    }

    override fun onClick(v: View) {
        var position: Int = Integer.parseInt(v.tag as String)
        _presentateur.choisirCategorie(position)
    }

    fun initialiserBoutons(vue: View) {
        _boutons = mutableListOf()
        for (i in 0 until 6) {
            var unBouton = vue.findViewWithTag(Integer.toString(i)) as ImageButton
            _boutons.add(i, unBouton)
            unBouton.setOnClickListener(this)
        }

    }

    fun initialiserImages(vue: View) {
        _images = mutableListOf()
        for (i in 0 until 6) {
            var uneImage = vue.findViewWithTag("img" + i) as ImageView
            _images.add(i, uneImage)

        }
    }
    /**
     * Permet de mettre en couleur toutes les catégories réussies
     */
    fun initialiserBarresCategoriesActives(vue: View) {
        _imagesActivées = mutableListOf()
        Categorie.values().forEach {
            var uneImage = vue.findViewWithTag(it.categorie) as ImageView
            _imagesActivées.add(uneImage)
        }
        _presentateur.activerCategories().forEach { activerCategorie(it.categorie) }

    }

    fun disableBoutons() {
        _boutons.forEach { button -> button.isEnabled = false }
    }

    /**
     * Permet d'afficher la catégorie présente a une certaine position
     * @param categorie Categorie a afficher
     * @param position Position de la carte a changé
     */
    fun afficherCategorie(categorie: Categorie, position: Int) {
        _titre.setText(categorie.categorie)
        var id = resources.getIdentifier(
            categorie.categorie, "drawable",
            context?.getPackageName()
        )
        _images[position].setImageResource(id)
    }

    /**
     * Permet de mettre en couleur une catégorie réussie
     */
    fun activerCategorie(categorie: String) {
        var id = resources.getIdentifier(
            categorie, "drawable",
            context?.getPackageName()
        )
        _imagesActivées.find { imageView -> imageView.tag == categorie }?.setImageResource(id)

    }

    fun naviguerÉcranQuiz() {
        _nav.navigate(R.id.fragment_quiz)
    }

    fun naviguerÉcranAcceuil() {
        _nav.navigate(R.id.fragment_accueil)
    }

    fun naviguerÉcranFin() {
        _nav.navigate(R.id.fragment_fin)
    }
}



