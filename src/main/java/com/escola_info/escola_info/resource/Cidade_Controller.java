package com.escola_info.escola_info.resource;

import com.escola_info.escola_info.entities.world.Cidade;
import com.escola_info.escola_info.entities.world.Estado;
import com.escola_info.escola_info.service.Cidade_service;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Cidade")
public class Cidade_Controller {
        final Cidade_service service;
            public Cidade_Controller(Cidade_service cidade_service){
                this.service = cidade_service;
            }
    @PostMapping
    public ResponseEntity salvar(@RequestBody Cidade cidade){return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(cidade));}

    @GetMapping
    public ResponseEntity findall(){return ResponseEntity .status(HttpStatus.OK).body(service.findall());}

    @GetMapping("/{id}")
    public ResponseEntity findbyId(@PathVariable(name = "id") UUID id){
        Cidade cidade = service.findbyId(id);
        return ResponseEntity.status(HttpStatus.OK).body(cidade);
    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable(name = "id") UUID id){
        Cidade cidade = service.findbyId(id);
        service.deletar(cidade);
        return "DELETADO COM SUCESSO";
    }
    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable(name = "id") UUID id, @RequestBody  Cidade cidade){
        Cidade cidade1 = service.findbyId(id);
        var cidade02 = new Cidade();
        BeanUtils.copyProperties(cidade,cidade02);
        cidade02.setId(cidade.getId());
        return ResponseEntity.status(HttpStatus.OK).body(service.salvar(cidade02)+"ATUALIZADO COM SUCESSO");
    }
}
