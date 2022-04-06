package com.escola_info.escola_info.config;

import com.escola_info.escola_info.entities.Endereco;
import com.escola_info.escola_info.entities.Escola;
import com.escola_info.escola_info.entities.world.Cidade;
import com.escola_info.escola_info.entities.world.Estado;
import com.escola_info.escola_info.entities.world.Pais;
import com.escola_info.escola_info.repository.*;
import com.escola_info.escola_info.service.Endereco_service;
import com.escola_info.escola_info.service.Escola_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner{
@Autowired
    private Escola_repository escola_repository;
@Autowired
    private Endereco_repository endereco_repository;
@Autowired
    private Cidade_repository cidade_repository;
@Autowired
    private Estado_repository estado_repository;
@Autowired
    private Pais_repository pais_repository;

    @Override
    public void run(String... args) throws Exception {
        //ESCOLA
        Escola escola = new Escola();
        escola.setNome_escola("joão marinho");
        escola.setCnpj("75454484848");
        escola.setEmail("escola@gmial.com");
        escola.setTelefone("62998449857");
        escola.setWhats("62998449857");
        escola_repository.save(escola);
        //ENDERECO
        Endereco endereco = new Endereco();
        endereco.setBairro("algodão");
        endereco.setNumero("75");
        endereco.setRua("Maranhorsa");
        endereco_repository.save(endereco);
        //CIDADE
        Cidade cidade = new Cidade();
        cidade.setNome("Carmo do rio verde");
        cidade_repository.save(cidade);
        //Estado
        Estado estado = new Estado();
        estado.setNome("Goias");
        estado.setDdd(62);
        estado_repository.save(estado);
        //PAIS
        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais_repository.save(pais);
        //INTERAÇOES
        pais.getEstados().add(estado);
        pais_repository.save(pais);

        estado.getCidades().add(cidade);
        estado_repository.save(estado);

        cidade.getEnderecos().add(endereco);
        cidade_repository.save(cidade);




    }
}
