using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjetWebFinal.Models
{
    public class QuestionBidon
    {
        static public List<String> listeCategories()
        {
            List<String> uneListe = new List<String>();

            uneListe.Add("francais");
            uneListe.Add("histoire");
            uneListe.Add("technologie");
            uneListe.Add("science");
            uneListe.Add("mathematique");

            return uneListe;
        }
        static public Question questionScience()
        {
            Question uneQuestion = new Question(0,"cest quoi diaphragme", "Science");

            return uneQuestion;
        }
        static public List<Reponse> reponseScience()
        {
            List<Reponse> listeReponse = new List<Reponse>();

            Reponse reponse1 = new Reponse(0, 0, "un Os");
            Reponse reponse2 = new Reponse(1, 0, "un Muscle");
            Reponse reponse3 = new Reponse(2, 0, "Une vertebre");
            Reponse reponse4 = new Reponse(3, 0, "Un tendon");
            listeReponse.Add(reponse1);
            listeReponse.Add(reponse2);
            listeReponse.Add(reponse3);
            listeReponse.Add(reponse4);
            return listeReponse;
        }
        static public Question questionFrancais()
        {
            Question uneQuestion = new Question(1,"mot horse en francais", "Francais");
            return uneQuestion;
        }
        static public List<Reponse> reponseFrancais()
        {
            List<Reponse> listeReponse = new List<Reponse>();
            Reponse reponse1 = new Reponse(0, 1, "un chien");
            Reponse reponse2 = new Reponse(1, 1, "un cheval");
            Reponse reponse3 = new Reponse(2, 1, "Une elephant");
            Reponse reponse4 = new Reponse(3, 1, "Un chat");
            listeReponse.Add(reponse1);
            listeReponse.Add(reponse2);
            listeReponse.Add(reponse3);
            listeReponse.Add(reponse4);

            return listeReponse;
        }
        static public Question questionMathematique()
        {
            Question uneQuestion = new Question(2, "2+2", "Mathematique");
            return uneQuestion;
        }
        static public List<Reponse> reponseMathematique()
        {
            List<Reponse> listeReponse = new List<Reponse>();
            Reponse reponse1 = new Reponse(0, 2, "0");
            Reponse reponse2 = new Reponse(1, 2, "3");
            Reponse reponse3 = new Reponse(2, 2, "4");
            Reponse reponse4 = new Reponse(3, 2, "1");
            listeReponse.Add(reponse1);
            listeReponse.Add(reponse2);
            listeReponse.Add(reponse3);
            listeReponse.Add(reponse4);

            return listeReponse;
        }


        static public Question questionHistoire()
        {
            Question uneQuestion = new Question(3, "le roi despagne", "Histoire");

            return uneQuestion;
        }
        static public List<Reponse> reponseHistoire()
        {
            List<Reponse> listeReponse = new List<Reponse>();
            Reponse reponse1 = new Reponse(0, 3, "maurice");
            Reponse reponse2 = new Reponse(1, 3, "jacque");
            Reponse reponse3 = new Reponse(2, 3, "jean");
            Reponse reponse4 = new Reponse(3, 3, "Rene");
            listeReponse.Add(reponse1);
            listeReponse.Add(reponse2);
            listeReponse.Add(reponse3);
            listeReponse.Add(reponse4);

            return listeReponse;
        }
        static public Question questionTechnologie()
        {
            Question uneQuestion = new Question(0, "meilleur technolgoie", "Technologie");
            return uneQuestion;
        }
        static public List<Reponse> reponseTechnologie()
        {
            List<Reponse> listeReponse = new List<Reponse>();
            Reponse reponse1 = new Reponse(0, 4, "Ipod");
            Reponse reponse2 = new Reponse(1, 4, "Ipad");
            Reponse reponse3 = new Reponse(2, 4, "Laptop");
            Reponse reponse4 = new Reponse(3, 4, "Ventilateur");
            listeReponse.Add(reponse1);
            listeReponse.Add(reponse2);
            listeReponse.Add(reponse3);
            listeReponse.Add(reponse4);

            return listeReponse;
        }
       

    }
}
