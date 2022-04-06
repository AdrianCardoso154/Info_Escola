package com.escola_info.escola_info.repository;

import com.escola_info.escola_info.entities.world.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Pais_repository extends JpaRepository<Pais, UUID> {
}
