
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using Newtonsoft.Json;
using ProjetWebFinal.Helpers;
using ProjetWebFinal.Models;
using ProjetWebFinal.Service;

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Threading.Tasks;

namespace ProjetWebFinal.Controllers
{
    public class UtilisateurController : Controller
    {
        readonly ServiceQuiz _service;
        bool joueurExiste = false;
        string url = "https://localhost:44332";

        public UtilisateurController(ServiceQuiz service)
        {
            _service = service;
        }
        [Route("Utilisateur/AcceuilJoueur")]
        public IActionResult AccueilJoueur()
        {
            Joueur j = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");
            Joueur joueurService = GetJoueurParNom(j.nom_joueur).Result;
            ViewBag.joueur = joueurService;
            SessionHelper.SetObjectAsJson(HttpContext.Session, "joueur", joueurService);

            return View();
        }
        public IActionResult Index()
        {
            Joueur j = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");

            if (j != null)
            {
                ViewBag.joueur = j.nom_joueur;
            }
            return View();
        }

        public IActionResult SeConnecter()
        {
            return View("Connexion");
        }
        [HttpPost]
        public IActionResult SeConnecter(Joueur joueur)
        {
            if (!ModelState.IsValid)
            {
                return View("Connexion");
            }

            Joueur joueurService = null;

            try
            {
                joueurService = GetJoueurParNom(joueur.nom_joueur).Result;
            }
            catch (Exception e)
            {
                ViewBag.Message = e.Message.ToString();
            }

            if (joueurService != null)
            {
                if (joueur.nom_joueur.Equals(joueurService.nom_joueur) && joueur.mot_passe.Equals(joueurService.mot_passe))
                {
                    //ViewBag.joueur = joueurService;
                    joueur.mot_passe = "";
                    SessionHelper.SetObjectAsJson(HttpContext.Session, "joueur", joueurService);
                }
                else
                {
                    ViewBag.ErreurConnexion = "Nom ou mot de passe invalide";
                    return View("Connexion");
                }
            }
            else
            {
                ViewBag.ErreurConnexion = "Nom ou mot de passe invalide";
                return View("Connexion");
            }
            return View("AccueilJoueur");
        }
        public IActionResult SeDeconnecter()
        {
            Joueur j = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");
            if (j != null)
            {
                SessionHelper.Remove(HttpContext.Session, "joueur");
            }
            return RedirectToAction("Index");
        }
        public IActionResult Inscription()
        {
            return View();
        }
        [HttpPost]
        public async Task<IActionResult> Inscription(Joueur joueur, string mdpConfirme)
        {
            if (!ModelState.IsValid)
            {
                return View();
            }

            Joueur joueurSession = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");
            List<Joueur> joueursService = GetJoueurs().Result;

            if (mdpConfirme != null)
            {
                foreach (Joueur j in joueursService)
                {
                    joueurExiste = j.nom_joueur.ToLower() == joueur.nom_joueur.ToLower();
                    if (joueurExiste)
                    {
                        ViewBag.ErreurInscription = "Ce nom existe déjà";
                        return View();
                    }
                }

                if(!joueurExiste)
                {
                    if (joueur.mot_passe.Equals(mdpConfirme))
                    {
                        await _service.AddJoueur(joueur);
                        SeConnecter(joueur);
                        return View("AccueilJoueur");
                        
                    }
                    else
                    {
                        ViewBag.ErreurInscription = "Les mots de passes sont différents";
                        return View();
                    }
                }
            }
            else
            {
                ViewBag.ErreurInscription = "Insérez une confirmation de mot de passe";
                return View();

            }
            return View();
        }

        public IActionResult MonCompte()
        {
            Joueur joueurSession = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");
            ViewBag.nom = joueurSession.nom_joueur;
            joueurSession.mot_passe = "";
            SessionHelper.SetObjectAsJson(HttpContext.Session, "joueur", joueurSession);
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> MonCompte(Joueur joueur, string nouveauMotPasse, string confirmMotPasse)
        {
            Joueur joueurSession = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");
            Joueur joueurService = GetJoueurParNom(joueurSession.nom_joueur).Result;
            Joueur joueurChange = joueurService;
            ViewBag.nom = joueurChange.nom_joueur;
            if (!ModelState.IsValid)
            {
                return View();
            }

            if (joueur.mot_passe.Equals(joueurService.mot_passe))
            {
                joueurChange.nom_joueur = joueur.nom_joueur;
                if (nouveauMotPasse != null && confirmMotPasse != null)
                {
                    if (nouveauMotPasse == confirmMotPasse)
                    {
                        joueurChange.mot_passe = nouveauMotPasse;
                        ViewBag.ErreurCompte = "Votre mot de passe a été changé";

                    }
                    else
                    {
                        ViewBag.ErreurCompte = "Les mots de passes sont différents";
                    }
                }
                await UpdateJoueur(joueurChange);
                joueur.mot_passe = "";
                SessionHelper.SetObjectAsJson(HttpContext.Session, "joueur", joueurChange);
                ViewBag.nom = joueurChange.nom_joueur;
            }
            else
            {
                ViewBag.ErreurCompte = "Le mot de passe est incorrecte";
            }
            return View();
        }

        // Méthose du service
        public async Task<List<Joueur>> GetJoueurs()
        {
            List<Joueur> joueurs = await _service.getJoueurs();
            if (joueurs == null)
            {
                joueurs = new List<Joueur>();
            }
            ViewBag.joueurs = joueurs;
            return joueurs;
        }
        public async Task<Joueur> GetJoueurParId(int id)
        {
            Joueur joueur = await _service.GetJoueurParIdAsync(id);
            ViewBag.joueur = joueur;
            return joueur;

        }
        public async Task<Joueur> GetJoueurParNom(string nom)
        {
            Joueur joueur = await _service.GetJoueurParNomAsync(nom);
            ViewBag.joueur = joueur;
            return joueur;

        }

        public async Task<int> UpdateJoueur(Joueur joueur)
        {
            return await _service.updateJoueur(joueur);
        }      
    }
}
