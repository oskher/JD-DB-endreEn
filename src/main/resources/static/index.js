$(function(){  // kjøres når dokumentet er ferdig lastet
    henteData(); //  Henter data fra motorvognRegister / bil
});

function henteData(){
    let ut="<table class='table table-striped'>";
    ut += "<tr> " +
        "<th>Personnr:</th> " +
        "<th>Navn</th>" +
        "<th>Adresse</th>" +
        "<th>Kjennetegn</th>" +
        "<th>Bilmerke</th>" +
        "<th>Biltype</th>"+ "<th></th>"+ "<th></th>"+
        "</tr>";

    $.get("/printBiler", function (dataFraBilRegister){ // parameter kan hete hva som helst, men kommer fra server.
        for(let bil of dataFraBilRegister) {
            ut += "<tr>" +
                "<td>" +bil.personnr + "</td>" +
                "<td>" + bil.navn + "</td>" +
                "<td>"+ bil.adresse + "</td>" +
                "<td>" + bil.kjennetegn + "</td>" +
                "<td>" + bil.bilmerke + "</td>" +
                "<td>" + bil.biltype + "</td>" +
                "<td><a href='endre.html?" + bil.id + "' class='btn btn-primary' >Endre</a></td>" +
                "<td><button class='btn btn-danger' onclick='slettEn(" + bil.id + ")'>Slett</button></td>" +
                "</tr>";
        }
        ut+="</table>"
        $("#div1").html(ut);
    });
}

/*const idTilEndring = () => {
    window.location.href  = "/endre.html?" + id;          Denne er 2.måte å lage endreknapp. endreknapp må da ha: "<td><button class='btn btn-danger' onclick='idTilEndring(" + bil.id + ")'>Slett</button></td>" +
}*/


function slett() {
    // Henter ikke noe i function
    $.get("/slettAlle", function (){

    });

}

function slettEn(id){
    let url = "/slettEnBil?id="+ id;
    $.get(url, function (){
        window.location.href = "";
        henteData();
});
}