
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ServiceQuiz.DAO;
using ServiceQuiz.Entite;
using ServiceQuiz.Securite;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Http.Cors;

namespace ServiceQuiz.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    [ApiKey]
    public class QuizController : ControllerBase
    {
        private readonly IQuizDAO _dao;
        public QuizController(IQuizDAO dao)
        {
            _dao = dao;
        }

        //Joueur
        [HttpGet("/Joueurs")]
        public async Task<IEnumerable<Joueur>> ListeJoueurs()
        {
            return await _dao.GetJoueurs();
        }
        [HttpGet("/JoueurParId/{id}")]
        public async Task<Joueur> GetJoueur(int id)
        {
            return await _dao.GetJoueur(id);
        }
        [HttpGet("/JoueurParNom/{nom}")]
        public IEnumerable<Joueur> JoueurParNom(string nom)
        {
            return _dao.GetJoueurParNom(nom);
        }
        [HttpPost("/ajouter")]
        public async Task<ActionResult<Joueur>> AjouterJoueur([FromBody]Joueur joueur)
        {
            var newJoueur = await _dao.AddJoueur(joueur);
            return CreatedAtAction(nameof(GetJoueur), new { id = newJoueur.Id_joueur }, newJoueur);
        }
        [HttpPut("/modifier")]
        public async Task<int> ModifierJoueur([FromBody] Joueur joueur)
        {
            return await _dao.UpdateJoueur(joueur);
        }
        [HttpDelete("/supprimer/{id}")]
        public async Task<int> SupprimerJoueur(int id)
        {
            return await _dao.DeleteJoueur(id);
        }

        //Question
        [HttpGet("/questions")]
        public async Task<IEnumerable<Question>> ListeQuestions()
        {
            return await _dao.GetQuestions();
        }
        [HttpGet("/questions/{id}")]
        public async Task<ActionResult<Question>> GetQuestion(int id)
        {
            return await _dao.GetQuestionParId(id);
        }
        [HttpGet("/questionsParCat/{categorie}")]
        public IEnumerable<Question> ListeQuestionsParCategorie(string categorie)
        {
            //return await _dao.GetQuestionsParCategorie(categorie);
            return _dao.GetQuestionsParCategorie(categorie);
        }
        [HttpPost("/ajouterQuestion")]
        public async Task<ActionResult<Question>> AjouterQuestion([FromBody] Question question)
        {
            var newQuestion = await _dao.AddQuestion(question);
            return CreatedAtAction(nameof(GetQuestion), new { id = newQuestion.Id_question }, newQuestion);
        }
        [HttpPut("/modifierQuestion")]
        public async Task<int> ModifierQuestion([FromBody] Question question)
        {
            return await _dao.UpdateQuestion(question);   
        }

        [HttpDelete("/supprimerQuestion/{id}")]
        public async Task<int> SupprimerQuestion(int id)
        {
            return await _dao.DeleteQuestion(id);
       
        }

        //Reponse
        [HttpGet("/reponses")]
        public async Task<IEnumerable<Reponse>> ListeReponses()
        {
            return await _dao.GetReponses();
        }
        [HttpGet("/reponses/{id}")]
        public async Task<ActionResult<Reponse>> GetReponse(int id)
        {
            return await _dao.GetReponseParId(id);
        }
        [HttpGet("/reponseParQuestionId/{idQuestion}")]
        public IEnumerable<Reponse> ListeReponsesParQuestionId(int idQuestion)
        {
            return _dao.GetReponseParQuestionId(idQuestion);
        }
        [HttpPost("/ajouterReponse")]
        public async Task<ActionResult<Reponse>> AjouterReponse([FromBody] Reponse reponse)
        {
            var newReponse = await _dao.AddReponse(reponse);
            return CreatedAtAction(nameof(GetReponse), new { id = newReponse.Id_question }, newReponse);
        }
        [HttpPut("/modifierReponse")]
        public async Task<int> ModifierReponse([FromBody] Reponse reponse)
        {
            return await _dao.UpdateReponse(reponse);
        }
        [HttpDelete("/supprimerReponse/{id}")]
        public async Task<int> SupprimerReponse(int id)
        {
            return await  _dao.DeleteReponse(id);
           
        }
    }
}
