using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjetWebFinal.Models
{
    public class Quiz
    {
        public string Nom { get; set; }
        public List<Joueur> lesJoueurs { get; set; }
        public int NombreDeReponse { get; set; }
        public Boolean EstCommence { get; set; }
        public Question QuestionEnCours { get; set; }
        public string CategorieCourante { get; set; }
        public List<Reponse> ReponsesQuestionsEnCours { get; set; }
        public int NombreQuestionQuiz { get; set; }
        public List<String> categories { get; set; }
        public int NombreQuestionRepondue { get; set; }
        public Quiz()
        {
            lesJoueurs = new List<Joueur>();
            NombreDeReponse = 0;
            EstCommence = false;
            ReponsesQuestionsEnCours = new List<Reponse>();
            NombreQuestionQuiz = 10;
            categories = new List<string>()
                    {
                        "animaux",
                        "programmation",
                        "science",
                        "sport",
                        "histoire",
                        "geographie"
                    };
            NombreQuestionRepondue = 0;

        }
    }
}
