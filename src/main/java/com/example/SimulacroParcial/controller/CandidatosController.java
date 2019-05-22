package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Candidato;
import com.example.SimulacroParcial.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidato")
public class CandidatosController {
    private static final String PERSON_NOT_FOUND = "No existe el candidato con el id: %s";

    @Autowired
    CandidatoRepository candidatoRepository;

    @PostMapping("/add")
    public void addCandidato(@RequestBody final Candidato p) {
        candidatoRepository.save(p);
    }


    @PostMapping("{id}/vote")
    public void votar(@PathVariable final Integer id) {
        Candidato c = candidatoRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PERSON_NOT_FOUND,id)));
        c.recirVoto();
        candidatoRepository.save(c); //porque?
    }

    @GetMapping(value = "/all")
    public List<Candidato> getAll(){
        return candidatoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Candidato> getById(@PathVariable final Integer id){
        return candidatoRepository.findById(id);
    }
}
