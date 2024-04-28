using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjetWebFinal.Models
{
    public class Reponse
    {
        public int id_reponse { get; set; }
        public int id_question { get; set; }
        public string nom_reponse { get; set; }
        
        public Reponse() { }
        public Reponse(int idReponse,int idQuestion, string nomReponse)
        {
            this.id_reponse = idReponse;
            this.id_question = idQuestion;
            this.nom_reponse = nomReponse;
          
        }
    }
}
