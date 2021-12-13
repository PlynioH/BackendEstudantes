package com.example.fatecestudantesbackend.controller;

import com.example.fatecestudantesbackend.entity.Estudante;
import com.example.fatecestudantesbackend.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudantes")
@CrossOrigin
public class EstudanteController {
    @Autowired
    private EstudanteRepository repo;

    @GetMapping
    public List<Estudante> getEstudantes(){
        List<Estudante> list = repo.findAll();
        return  list;
    }

    @GetMapping("{id}")
    public Estudante getEstudante(@PathVariable int id) {
        Optional<Estudante> op = repo.findById(id);
        Estudante estudante = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return estudante;
    }

    @PostMapping
    public Estudante salvar(@RequestBody Estudante estudante){
        estudante = repo.save(estudante);
        return estudante;
    }

    @PutMapping("{id}")
    public Estudante alterar(@RequestBody Estudante estudanteDados, @PathVariable Integer id){
        Optional<Estudante> op = repo.findById(id);
        Estudante estudante = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        estudante.setNome(estudanteDados.getNome());
        estudante.setCpf(estudanteDados.getCpf());
        estudante.setEndereco(estudanteDados.getEndereco());
        estudante.setIdade(estudanteDados.getIdade());
        estudante.setSangue(estudanteDados.getSangue());
        estudante.setSexo(estudanteDados.getSexo());
        repo.save(estudante);
        return estudante;
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id){
        Optional<Estudante> op = repo.findById(id);
        Estudante estudante = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(estudante);
    }
}
