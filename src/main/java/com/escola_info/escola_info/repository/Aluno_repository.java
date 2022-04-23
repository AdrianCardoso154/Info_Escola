package com.escola_info.escola_info.repository;

import com.escola_info.escola_info.entities.world.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Aluno_repository extends JpaRepository<Aluno, UUID> {
}
