package com.escola_info.escola_info.resource;

import com.escola_info.escola_info.entities.Escola;
import com.escola_info.escola_info.service.Escola_service;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/escola")
public class Escola_controller {
    //INJEÇÃO DE DEPENCIA ESCOLA_SERVICE EM ESCOLA_CONTROLLER
    final Escola_service service;
        public Escola_controller(Escola_service escola_service){this.service = escola_service;}

    @PostMapping
    public ResponseEntity salvar(@RequestBody Escola escola){return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(escola));}

    @GetMapping
    public ResponseEntity findall(){return ResponseEntity.status(HttpStatus.OK).body(service.findall());}

    @GetMapping("/{id}")
    public ResponseEntity findbyId(@PathVariable(name = "id") UUID id){
        Escola escola = service.findbyId(id);
        return ResponseEntity.status(HttpStatus.OK).body(escola);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") UUID id){
            Escola escola = service.findbyId(id);
            service.delete(escola);
            return "DELETADO COM SUCESSO";
    }
    @PutMapping("/{id}")
        public ResponseEntity update(@PathVariable(name = "id")UUID id, @RequestBody Escola escola){
            Escola escola0 = service.findbyId(id);
            var escola1 = new Escola();

        BeanUtils.copyProperties(escola,escola1);
        escola1.setId(escola0.getId());

        return ResponseEntity.status(HttpStatus.OK).body(service.salvar(escola1)+"ATUALIZADO COM SUCESSO");

    }

}
