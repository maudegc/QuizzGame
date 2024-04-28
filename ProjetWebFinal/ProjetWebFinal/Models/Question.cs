using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjetWebFinal.Models
{
    public class Question
    {
        public int id_question { get; set; }
        public int id_bonne_reponse { get; set; }
        public string nom_question { get; set; }
        public string categorie { get; set; }
        public Question()
        {

        }
        public Question(int idBonneReponse, string nomQuestion, string cat)
        {
            this.id_bonne_reponse = idBonneReponse;
            this.nom_question = nomQuestion;
            this.categorie = cat;
        }
    }
}
