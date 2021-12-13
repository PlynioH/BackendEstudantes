package com.example.fatecestudantesbackend.repository;

import com.example.fatecestudantesbackend.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {
}
