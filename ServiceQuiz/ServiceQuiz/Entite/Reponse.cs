using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ServiceQuiz.Entite
{
    public class Reponse
    {
        [Key]
        public int Id_reponse { get; set; }
        public int Id_question { get; set; }
        public string Nom_reponse { get; set; }
    }
}
