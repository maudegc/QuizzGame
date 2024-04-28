"use strict";
var connection = new
    signalR.HubConnectionBuilder().withUrl("/chatHub").build();
document.getElementById("sendButton").disabled = true;

connection.start().then(function () {
    document.getElementById("sendButton").disabled = false;
    var user = document.getElementById("username").innerHTML;
    connection.invoke("RejoindreQuiz", user);


}).catch(function (err) {
    return console.error(err.toString());
});

//traitemets des fonctions venant de chatHub

connection.on("commencer", function () {
    afficherReponseServeur("Le quiz a commencé");

    //retirer EcranCommencer
    var ecranCommence = document.getElementById("ecranCommence");
    ecranCommence.remove();

    //afficher EcranQuestion
    var ecranQuestion = document.getElementById("ecranQuestion");
    ecranQuestion.style.display = "block";

});
connection.on("ReceiveMessage", function (user, message) {
    var div = document.createElement("div");
    div.className = "pb-4";
    div.innerHTML = '<div class="flex-shrink-1 bg-light rounded py-2 px-3"> <div class="font-weight-bold mb-1">' + user + '</div>' + message + '</div>';

    document.getElementById("messagesList").appendChild(div);
    scrollToEnd();
    ;
});

connection.on("Rejoindre", function (user) {
    afficherReponseServeur(user + " a rejoint le quiz");
    scrollToEnd();
});

connection.on("RecevoirReponse", function (user) {

    afficherReponseServeur(user + " a choisi ");

    scrollToEnd();
});
connection.on("VotreReponse", function (votreReponse,bonneReponse) {
    var divVotreReponse = document.getElementById("votreReponse");
    if (votreReponse.nom_reponse == bonneReponse.nom_reponse) {
        divVotreReponse.innerHTML = '<div class="d-flex align-items-center bg-success p-3 mb-3 text-white shadow-sm w-100 rounded">' + votreReponse.nom_reponse + '</div >';
    } else {
        divVotreReponse.innerHTML = '<div class="d-flex align-items-center bg-danger p-3 mb-3 text-white shadow-sm w-100 rounded">' + votreReponse.nom_reponse + '</div >';
    }
   
})
connection.on("FinTour", function (lesjoueurs, bonneReponse) {
    //retirer les reponses et montrer score
    var listeReponses = document.getElementById("lesReponses");
    var messageFin = document.getElementById("messageFinTour");
    
    viderDiv(listeReponses);
    cacherEcran("ecranAttente");
    montrerEcran("ecranScore");

    //aficher bonne Reponse & votre reponse
    var divBonneReponse = document.getElementById("bonneReponse");

    viderDiv(divBonneReponse);



    divBonneReponse.innerHTML = '<div class="d-flex align-items-center bg-success p-3 mb-3 text-white shadow-sm w-100 rounded">' + bonneReponse.nom_reponse + '</div >';







    //afficherClassement

    var divClassements = document.getElementById("classements");
    viderDiv(divClassements);
    var index = 1;
    lesjoueurs.forEach(joueur => {
        var unClassement = document.createElement("div");
        unClassement.className = 'd-flex align-items-center bg-white border p-3 text-dark shadow-sm w-100 rounded';
        unClassement.innerHTML = ' <div class="circle rounded-circle bg-primary text-white mr-3 d-flex justify-content-center align-items-center h4" id="reponse">' + index + '</div>' +
            '<div class="h4" id = "contenuReponse" >' + joueur.nom_joueur + '</div>' +
            '<div class="text-warning ml-auto h4">' + joueur.score_total + '</div>';
        divClassements.appendChild(unClassement);
        index++;
    });



});
connection.on("MontrerQuestionReponse", function (question, reponses) {


    //afficher ecran quiz
    montrerEcran("ecranQuiz");
    cacherEcran("ecranScore");
    //afficher Question + Categorie
    document.getElementById("question").innerHTML = question.nom_question;
    document.getElementById("categorie").innerHTML = question.categorie;

    //afficher reponse
    var listeReponses = document.getElementById("lesReponses");
    if (listeReponses.firstChild) {
        viderDiv(listeReponses);
    }
    var index = 1;
    reponses.forEach((uneReponse) => {
        var div = document.createElement("div");
        div.className = "d-flex align-items-center btn btn-light p-3 mb-3 text-dark shadow-sm w-100";
        div.onclick = function () { choisirReponse('' + uneReponse.id_reponse + '') };
        div.id = "sendReponse";

        div.innerHTML = '<div class="circle rounded-circle bg-primary text-white mr-3 d-flex justify-content-center align-items-center" id="reponse">' + index + '</div>' +
            '<div id="contenuReponse">' + uneReponse.nom_reponse + '</div>';
        listeReponses.appendChild(div);
        index++;
    });




})
connection.on("FinJeu", function (lesjoueurs) {

    cacherEcran("ecranScore");
    cacherEcran("ecranAttente");
    montrerEcran("ecranQuiz");

    document.getElementById("question").innerHTML = "Félicitations " + lesjoueurs[0].nom_joueur;

    var btnRetour = document.getElementById("categorie");
    btnRetour.innerHTML = "";
    var a = document.createElement("a");
    a.innerHTML = "Quitter";
    a.className = "btn btn-primary";
    a.href = "../Utilisateur/AcceuilJoueur";

    btnRetour.appendChild(a);

    var listeReponses = document.getElementById("lesReponses");
    if (listeReponses.firstChild) {
        viderDiv(listeReponses);
    }


    var index = 1;
    lesjoueurs.forEach((joueur) => {
        var div = document.createElement("div");
        div.className = 'd-flex align-items-center bg-white border p-3 text-dark shadow-sm w-100 rounded';
        div.innerHTML = ' <div class="circle rounded-circle bg-primary text-white mr-3 d-flex justify-content-center align-items-center h4" id="reponse">' + index + '</div>' +
            '<div class="h4" id = "contenuReponse" >' + joueur.nom_joueur + '</div>' +
            '<div class="text-warning ml-auto h4">' + joueur.score_total + '</div>';;
        listeReponses.appendChild(div);
        index++;
    });
})



