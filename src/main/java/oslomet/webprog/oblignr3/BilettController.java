package oslomet.webprog.oblignr3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BilettController {

    @Autowired
    BilletRepository rep;

    // POST endpoint to save a ticket
    @PostMapping("/lagre")
    public void lagreBillett( Billett innBillett) { // Ensure @RequestBody is used to parse JSON
        rep.lagreBillett(innBillett); // Save the ticket to the repository
    }


    // GET endpoint to retrieve all tickets
    @GetMapping("/hentAlle")
    public List<Billett> hentAlle() {
        return rep.hentAlleBilletter();
    }

    // GET endpoint to delete all tickets
    @GetMapping("/slettAlle")
    public void slettAlleBilletter() {
        rep.slettAlleBilletter();
    }
}