$(function(){  // kjøres når dokumentet er ferdig lastet
    hentAlleBiler(); // nedtrekksMetode
});




function lagre(){
    console.log("1")
    const Bil ={
        personnr : $("#personNr").val(),
        navn : $("#navn").val(),
        adresse : $("#adresse").val(),
        kjennetegn : $("#kjennetegn").val(),
        bilmerke : $("#valgtMerke").val(),
        biltype : $("#valgtType").val()
        /* Hvorfor trenger jeg en 3. konstruktør/en egen i JS?*/
    };
    const url = "/registrer";
    $.post(url, Bil, function(){
        henteData();
    }).fail(function (jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);

        $("#feil").html(json.message);
    });

    window.location.href = "/";
}
function henteData(){
    let ut="<table class='table table-striped'>";
    ut += "<tr> " +
        "<th>Personnr:</th> " +
        "<th>Navn</th>" +
        "<th>Adresse</th>" +
        "<th>Kjennetegn</th>" +
        "<th>Bilmerke</th>" +
        "<th>Biltype</th>"+ "<th></th>"+
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
                // "<td><a href='endre.html' class='btn btn-primary' >Endre</a></td>" +
                "<td><button class='btn primary' onclick='endreEn(" + bil.id + ")'>Endre</button></td>" +
                "<td><button class='btn btn-danger' onclick='slettEn(" + bil.id + ")'>Slett</button></td>" +
                "</tr>";
        }
        ut+="</table>"
        $("#div1").html(ut);
    });
}
function endreEn(id){  // Denne tar inn en id valgt fra registrer.html
    window.location.href = "/endre.html?" + id;   // id lagret her, må søkes etter med metode henteEn()
}

function hentAlleBiler() {
    $.get( "/printModell", function( biler ) {
        formaterBiler(biler);
    });
}
function formaterBiler(biler){
    let ut = "<select id='valgtMerke' onchange='finnTyper()'>";
    let i = 0;
    let forrigeMerke = "";
    ut+="<option>Velg merke</option>";
    for (const bil of biler){
        if(bil.merke != forrigeMerke){
            ut+="<option>"+bil.merke+"</option>";
        }
        forrigeMerke = bil.merke;
    }
    ut+="</select>";
    $("#merke").html(ut);
}

function finnTyper(){
    const valgtMerke = $("#valgtMerke").val();
    $.get( "/printModell", function( biler ) {
        formaterTyper(biler,valgtMerke);
    });
}
function formaterTyper(biler,valgtMerke){
    let ut = "<select id='valgtType'>";
    for(const bil of biler ){
        if(bil.merke === valgtMerke){
            ut+="<option>"+bil.type+"</option>";
        }
    }
    ut+="</select>";
    $("#type").html(ut);
}