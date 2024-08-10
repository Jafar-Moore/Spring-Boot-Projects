package com.HalalTours.HalaTours.Controller;

import com.HalalTours.HalaTours.Model.Excursion;
import com.HalalTours.HalaTours.Service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("http://127.0.0.1:5502")
public class ExcursionController {

    private final ExcursionService excursionService;

    @Autowired
    public ExcursionController(ExcursionService excursionService) {
        this.excursionService = excursionService;
    }

    @GetMapping("/getallexcursions")
    public ResponseEntity<List<Excursion>> getAllExcursions() {
        List<Excursion> excursions = excursionService.getAllExcursions();
        return ResponseEntity.ok(excursions );
    }

    @GetMapping("/getexcursion/{id}")
    public ResponseEntity<Excursion> getExcursionById(@PathVariable Long id) {
        Optional<Excursion> excursion = excursionService.getExcursionById(id);
        return excursion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createexcursion")
    public ResponseEntity<Excursion> createExcursion(@RequestBody Excursion excursion) {
        Excursion createdExcursion = excursionService.createExcursion(excursion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExcursion);
    }

}

