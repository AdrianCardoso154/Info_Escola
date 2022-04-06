package com.escola_info.escola_info.repository;

import com.escola_info.escola_info.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EmbeddedId;
import java.util.UUID;

@Repository
public interface Endereco_repository extends JpaRepository<Endereco, UUID> {
}
