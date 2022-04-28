package webprog.databaseuke12Motorvogn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BilController {

    @Autowired
    private BilRepository rep;

    @PostMapping("/registrer")
    public void registrer(Bil innRandomBil){

        rep.lagreBil(innRandomBil);
    }
    @GetMapping("/printBiler")
    public List<Bil> printUt(){

        return rep.hentUt();
    }
    @GetMapping("/printModell")
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
