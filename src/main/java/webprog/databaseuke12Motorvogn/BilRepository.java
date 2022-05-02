package webprog.databaseuke12Motorvogn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository
public class BilRepository {

    @Autowired
    private JdbcTemplate database;
    private Logger logger= LoggerFactory.getLogger(BilRepository.class);

    public boolean lagreBil(Bil innBil){ // endre type fra Void til Bolean
        String sql = "INSERT INTO BIL (personnr, navn, adresse, kjennetegn, bilmerke, biltype) VALUES (?, ?, ?, ?, ?, ?)";
        database.update(sql, innBil.getPersonnr(), innBil.getNavn(), innBil.getAdresse(), innBil.getKjennetegn(),
                innBil.getBilmerke(), innBil.getBiltype());

        try{
            database.update(sql, innBil.getPersonnr(), innBil.getNavn(), innBil.getAdresse(),
                    innBil.getKjennetegn(), innBil.getBiltype(), innBil.getBiltype());
            return true;
        } catch(Exception e){
            logger.error("Feil i lagreBil metode: " + e);
            return false;

        }
    }

    public List<Bil> hentUt(){
        String sql = "SELECT * FROM Bil ORDER BY navn ASC";
        List<Bil> alleBiler = database.query(sql, new BeanPropertyRowMapper<>(Bil.class)); // row- etter lengden i class=Bil
        return alleBiler;
    }
    public Bil hentEnBilar(int id){
        String sql = "SELECT * FROM Bil WHERE id=?";
        List<Bil> enBil = database.query(sql, new BeanPropertyRowMapper(Bil.class), id);
        return enBil.get(0);   // sender allti første rad = 0 indeks.
    }

    public void endreEnBilar(Bil innBil){
        String sql ="UPDATE Bil SET personnr=?, navn=?, adresse=?, kjennetegn=?, bilmerke=?, biltype=? WHERE id=?";
        database.update(sql, innBil.getPersonnr(), innBil.getNavn(), innBil.getAdresse(), innBil.getKjennetegn(),
                innBil.getBilmerke(), innBil.getBiltype());
    }

    public List<Modell> hentUtM() {
        String sql = "SELECT * FROM Modell";
        return database.query(sql,new BeanPropertyRowMapper(Modell.class));
    }


    public void slettAlleBiler(){  //    NB!      VOID  - returnerer ikke noe.
        String sql = "DELETE FROM Bil";
        database.update(sql);
    }
    public void slettenbil(int id){
        String sql = "DELETE FROM Bil WHERE  id=?";
        database.update(sql, id);
    }
}
