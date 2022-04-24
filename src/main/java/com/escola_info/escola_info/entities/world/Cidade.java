package com.escola_info.escola_info.entities.world;

import com.escola_info.escola_info.entities.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "tb_cidade")
@Entity
public class Cidade  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;

    public Cidade(){super();}

    public Cidade(String nome) {
        this.nome = nome;
    }
    //LIGAÇÃO MANY TO MANY COM ENDERECO
    @ManyToMany(mappedBy = "cidades")
    @JsonIgnore
    List<Endereco> enderecos = new ArrayList<>();

    //LIGAÇÃO MANY TO ONE COM ESTADO
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
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
        if (!(o instanceof Cidade)) return false;

        Cidade cidade = (Cidade) o;

        return getId() != null ? getId().equals(cidade.getId()) : cidade.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
