package com.escola_info.escola_info.service;

import com.escola_info.escola_info.entities.world.Cidade;
import com.escola_info.escola_info.entities.world.Estado;
import com.escola_info.escola_info.repository.Estado_repository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Estado_service {
    final Estado_repository repository;
            public Estado_service(Estado_repository estado_repository){
                this.repository = estado_repository;
            }
            //SALVAR
            public Estado salvar(Estado estado){
                return this.repository.save(estado);
            }
            //SELECT ALL
            public List<Estado> findall(){return repository.findAll();}
            //SELECT BY ID
            public Estado findbyId(UUID id){
                Optional<Estado> estadoOptional = repository.findById(id);
                return estadoOptional.get();
            }
            //DELETAR
            public void deletar(Estado estado){
                repository.delete(estado);
            }
}
