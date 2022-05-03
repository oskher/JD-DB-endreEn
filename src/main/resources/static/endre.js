$(function(){  // "ready-funksjon"  -   Kjøres når dokumentet er ferdig lastet
    hentMerke(); // nedtrekksMetode
    finneDenneEneBilen();   // Denne henter og aktiverer henteEn()metode.   Uten denne hadde henteEn() vært grå/ubrukt.
});

const finneDenneEneBilen = () => {
    const id = window.location.search.substring(1);  // Denne søker etter id til bil du har valgt
    const url = "/henteEnMotorvogn?id=" + id

    $.get(url, function (enMotorvogn){
        $("#personNr").val(enMotorvogn.personnr);
        $("#navn").val(enMotorvogn.navn);
        $("#adresse").val(enMotorvogn.adresse);
        $("#kjennetegn").val(enMotorvogn.kjennetegn);
        $("#merke").val(enMotorvogn.bilmerke).change();
        $("#type").val(enMotorvogn.biltype);
    });
}


function endreEnBil(){  // Endres fra lagre i index.
    console.log("1")
    const bil ={
        id : $("#id").val(),
        personnr : $("#personNr").val(),
        navn : $("#navn").val(),
        adresse : $("#adresse").val(),
        kjennetegn : $("#kjennetegn").val(),
        bilmerke : $("#valgtMerke").val(),
        biltype : $("#valgtType").val()
        /* Hvorfor trenger jeg en 3. konstruktør/en egen i JS?*/
    };

    // NB! Feil her?
    $.post("/endreEn", bil, () => {
        henteData();
    }).fail(function (jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);

        $("#feil").html(json.message);
    });
    window.location.href = "/";  //  Sender bruker tilbake til index.html
}



function hentMerke() {
    $.get( "/printMerke", function( biler ) {
        formaterMerke(biler);
    });
}
function formaterMerke(biler){
    let ut = "<select id='valgtMerke' onchange='finnTyper()'>";
    let i = 0;
    let forrigeMerke = "";
    ut+="<option>Velg merke</option>";
    for (const bil of biler){
        if(bil.merke != forrigeMerke){
            ut+="<option value='"+bil.merke+"'>"+bil.merke+"</option>";
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
            ut+="<option value='"+bil.type+"'>"+bil.type+"</option>";
        }
    }
    ut+="</select>";
    $("#type").html(ut);
}
