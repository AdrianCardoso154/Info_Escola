package com.escola_info.escola_info.entities.world;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private Integer ddd;

    public Estado(){super();}

    public Estado(String nome, Integer ddd) {
        this.nome = nome;
        this.ddd = ddd;
    }
    //LIGAÇÃO MANY TO ONE COM PAIS
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
    public Pais getPais(){
        return pais;
    }
    //LIGAÇÃO MANY TO ONE COM CIDADE
    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    List<Cidade> cidades = new ArrayList<>();

    public List<Cidade> getCidades() {
        return cidades;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;

        Estado estado = (Estado) o;

        return getId() != null ? getId().equals(estado.getId()) : estado.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
