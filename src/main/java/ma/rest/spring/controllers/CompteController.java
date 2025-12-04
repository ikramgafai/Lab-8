package ma.rest.spring.controllers;

import ma.rest.spring.entities.Compte;
import ma.rest.spring.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")
public class CompteController {

    @Autowired
    private CompteRepository repo;

    @GetMapping(value="/comptes", produces={"application/json","application/xml"})
    public List<Compte> getAll() {
        return repo.findAll();
    }

    @GetMapping(value="/comptes/{id}", produces={"application/json","application/xml"})
    public ResponseEntity<Compte> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value="/comptes", consumes={"application/json","application/xml"}, produces={"application/json","application/xml"})
    public Compte create(@RequestBody Compte c) {
        return repo.save(c);
    }

    @PutMapping(value="/comptes/{id}", consumes={"application/json","application/xml"}, produces={"application/json","application/xml"})
    public ResponseEntity<Compte> update(@PathVariable Long id, @RequestBody Compte c) {
        return repo.findById(id).map(existing -> {
            existing.setSolde(c.getSolde());
            existing.setDateCreation(c.getDateCreation());
            existing.setType(c.getType());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/comptes/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repo.findById(id).map(c -> {
            repo.delete(c);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}