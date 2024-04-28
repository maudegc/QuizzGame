using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ServiceQuiz.Entite
{
    public class Question
    {
        [Key]
        public int Id_question { get; set; }
        public int Id_bonne_reponse { get; set; }
        public string Nom_question { get; set; }
        public string Categorie { get; set; }
    }
}
