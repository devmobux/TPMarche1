package tg.univ.kara.lpmmi.marches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tg.univ.kara.lpmmi.marches.model.Marche;
import tg.univ.kara.lpmmi.marches.model.ResponseObject;
import tg.univ.kara.lpmmi.marches.services.MarcheServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MarcheController {

    @Autowired
    private MarcheServiceImpl marcheInterface;

    @GetMapping("/api/marches")
    public ResponseEntity<Object> getMarches() {
        List<Marche> marches = marcheInterface.getMarches();
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK, "Success", marches));
    }

    @GetMapping("api/marches/{id}")
    public ResponseEntity<Object> findById(@PathVariable(required = true, name="id") int id) {
        Marche marche = marcheInterface.findById(id);
        if(marche != null) {
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK, "Success", marche));
        }
        return ResponseEntity.ok(new ResponseObject(HttpStatus.NOT_FOUND, "Marche not found", null));
    }

    @PostMapping("/api/marches")
    public ResponseEntity<Object> addMarche(@RequestBody Marche marche) {
        Marche addedMarche = marcheInterface.addMarche(marche);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(new ResponseObject(HttpStatus.CREATED, "Success", addedMarche));
    }

    @PutMapping("/api/marches/{id}")
    public ResponseEntity<Object> updateMarche(@PathVariable(required = true, name="id") int id, @RequestBody Marche marche) {
        Marche updateMarche = marcheInterface.updateMarche(id, marche);
        if(updateMarche != null) {
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK, "Success", updateMarche));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new ResponseObject(HttpStatus.NOT_FOUND, "Marche not found", null));
    }

    @DeleteMapping("/api/marches/{id}")
    public ResponseEntity<Object> deleteMarche(@PathVariable(required = true, name="id") int id) {
        Marche deleteMarche = marcheInterface.deleteMarche(id);
        if(deleteMarche != null) {
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK, "Success", null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new ResponseObject(HttpStatus.NOT_FOUND, "Marche not found", null));
    }

}
