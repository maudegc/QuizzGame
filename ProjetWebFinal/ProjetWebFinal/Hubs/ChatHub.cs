using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.SignalR;
using Newtonsoft.Json;
using ProjetWebFinal.Helpers;
using ProjetWebFinal.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Threading.Tasks;

namespace ProjetWebFinal.Hubs
{
    public class ChatHub : Hub
    {
        private static Quiz unQuiz = new Quiz();

        public async Task SendMessage(string user, string message)
        {

            await Clients.All.SendAsync("ReceiveMessage", user, message);
        }
        public async Task ChoisirReponse(string user, string reponse)
        {
            VerifierReponse(reponse, user);

            //enregistrer reponse joueur
            int indexJoueur = unQuiz.lesJoueurs.FindIndex(unJoueur => unJoueur.nom_joueur == user);
            Reponse votreReponse = unQuiz.ReponsesQuestionsEnCours.Find(rep => rep.id_reponse.ToString() == reponse);
            unQuiz.lesJoueurs[indexJoueur].reponseCourante = votreReponse;

            unQuiz.NombreDeReponse += 1;
            if (unQuiz.NombreDeReponse == unQuiz.lesJoueurs.Count)
            {
                await ToutLeMondeARepondue(reponse);
            }
           

            await Clients.All.SendAsync("RecevoirReponse", user);
        }

        public async Task ToutLeMondeARepondue(string reponse)
        {

            unQuiz.NombreDeReponse = 0;
            unQuiz.NombreQuestionRepondue++;
            if (unQuiz.NombreQuestionRepondue == unQuiz.NombreQuestionQuiz)
            {
                await FinduQuiz();
            }
            else
            {
                List<Joueur> joueursClassés = unQuiz.lesJoueurs.OrderByDescending(joueur => joueur.score_total).ToList();
                var bonneReponse = unQuiz.ReponsesQuestionsEnCours.Find(rep => rep.id_reponse == unQuiz.QuestionEnCours.id_bonne_reponse);

                foreach(Joueur user in unQuiz.lesJoueurs)
                {
                    await Clients.Group(user.nom_joueur).SendAsync("VotreReponse", user.reponseCourante,bonneReponse);
                }
                

                await Clients.All.SendAsync("FinTour", joueursClassés, bonneReponse);

            }


        }

        private async Task FinduQuiz()
        {
            await UpdateTousLesJoueurs();
            unQuiz.NombreQuestionRepondue = 0;
            List<Joueur> joueursClassés = unQuiz.lesJoueurs.OrderByDescending(joueur => joueur.score_total).ToList();
            unQuiz.lesJoueurs.Clear();
            unQuiz.NombreDeReponse = 0;
            unQuiz.EstCommence = false;
            unQuiz.QuestionEnCours = null;
            unQuiz.CategorieCourante = null;
            unQuiz.ReponsesQuestionsEnCours = null;
            await Clients.All.SendAsync("FinJeu", joueursClassés);
        }
        public async Task RejoindreQuiz(string user)
        {
            unQuiz.lesJoueurs.Add(new Joueur(user));
            Groups.AddToGroupAsync(Context.ConnectionId, user);
            await Clients.All.SendAsync("Rejoindre", user);
        }
        private void VerifierReponse(string reponse, string user)
        {


            int indexJoueur = unQuiz.lesJoueurs.FindIndex(unJoueur => unJoueur.nom_joueur == user);
            var bonneReponse = unQuiz.ReponsesQuestionsEnCours.Find(rep => rep.id_reponse == unQuiz.QuestionEnCours.id_bonne_reponse);
            if (reponse.Equals(bonneReponse.id_reponse.ToString()))
            {

                indexJoueur = unQuiz.lesJoueurs.FindIndex(unJoueur => unJoueur.nom_joueur == user);


                switch (unQuiz.CategorieCourante)
                {
                    case "programmation":

                        unQuiz.lesJoueurs[indexJoueur].score_programmation += 1;
                        unQuiz.lesJoueurs[indexJoueur].score_total += 1;
                        break;
                    case "science":
                        unQuiz.lesJoueurs[indexJoueur].score_science += 1;
                        unQuiz.lesJoueurs[indexJoueur].score_total += 1;
                        break;
                    case "animaux":
                        unQuiz.lesJoueurs[indexJoueur].score_animaux += 1;
                        unQuiz.lesJoueurs[indexJoueur].score_total += 1;
                        break;
                    case "histoire":

                        unQuiz.lesJoueurs[indexJoueur].score_histoire += 1;
                        unQuiz.lesJoueurs[indexJoueur].score_total += 1;
                        break;
                    case "geographie":
                        unQuiz.lesJoueurs[indexJoueur].score_geo += 1;
                        unQuiz.lesJoueurs[indexJoueur].score_total += 1;
                        break;
                    case "sport":
                        unQuiz.lesJoueurs[indexJoueur].score_sport += 1;
                        unQuiz.lesJoueurs[indexJoueur].score_total += 1;
                        break;
                }
            }
        }
        public async Task CommencerQuiz()
        {
            unQuiz.EstCommence = true;

            await ProchaineQuestion();
            await Clients.All.SendAsync("Commencer");
        }
        public async Task GQuiz()
        {
            unQuiz.QuestionEnCours = await GetQuestionDeApiAsync();
            unQuiz.ReponsesQuestionsEnCours = await GetReponseDeApi();

        }

