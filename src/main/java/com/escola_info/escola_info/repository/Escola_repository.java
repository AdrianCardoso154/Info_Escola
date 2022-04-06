package com.escola_info.escola_info.repository;

import com.escola_info.escola_info.entities.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Escola_repository extends JpaRepository<Escola, UUID> {
}