//Ajouter onClick pour boutons

document.getElementById("sendButton").addEventListener("click", function
    (event) {
    var user = document.getElementById("username").innerHTML;
    var message = document.getElementById("messageInput").value;
    connection.invoke("SendMessage", user, message).catch(function (err) {
        return console.error(err.toString());
    });
    event.preventDefault();

});

document.getElementById("btnCommencer").addEventListener("click", function
    (event) {

    connection.invoke("CommencerQuiz").catch(function (err) {
        return console.error(err.toString());
    });
    event.preventDefault();

});

function choisirReponse(idReponse) {
    //bloquer user de choisir autre chose

    var user = document.getElementById("username").innerHTML;
    var reponse = idReponse;
    console.log(reponse);
    connection.invoke("ChoisirReponse", user, reponse).catch(function (err) {
        return console.error(err.toString());
    });


    cacherEcran("ecranQuiz");
    montrerEcran("ecranAttente");



    //event.preventDefault();
}
function nextQuestion() {
    connection.invoke("ProchaineQuestion")
}
// autres fonctions
function scrollToEnd() {
    var chatList = document.getElementById("messagesList");
    chatList.scrollTop = chatList.scrollHeight;
}

function afficherReponseServeur(message) {

    var div = document.createElement("div");
    div.className = "pb-4 d-flex justify-content-center";
    div.innerHTML = '<div class="flex-shrink-1 font-weight-bold">' + message + '</div>'
    document.getElementById("messagesList").appendChild(div);
}
function viderDiv(div) {

    if (div.firstChild) {
        while (div.firstChild) {
            div.removeChild(div.lastChild);
        }
    }



}
function montrerEcran(ecran) {
    document.getElementById(ecran).style.display = "block";
}
function cacherEcran(ecran) {
    //vider au lieu de le cacher parce que tu peux le decacher en code
    document.getElementById(ecran).style.display = "none";
}

