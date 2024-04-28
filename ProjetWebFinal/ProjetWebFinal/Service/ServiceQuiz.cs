using Newtonsoft.Json;
using ProjetWebFinal.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Threading.Tasks;

namespace ProjetWebFinal.Service
{
    public class ServiceQuiz : IServiceQuiz
    {
        private string url = "https://localhost:44332";
        public async Task<Joueur> GetJoueurParNomAsync(string nom)
        {
            List<Joueur> listeJoueur = new List<Joueur>();
            Joueur joueur = new Joueur();
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);
                client.DefaultRequestHeaders.Clear();
                client.DefaultRequestHeaders.Add("ApiKey", "1111");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                HttpResponseMessage res = await client.GetAsync("/JoueurParNom/" + nom);
                if (res.IsSuccessStatusCode)
                {
                    var joueurReponse = res.Content.ReadAsStringAsync().Result;
                    listeJoueur = JsonConvert.DeserializeObject<List<Joueur>>(joueurReponse);
                    joueur = listeJoueur[0];
                }
            }
            
            return joueur;
        }
        public async Task<Joueur> GetJoueurParIdAsync(int id)
        {
            Joueur joueur = new Joueur();
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);
                client.DefaultRequestHeaders.Clear();
                client.DefaultRequestHeaders.Add("ApiKey", "1111");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                HttpResponseMessage res = await client.GetAsync("/JoueurParNom/" + id);
                if (res.IsSuccessStatusCode)
                {
                    var joueurReponse = res.Content.ReadAsStringAsync().Result;
                    joueur = JsonConvert.DeserializeObject<Joueur>(joueurReponse);
                }
            }
            return joueur;
        }

       public async Task<Joueur> AddJoueur(Joueur j)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);
                client.DefaultRequestHeaders.Clear();
                client.DefaultRequestHeaders.Add("ApiKey", "1111");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                HttpResponseMessage rep = new HttpResponseMessage();
                rep = await client.PostAsJsonAsync("/ajouter", j).ConfigureAwait(false);
                if (rep.IsSuccessStatusCode)
                {
                    return j;
                }
            }
            return null;
        }
        public async Task<int> updateJoueur(Joueur joueur)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Add("ApiKey", "1111");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                HttpResponseMessage res = await client.PutAsJsonAsync("/modifier", joueur);
                if (res.IsSuccessStatusCode)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        }
        public async Task<List<Joueur>> getJoueurs()
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri(url);
                client.DefaultRequestHeaders.Clear();
                client.DefaultRequestHeaders.Add("ApiKey", "1111");
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("text/plain"));
                HttpResponseMessage res = await client.GetAsync("/Joueurs");
                if (res.IsSuccessStatusCode)
                {
                    var joueurReponse = res.Content.ReadAsStringAsync().Result;
                    return JsonConvert.DeserializeObject<List<Joueur>>(joueurReponse);
                }
            }
            return null;
        }
        public Joueur GetJoueurParNom(string nom)
        {
            throw new NotImplementedException();
        }
    }
}
