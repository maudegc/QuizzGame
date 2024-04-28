package com.example.quiznat.domaine.interacteur.classement

import com.example.quiznat.domaine.entité.Categorie
import com.example.quiznat.domaine.entité.Joueur

/**
 * Classe InteracteurAcquisitionDeDonnéesClassement intéragit avec l'Api pour aller chercher le score des joueurs
 *
 * @param _source
 */
class InteracteurAcquisitionDeDonnéesClassement(var _source: ISourceDeDonnéesClassementTest?) {
    var listeJoueurs: List<Joueur>? = null

    fun classementParCategorie(laCategorie: Categorie?): List<Joueur>? {
        when (laCategorie) {
            Categorie.SPORT -> {
                var listeClassementJoueurCatSport = _source?.classementJoueurs()

                var nom = listeClassementJoueurCatSport?.get(2)?.nom;
                if (listeClassementJoueurCatSport != null) {
                    return listeClassementJoueurCatSport.sortedByDescending { it.scoreSport }

                }
                listeJoueurs = listeClassementJoueurCatSport
                return listeClassementJoueurCatSport
            }
            Categorie.PROGRAMMATION -> {
                var listeClassementJoueurCatProgrammation = _source?.classementJoueurs()
                if (listeClassementJoueurCatProgrammation != null) {
                    return listeClassementJoueurCatProgrammation.sortedByDescending { it.scoreProgrammation }

                }
                listeJoueurs = listeClassementJoueurCatProgrammation
                return listeClassementJoueurCatProgrammation
            }
            Categorie.HISTOIRE -> {
                var listeClassementJoueurCatHistoire = _source?.classementJoueurs()
                if (listeClassementJoueurCatHistoire != null) {
                    return listeClassementJoueurCatHistoire.sortedByDescending { it.scoreHistoire }

                }
                listeJoueurs = listeClassementJoueurCatHistoire
                return listeClassementJoueurCatHistoire
            }
            Categorie.SCIENCE -> {
                var listeClassementJoueurCatScience = _source?.classementJoueurs()
                if (listeClassementJoueurCatScience != null) {
                    return listeClassementJoueurCatScience.sortedByDescending { it.scoreScience }

                }
                listeJoueurs = listeClassementJoueurCatScience
                return listeClassementJoueurCatScience
            }
            Categorie.GEOGRAPHIE -> {
                var listeClassementJoueurCatGéographie = _source?.classementJoueurs()
                if (listeClassementJoueurCatGéographie != null) {
                    return listeClassementJoueurCatGéographie.sortedByDescending { it.scoreGeo }

                }
                listeJoueurs = listeClassementJoueurCatGéographie
                return listeClassementJoueurCatGéographie
            }
            Categorie.ANIMAUX -> {
                var listeClassementJoueurCatAnimaux = _source?.classementJoueurs()
                if (listeClassementJoueurCatAnimaux != null) {
                    return listeClassementJoueurCatAnimaux.sortedByDescending { it.scoreAnimaux }

                }
                listeJoueurs = listeClassementJoueurCatAnimaux
                return listeClassementJoueurCatAnimaux
            }
            else -> {
                return null
            }
        }
    }
}