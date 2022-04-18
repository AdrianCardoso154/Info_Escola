package com.escola_info.escola_info.service;

import com.escola_info.escola_info.entities.Instrutor;
import com.escola_info.escola_info.repository.Instrutor_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Instrutor_sevice {
    final Instrutor_repository repository;
        public Instrutor_sevice(Instrutor_repository instrutor_repository){
            this.repository = instrutor_repository;
        }

    //SALVAR
    public Instrutor salvar(Instrutor instrutor){
        return this.repository.save(instrutor);
    }
    //SELECT ALL
    public List<Instrutor> findall(){return repository.findAll();}
    //SELECT BY ID
    public Instrutor findbyId(UUID id){
        Optional<Instrutor> instrutorOptional = repository.findById(id);
        return instrutorOptional.get();
    }
    //DELETAR
    public void deletar(Instrutor instrutor){
        repository.delete(instrutor);
    }
}
