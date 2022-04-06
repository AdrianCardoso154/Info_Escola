package com.escola_info.escola_info.service;

import com.escola_info.escola_info.entities.world.Cidade;
import com.escola_info.escola_info.entities.world.Estado;
import com.escola_info.escola_info.entities.world.Pais;
import com.escola_info.escola_info.repository.Pais_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Pais_service {
        final Pais_repository repository;
            public Pais_service(Pais_repository repository){
                this.repository = repository;
            }
            //SALVAR
            public Pais salvar(Pais pais){return repository.save(pais);}
            //SELECT ALL
            public List<Pais> findall(){return repository.findAll();}
            //SELECT BY ID
            public Pais findbyId(UUID id){
                Optional<Pais> paisOptional = repository.findById(id);
                return paisOptional.get();
            }
            //DELETAR
            public void deletar(Pais pais){
                repository.delete(pais);
            }

}
