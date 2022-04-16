package com.escola_info.escola_info.entities;

import com.escola_info.escola_info.entities.world.Cidade;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String bairro;
    private String numero;
    private String rua;

    public Endereco(){super();}

    public Endereco(String bairro, String numero, String rua) {
        this.bairro = bairro;
        this.numero = numero;
        this.rua = rua;
    }
    //LIGAÇÃO MANY TO MANY COM CIDADE
    @ManyToMany
    @JoinTable(name = "tb_city_end", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "city_id"))
    List<Cidade> cidades = new ArrayList<>();

    public List<Cidade> getCidades() {
        return cidades;
    }

    //LIGAÇÃO ONE TO MANY ENDERECO PARA ESCOLA
    @OneToMany(mappedBy = "endereco")
    @JsonIgnore
    List<Escola> escolas = new ArrayList<>();

    public List<Escola> getEscolas() {
        return escolas;
    }

    //LIGAÇÃO ONE TO ONE COM END
    @OneToOne(mappedBy = "endereco")
    private Instrutor instrutor;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;

        Endereco endereco = (Endereco) o;

        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
