package com.escola_info.escola_info.entities.world;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_pais")
public class Pais implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;

    public Pais(){super();}
    public Pais(String name){this.nome = name;}

    //LIGAÇÃO MANY TO ONE COM ESTADO
    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    List<Estado>estados=new ArrayList<>();
    public List<Estado> getEstados() {
        return estados;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;

        Pais pais = (Pais) o;

        return getId() != null ? getId().equals(pais.getId()) : pais.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
