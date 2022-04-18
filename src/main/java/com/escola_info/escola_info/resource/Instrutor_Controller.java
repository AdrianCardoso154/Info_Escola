package com.escola_info.escola_info.resource;

import com.escola_info.escola_info.entities.Instrutor;
import com.escola_info.escola_info.entities.world.Estado;
import com.escola_info.escola_info.service.Instrutor_sevice;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Instrutor")
public class Instrutor_Controller {

        final Instrutor_sevice service;
            public Instrutor_Controller(Instrutor_sevice instrutor_sevice){
                this.service = instrutor_sevice;
            }

                @PostMapping
                public ResponseEntity salvar(@RequestBody Instrutor instrutor){return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(instrutor));}

                @GetMapping
                public ResponseEntity findall(){return ResponseEntity .status(HttpStatus.OK).body(service.findall());}

                @GetMapping("/{id}")
                public ResponseEntity findbyId(@PathVariable(name = "id") UUID id){
                    Instrutor instrutor = service.findbyId(id);
                    return ResponseEntity.status(HttpStatus.OK).body(instrutor);
                }
                @DeleteMapping("/{id}")
                public String deletar(@PathVariable(name = "id") UUID id){
                    Instrutor instrutor = service.findbyId(id);
                    service.deletar(instrutor);
                    return "DELETADO COM SUCESSO";
                }
                @PutMapping("/{id}")
                public ResponseEntity update (@PathVariable(name = "id") UUID id, @RequestBody  Instrutor instrutor){
                    Instrutor instrutor1 = service.findbyId(id);
                    var instrutor2 = new Instrutor();
                    BeanUtils.copyProperties(instrutor,instrutor2);
                    instrutor2.setId(instrutor1.getId());
                    return ResponseEntity.status(HttpStatus.OK).body(service.salvar(instrutor2)+"ATUALIZADO COM SUCESSO");
                }
}
