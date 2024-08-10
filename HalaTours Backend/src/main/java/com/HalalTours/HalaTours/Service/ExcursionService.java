package com.HalalTours.HalaTours.Service;

import com.HalalTours.HalaTours.Model.Excursion;
import com.HalalTours.HalaTours.Repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcursionService {

    private final ExcursionRepository excursionRepository;

    @Autowired
    public ExcursionService(ExcursionRepository excursionRepository) {
        this.excursionRepository = excursionRepository;
    }

    public List<Excursion> getAllExcursions() {
        return excursionRepository.findAll();
    }

    public Optional<Excursion> getExcursionById(Long id) {
        return excursionRepository.findById(id);
    }

    public Excursion createExcursion(Excursion excursion) {
        return excursionRepository.save(excursion);
    }
}
