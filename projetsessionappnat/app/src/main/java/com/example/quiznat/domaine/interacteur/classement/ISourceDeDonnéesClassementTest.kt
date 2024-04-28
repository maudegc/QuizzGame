package com.example.quiznat.domaine.interacteur.classement

import com.example.quiznat.domaine.entité.Joueur

interface ISourceDeDonnéesClassementTest {
    fun classementJoueurs(): List<Joueur>?
}