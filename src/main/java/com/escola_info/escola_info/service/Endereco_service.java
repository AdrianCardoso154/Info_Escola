package com.escola_info.escola_info.service;

import com.escola_info.escola_info.entities.Endereco;
import com.escola_info.escola_info.entities.world.Cidade;
import com.escola_info.escola_info.repository.Endereco_repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Endereco_service {
        final Endereco_repository repository;
            public Endereco_service(Endereco_repository endereco_repository){
                this.repository = endereco_repository;
            }
            //SALVAR
            @Transactional
            public Endereco salvar(Endereco endereco){return repository.save(endereco);}
            //SELECT ALL
            public List<Endereco> findall(){return repository.findAll();}
            //SELECT BY ID
            public Endereco findbyId(UUID id){
                Optional<Endereco> enderecoOptional = repository.findById(id);
                return enderecoOptional.get();
            }
            //DELETAR
            public void delete(Endereco endereco){
                repository.delete(endereco);
            }
            /*
            //UPDATE
            public Endereco update(Endereco endereco){
                Endereco endereco1 = new Endereco();
                endereco1.setId(endereco.getId());
                endereco1.setRua(endereco.getRua());
                endereco1.setNumero(endereco.getNumero());
                endereco1.setBairro(endereco.getBairro());
                return repository.save(endereco1);

            }
             */

}
