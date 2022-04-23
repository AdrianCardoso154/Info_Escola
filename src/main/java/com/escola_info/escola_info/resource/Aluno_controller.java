package com.escola_info.escola_info.resource;

import com.escola_info.escola_info.entities.Escola;
import com.escola_info.escola_info.entities.world.Aluno;
import com.escola_info.escola_info.service.Aluno_service;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Aluno")
public class Aluno_controller {
    final Aluno_service service;
        public Aluno_controller(Aluno_service aluno_service){
            this.service = aluno_service;
        }
            @PostMapping
            public ResponseEntity salvar(@RequestBody Aluno aluno){return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(aluno));}

            @GetMapping
            public ResponseEntity findall(){return ResponseEntity.status(HttpStatus.OK).body(service.findall());}

            @GetMapping("/{id}")
            public ResponseEntity findbyId(@PathVariable(name = "id") UUID id){
                Aluno aluno = service.findbyId(id);
                return ResponseEntity.status(HttpStatus.OK).body(aluno);
            }
            @DeleteMapping("/{id}")
            public String delete(@PathVariable(name = "id") UUID id){
                Aluno aluno = service.findbyId(id);
                service.deletar(aluno);
                return "DELETADO COM SUCESSO";
            }
            @PutMapping("/{id}")
            public ResponseEntity update(@PathVariable(name = "id")UUID id, @RequestBody Aluno aluno){
                Aluno aluno0 = service.findbyId(id);
                var aluno1 = new Aluno();

                BeanUtils.copyProperties(aluno,aluno1);
                aluno1.setId(aluno0.getId());

                return ResponseEntity.status(HttpStatus.OK).body(service.salvar(aluno1)+"ATUALIZADO COM SUCESSO");

            }
}
