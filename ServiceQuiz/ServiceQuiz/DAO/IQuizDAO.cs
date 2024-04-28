using ServiceQuiz.Entite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ServiceQuiz.DAO
{
    public interface IQuizDAO
    {
        //Joueur
        public Task<IEnumerable<Joueur>> GetJoueurs();
        public Task<Joueur> GetJoueur(int id);
        public IEnumerable<Joueur> GetJoueurParNom(string nom);
        public Task<Joueur> AddJoueur(Joueur j);
        public Task<int> UpdateJoueur(Joueur j);
        public Task<int> DeleteJoueur(int id);

        //Question
        public Task<IEnumerable<Question>> GetQuestions();
        public Task<Question> GetQuestionParId(int id);
        public IEnumerable<Question> GetQuestionsParCategorie(string categorie);
        public Task<Question> AddQuestion(Question question);
        public Task<int> UpdateQuestion(Question question);
        public Task<int> DeleteQuestion(int id);

        //Reponse
        public Task<IEnumerable<Reponse>> GetReponses();
        public Task<Reponse> GetReponseParId(int id);
        public IEnumerable<Reponse> GetReponseParQuestionId(int idQuestion);
        public Task<Reponse> AddReponse(Reponse reponse);
        public Task<int> UpdateReponse(Reponse reponse);
        public Task<int> DeleteReponse(int id);
    }
}
