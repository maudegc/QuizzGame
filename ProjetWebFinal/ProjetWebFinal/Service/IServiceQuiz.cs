using ProjetWebFinal.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjetWebFinal.Service
{
    public interface IServiceQuiz
    {
        public Joueur GetJoueurParNom(String nom);

    }
}
