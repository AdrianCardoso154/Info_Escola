package com.escola_info.escola_info.config;

import com.escola_info.escola_info.entities.Aluno;
import com.escola_info.escola_info.entities.Endereco;
import com.escola_info.escola_info.entities.Escola;
import com.escola_info.escola_info.entities.Instrutor;
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
@Autowired
    private Aluno_repository aluno_repository;
@Autowired
    private Instrutor_repository instrutor_repository;

    @Override
    public void run(String... args) throws Exception {
        //PAIS
        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais_repository.save(pais);
        //Estado
        Estado estado = new Estado();
        estado.setNome("Goias");
        estado.setDdd(62);
        estado.setPais(pais);
        estado_repository.save(estado);
        //INTERAÇÃO PAIS
        pais.getEstados().add(estado);
        pais_repository.save(pais);
        //CIDADE
        Cidade cidade = new Cidade();
        cidade.setNome("Carmo do rio verde");
        cidade.setEstado(estado);
        cidade_repository.save(cidade);


        //ENDERECO ESCOLA
        Endereco endereco2 = new Endereco();
        endereco2.setBairro("pamonha");
        endereco2.setNumero("15");
        endereco2.setRua("aparecida");
        endereco2.setBairro("caiado");
        //interaçoes
        endereco2.getCidades().add(cidade);
        cidade.getEnderecos().add(endereco2);
        cidade_repository.save(cidade);
        endereco_repository.save(endereco2);
        //ESCOLA
        Escola escola = new Escola();
        escola.setNome_escola("joão marinho");
        escola.setCnpj("75454484848");
        escola.setEmail("escola@gmial.com");
        escola.setTelefone("62998449857");
        escola.setWhats("62998449857");
        escola.setEndereco(endereco2);
        escola_repository.save(escola);
        //ENDERECO INSTRUTOR
        Endereco endereco = new Endereco();
        endereco.setBairro("algodão");
        endereco.setNumero("75");
        endereco.setRua("Maranhorsa");
        endereco.setBairro("Almoço");
        //interaçoes
        endereco.getCidades().add(cidade);
        cidade.getEnderecos().add(endereco);
        cidade_repository.save(cidade);
        endereco_repository.save(endereco);
        //INSTRUTOR
        Instrutor instrutor = new Instrutor();
        instrutor.setCpf("4515545454");
        instrutor.setEndereco(endereco);
        instrutor.setData_nsc("21/11/2000");
        instrutor.setName("rodrigo");
        instrutor.setSexo("M");
        instrutor_repository.save(instrutor);
        //ENDERECO ALUNO
        Endereco endereco1 = new Endereco();
        endereco1.setBairro("Maça");
        endereco1.setNumero("76");
        endereco1.setRua("Maranhorsa");
        endereco1.setBairro("gertrudes");
        //interaçoes
        endereco1.getCidades().add(cidade);
        cidade.getEnderecos().add(endereco1);
        cidade_repository.save(cidade);
        endereco_repository.save(endereco1);
        //ALUNO
        Aluno aluno = new Aluno();
        aluno.setEscola(escola);
        aluno.setCpf("454554454");
        aluno.setEndereco(endereco1);
        aluno.setName("adrian");
        aluno.setData_nsc("12/05/93");
        aluno.setSexo("M");
        aluno_repository.save(aluno);
        //INTERAÇÃO ESCOLA INSTRUTOR
        instrutor.getEscolas().add(escola);
        escola.getInstrutors().add(instrutor);
        escola_repository.save(escola);
        instrutor_repository.save(instrutor);






    }
}
