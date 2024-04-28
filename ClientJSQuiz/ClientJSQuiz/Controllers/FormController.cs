using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ClientJSQuiz.Controllers
{
    public class FormController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult FormAjouterQuestion()
        {
            return View();
        }
        public IActionResult FormAjouterReponse()
        {
            return View();
        }
        public IActionResult FormUpdateQuestion()
        {
            return View();
        }
        public IActionResult FormUpdateReponse()
        {
            return View();
        }
        public IActionResult FormDeleteQuestion()
        {
            return View();
        }
        public IActionResult FormDeleteReponse()
        {
            return View();
        }
    }
}
