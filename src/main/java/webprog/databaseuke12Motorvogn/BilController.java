package webprog.databaseuke12Motorvogn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BilController {

    @Autowired
    private BilRepository rep;

    @PostMapping("/registrer")
    public void registrer(Bil innRandomBil, HttpServletResponse response) throws IOException {
        if(!rep.lagreBil(innRandomBil)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i database, prøv igjen senere");
        }

        //rep.lagreBil(innRandomBil);
    }
    @GetMapping("/henteEnMotorvogn")
    public Bil hentEnBil(int id){
        return rep.hentEnBil(id);
    }

    @PostMapping("/endreEn")  // Lagrer verdier
    public void endre(Bil innBil){
        rep.endreEnBil(innBil);
    }

    @GetMapping("/printBiler")
    public List<Bil> printUt(){

        return rep.hentUt();
    }
    @GetMapping("/printMerke")
    public List <Modell> printUtM(){
        return rep.hentUtM();
    }


    @GetMapping("/slettAlle")
    public void slettAlleMetodeNavn(){
        rep.slettAlleBiler();
    }

    @GetMapping("/slettEnBil")
    public void slettEn(int id){
        rep.slettenbil(id);
    }
}
