package com.escola_info.escola_info.service;

import com.escola_info.escola_info.entities.world.Cidade;
import com.escola_info.escola_info.repository.Cidade_repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Cidade_service {
        final Cidade_repository repository;
            public Cidade_service(Cidade_repository cidade_repository){
                this.repository = cidade_repository;
            }

            //SALVAR
            @Transactional
            public Cidade salvar(Cidade cidade){
                return repository.save(cidade);
            }
            //SELECT ALL
            public List<Cidade> findall(){return repository.findAll();}
            //SELECT BY ID
            public Cidade findbyId(UUID id){
                Optional<Cidade> cidadeOptional = repository.findById(id);
                return cidadeOptional.get();
            }
            //DELETAR
            public void deletar(Cidade cidade){
                repository.delete(cidade);
            }
            /*
            //UPDATE
            public Cidade update(Cidade cidade){
                    Cidade cidade1 = new Cidade();
                    cidade1.setId(cidade.getId());
                    cidade1.setNome(cidade.getNome());
                    return repository.save(cidade1);

            }
             */


}
