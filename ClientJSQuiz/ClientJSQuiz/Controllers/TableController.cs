using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ClientJSQuiz.Controllers
{
    public class TableController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult GetQuestions()
        {
            return View();
        }
        public IActionResult GetReponses()
        {
            return View();
        }
    }
}
