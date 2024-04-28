using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using ProjetWebFinal.Helpers;
using ProjetWebFinal.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace ProjetWebFinal.Controllers
{

    public class QuizController : Controller
    {       
        static int counter = 0;
        static object lockObj = new object();
       
        public async Task<IActionResult> Index(string categorie)
        {
            Joueur j = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");
            if (j == null)
            {
                
                return RedirectToAction("SeConnecter", "Utilisateur");
            }
            return View(j);
        }

        public IActionResult Categorie(int reponse)
        {
            if (TempData.ContainsKey("idBonneReponse"))
            {
                if (reponse.ToString() == TempData["idBonneReponse"].ToString())
                {
                    // créer une variable session avec le nombre de points que l'utilisateur possède
                    // donc ajouter un point si la reponse est correcte
                    TempData.Remove("idBonneReponse");
                    ViewBag.pareil = "pareil";
                    lock (lockObj)
                    {
                        counter++;
                    }
                }
                else
                {
                    // ne pas ajouter de point si la reponse est incorrecte.
                    TempData.Remove("idBonneReponse");
                    ViewBag.pareil = "pas pareil";
                    
                }
            }
            var rnd = new Random();
            ViewBag.points = counter;
            TempData["points"] = counter;
            return View();
        }
        public IActionResult FinDePartie()
        {
            ViewBag.points = TempData["points"];
            return View();
        }

        public IActionResult Chat()
        {
            Joueur j = SessionHelper.GetObjectFromJson<Joueur>(HttpContext.Session, "joueur");
            if (j == null)
            {
              
                return RedirectToAction("SeConnecter", "Utilisateur");
            }
            return View(j);
        }

        public IActionResult Classement()
        {
            ViewBag.lesJoueurs = JoueurBidon.listeJoueur();
            return View();
        }      
    }
}
