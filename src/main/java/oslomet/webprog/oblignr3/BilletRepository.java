package oslomet.webprog.oblignr3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BilletRepository {
    //hente knyttningen til databasen
    @Autowired
    private JdbcTemplate db;

    //3 metoder
    public void lagreBillett(Billett innBillet){
        String sql = "INSERT INTO Billett (film, antall, fornavn, etternavn, telefonnr, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql, innBillet.getFilm(),innBillet.getAntall(),innBillet.getFornavn(),innBillet.getEtternavn(),innBillet.getTelefonnr(),innBillet.getEpost());
    }
    public List<Billett> hentAlleBilletter(){
        String sql = "SELECT * FROM Billett";
        return db.query(sql, new BeanPropertyRowMapper(Billett.class));

    }
    public void slettAlleBilletter(){
        String sql = "DELETE FROM Billett";
        db.update(sql);
    }
}
