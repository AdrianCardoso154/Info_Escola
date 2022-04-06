package com.escola_info.escola_info.resource;

import com.escola_info.escola_info.entities.Escola;
import com.escola_info.escola_info.entities.world.Pais;
import com.escola_info.escola_info.service.Pais_service;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(name = "/Pais")
public class Pais_controller {
    //INJEÇÃO DE DEPENDENCIA PAIS_SERVICE EM PAIS_CONTROLLER
    final Pais_service service;
        public Pais_controller (Pais_service pais_service){
            this.service = pais_service;
        }
        @PostMapping
        public ResponseEntity salvar(@RequestBody Pais pais){return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(pais));}

        @GetMapping
        public ResponseEntity findall(){return ResponseEntity .status(HttpStatus.OK).body(service.findall());}

        @GetMapping("/{id}")
        public ResponseEntity findbyId(@PathVariable(name = "id")UUID id){
            Pais pais = service.findbyId(id);
                return ResponseEntity.status(HttpStatus.OK).body(pais);
        }
        @DeleteMapping("/{id}")
       public String deletar(@PathVariable(name = "id") UUID id){
            Pais pais = service.findbyId(id);
            service.deletar(pais);
            return "DELETADO COM SUCESSO";
        }
        @PutMapping("/{id}")
        public ResponseEntity update (@PathVariable(name = "id") UUID id, @RequestBody Pais pais){
            Pais pais1 = service.findbyId(id);
            var pais02 = new Pais();
            BeanUtils.copyProperties(pais,pais02);
            pais02.setId(pais1.getId());
            return ResponseEntity.status(HttpStatus.OK).body(service.salvar(pais02)+"ATUALIZADO COM SUCESSO");
        }

}
