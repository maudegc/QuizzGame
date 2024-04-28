using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;
using ServiceQuiz.Entite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ServiceQuiz.DAO
{
    public class QuizDAO : IQuizDAO
    {
        private readonly QuizContext _context;
        public QuizDAO(QuizContext context)
        {
            _context = context;
        }

        //Joueur
        public async Task<Joueur> AddJoueur(Joueur j)
        {
            _context.joueur.Add(j);
            await _context.SaveChangesAsync();
            return j;
        }

        public async Task<int> DeleteJoueur(int id)
        {
            Joueur j = await _context.joueur.FindAsync(id);
            if (j != null)
            {
                _context.joueur.Remove(j);
            }
            
            return await _context.SaveChangesAsync();
        }

        public async Task<Joueur> GetJoueur(int id)
        {
            return await _context.joueur.FindAsync(id);
        }
        public IEnumerable<Joueur> GetJoueurParNom(string nom)
        { 
            return _context.joueur.Where(joueur => joueur.Nom_joueur.Equals(nom));
        }
        public async Task<IEnumerable<Joueur>> GetJoueurs()
        {
            return await _context.joueur.ToListAsync();
        }

        public async Task<int> UpdateJoueur(Joueur j)
        {
            _context.joueur.Update(j);
            return await _context.SaveChangesAsync();
        }

        //Question
        public async Task<Question> AddQuestion(Question question)
        {
            _context.question.Add(question);
            await _context.SaveChangesAsync();
            return question;

        }
        public async Task<IEnumerable<Question>> GetQuestions()
        {
            return await _context.question.ToListAsync();
        }
        public async Task<Question> GetQuestionParId(int id)
        {
            return await _context.question.FindAsync(id);
        }
        public IEnumerable<Question> GetQuestionsParCategorie(string categorie)
        {
            return _context.question.Where(question => question.Categorie.Equals(categorie));
        }
        public async Task<int> UpdateQuestion(Question question)
        {
            _context.Entry(question).State = EntityState.Modified;
            return await _context.SaveChangesAsync();
        }
        public async Task<int> DeleteQuestion(int id)
        {
            Question question = await _context.question.FindAsync(id);
            if (question != null)
            {
                _context.question.Remove(question);
            }

            return await _context.SaveChangesAsync();
        }

        //Reponse
        public async Task<IEnumerable<Reponse>> GetReponses()
        {
            return await _context.reponse.ToListAsync();
        }

        public async Task<Reponse> GetReponseParId(int id)
        {
            return await _context.reponse.FindAsync(id);
        }
        public  IEnumerable<Reponse> GetReponseParQuestionId(int idQuestion)
        {
            return _context.reponse.Where(reponse => reponse.Id_question == idQuestion);
        }
        public async Task<Reponse> AddReponse(Reponse reponse)
        {
            _context.reponse.Add(reponse);
            await  _context.SaveChangesAsync();
            return reponse;
        }

        public async Task<int> UpdateReponse(Reponse reponse)
        {
            _context.Entry(reponse).State = EntityState.Modified;
            return await  _context.SaveChangesAsync();
        }

        public async Task<int> DeleteReponse(int id)
        {
            Reponse reponse = await _context.reponse.FindAsync(id);
            if (reponse != null)
            {
                _context.reponse.Remove(reponse);
            }

            return await _context.SaveChangesAsync();
        }
    }
}
