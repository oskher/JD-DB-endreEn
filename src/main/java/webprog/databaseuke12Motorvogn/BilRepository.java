package webprog.databaseuke12Motorvogn;

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

    public void lagreBil(Bil innBil){
        String sql = "INSERT INTO BIL (personnr, navn, adresse, kjennetegn, bilmerke, biltype) VALUES (?, ?, ?, ?, ?, ?)";
        database.update(sql, innBil.getPersonnr(), innBil.getNavn(), innBil.getAdresse(), innBil.getKjennetegn(),
                innBil.getBilmerke(), innBil.getBiltype());
    }

    public List<Bil> hentUt(){
        String sql = "SELECT * FROM Bil ORDER BY navn ASC";
        List<Bil> alleBiler = database.query(sql, new BeanPropertyRowMapper<>(Bil.class)); // row- etter lengden i class=Bil
        return alleBiler;
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
