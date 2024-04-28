using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ServiceQuiz.Entite
{
   
    public class Joueur
    {
        [Key]
        public int Id_joueur { get; set; }
        public string Nom_joueur { get; set; }
        public string Mot_passe { get; set; }
        public int Score_science { get; set; }
        public int Score_histoire { get; set; }
        public int Score_sport { get; set; }
        public int Score_animaux { get; set; }
        public int Score_programmation { get; set; }
        public int Score_geo { get; set; }

    }

}
