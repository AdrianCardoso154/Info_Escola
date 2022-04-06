package com.escola_info.escola_info.resource;

import com.escola_info.escola_info.entities.world.Estado;
import com.escola_info.escola_info.entities.world.Pais;
import com.escola_info.escola_info.service.Escola_service;
import com.escola_info.escola_info.service.Estado_service;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Estado")
public class Estado_controller {
    final Estado_service service;
        public Estado_controller (Estado_service estado_service){
            this.service = estado_service;
        }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Estado estado){return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(estado));}

    @GetMapping
    public ResponseEntity findall(){return ResponseEntity .status(HttpStatus.OK).body(service.findall());}

    @GetMapping("/{id}")
    public ResponseEntity findbyId(@PathVariable(name = "id") UUID id){
        Estado estado = service.findbyId(id);
        return ResponseEntity.status(HttpStatus.OK).body(estado);
    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable(name = "id") UUID id){
        Estado estado = service.findbyId(id);
        service.deletar(estado);
        return "DELETADO COM SUCESSO";
    }
    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable(name = "id") UUID id, @RequestBody  Estado estado){
        Estado estado1 = service.findbyId(id);
        var estado02 = new Estado();
        BeanUtils.copyProperties(estado,estado02);
        estado02.setId(estado.getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.salvar(estado02)+"ATUALIZADO COM SUCESSO");
    }
}