        public async Task ProchaineQuestion()
        {
            await GQuiz();


            await Clients.All.SendAsync("MontrerQuestionReponse", unQuiz.QuestionEnCours, unQuiz.ReponsesQuestionsEnCours);

        }
        public async Task<Question> GetQuestionDeApiAsync()
        {
            Random rand = new Random();

            int index = rand.Next(0, unQuiz.categories.Count);
            unQuiz.CategorieCourante = unQuiz.categories[index];
            Random r = new Random();
            int rInt = r.Next(0, 10);


            List<Question> listeQuestionsProgrammation = new List<Question>();
            using (HttpClient httpClient = new HttpClient())
            {
                var uri = new Uri("https://localhost:44332/questionsParCat/" + unQuiz.CategorieCourante);

                httpClient.DefaultRequestHeaders.Clear();
                httpClient.DefaultRequestHeaders.Add("ApiKey", "1111");
                httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                var response = await httpClient.GetAsync(uri);
                var apiReponseReponse = await response.Content.ReadAsStringAsync();
                listeQuestionsProgrammation = JsonConvert.DeserializeObject<List<Question>>(apiReponseReponse);
                return listeQuestionsProgrammation[rInt];




            }
        }
        public async Task<List<Reponse>> GetReponseDeApi()
        {
            var uri = new Uri("https://localhost:44332/reponseParQuestionId/" + unQuiz.QuestionEnCours.id_question);
            using (HttpClient httpClient = new HttpClient())
            {

                httpClient.DefaultRequestHeaders.Clear();
                httpClient.DefaultRequestHeaders.Add("ApiKey", "1111");
                httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                var response = await httpClient.GetAsync(uri);
                string apiReponseReponse = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Reponse>>(apiReponseReponse);

            }

        }

        public async Task<Joueur> GetJoueur(string nom)
        {

            using (HttpClient client = new HttpClient())
            {
                client.BaseAddress = new Uri("https://localhost:44332");
                client.DefaultRequestHeaders.Clear();
                client.DefaultRequestHeaders.Add("ApiKey", "1111");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                HttpResponseMessage res = await client.GetAsync("/JoueurParNom/" + nom);
                if (res.IsSuccessStatusCode)
                {
                    var joueurReponse = res.Content.ReadAsStringAsync().Result;
                    return JsonConvert.DeserializeObject<List<Joueur>>(joueurReponse)[0];

                }
                return null;
            }
        }
        public async Task UpdateJoueur(Joueur joueur)
        {
            using (HttpClient client = new HttpClient())
            {
                client.BaseAddress = new Uri("https://localhost:44332");
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Add("ApiKey", "1111");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                HttpResponseMessage res = await client.PutAsJsonAsync("/modifier", joueur);
            }

        }
        public async Task UpdateTousLesJoueurs()
        {
            for (int i = 0; i < unQuiz.lesJoueurs.Count; i++)
            {
                Joueur leJoueur = await GetJoueur(unQuiz.lesJoueurs[i].nom_joueur);
                leJoueur.score_animaux += unQuiz.lesJoueurs[i].score_animaux;
                leJoueur.score_geo += unQuiz.lesJoueurs[i].score_geo;
                leJoueur.score_histoire += unQuiz.lesJoueurs[i].score_histoire;
                leJoueur.score_programmation += unQuiz.lesJoueurs[i].score_programmation;
                leJoueur.score_science += unQuiz.lesJoueurs[i].score_science;
                leJoueur.score_sport += unQuiz.lesJoueurs[i].score_sport;
                await UpdateJoueur(leJoueur);

            }
        }
    }
}


