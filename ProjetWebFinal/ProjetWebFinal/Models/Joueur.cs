using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ProjetWebFinal.Models
{
    public class Joueur
    {

        public int id_joueur { get; set; }
        [Required(ErrorMessage = "Insérez votre nom")]
        public string nom_joueur { get; set; }
        [Required (ErrorMessage = "Insérez votre mot de passe")]
        public string mot_passe { get; set; }
        public int score_science { get; set; }
        public int score_histoire { get; set; }
        public int score_sport { get; set; }
        public int score_animaux { get; set; }
        public int score_programmation { get; set; }
        public int score_geo { get; set; }

        public int score_total { get; set; }

        public Reponse reponseCourante { get; set; }
      

        public Joueur(string nom_joueur, String mot_passe)
        {
            this.nom_joueur = nom_joueur;
            this.mot_passe = mot_passe;
            score_animaux = 0;
            score_geo = 0;
            score_histoire = 0;
            score_science = 0;
            score_sport = 0;
            score_programmation = 0;
            score_total = 0;
        }


        public Joueur(string nom)
        {

            nom_joueur = nom;
            score_animaux = 0;
            score_science = 0;
            score_geo = 0;
            score_histoire = 0;
            score_sport = 0;
            score_total = 0;
            score_programmation = 0;

        }
        public Joueur() { }

        public int calculerScoreTotal()
        {
            score_total= score_animaux + score_programmation + score_geo + score_histoire + score_sport + score_science;
            return score_total;
        }
    }

}
