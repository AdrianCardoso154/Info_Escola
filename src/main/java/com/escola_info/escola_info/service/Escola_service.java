package com.escola_info.escola_info.service;

import com.escola_info.escola_info.entities.Escola;
import com.escola_info.escola_info.entities.world.Cidade;
import com.escola_info.escola_info.repository.Escola_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Escola_service {
    final Escola_repository repository;
        public Escola_service (Escola_repository escola_repository){
            this.repository = escola_repository;
        }

        //SALVAR
        public Escola salvar(Escola escola){
            return repository.save(escola);
        }
        //SELECT ALL
        public List<Escola> findall(){return repository.findAll();}
        //SELECT POR ID
        public Escola findbyId(UUID id){
            Optional<Escola> escolaOptional = repository.findById(id);
            return escolaOptional.get();
            }
        //DELETAR
        public void delete(Escola escola){
            repository.delete(escola);
        }
}
