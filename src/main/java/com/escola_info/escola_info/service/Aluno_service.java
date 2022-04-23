package com.escola_info.escola_info.service;

import com.escola_info.escola_info.entities.Aluno;
import com.escola_info.escola_info.repository.Aluno_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Aluno_service {
    final Aluno_repository repository;
        public Aluno_service(Aluno_repository aluno_repository){
            this.repository = aluno_repository;
        }
            //SALVAR
            public Aluno salvar(Aluno aluno){
                return this.repository.save(aluno);
            }
            //SELECT ALL
            public List<Aluno> findall(){return repository.findAll();}
            //SELECT BY ID
            public Aluno findbyId(UUID id){
                Optional<Aluno> alunoOptional = repository.findById(id);
                return alunoOptional.get();
            }
            //DELETAR
            public void deletar(Aluno aluno){
        repository.delete(aluno);
    }
}
