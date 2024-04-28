using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ServiceQuiz.Entite
{
    public class QuizContext: DbContext
    {
        public QuizContext(DbContextOptions<QuizContext> options) : base(options)
        {
            Database.EnsureCreated();
        }
        public DbSet<Joueur> joueur { get; set; }
        public DbSet<Question> question { get; set; }
        public DbSet<Reponse> reponse { get; set; }
    }
}
