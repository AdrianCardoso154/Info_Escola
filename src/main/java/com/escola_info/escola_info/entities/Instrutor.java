package com.escola_info.escola_info.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_instrutor")
public class Instrutor extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Instrutor() {
        super();
    }

    public Instrutor(String name, String data_nsc, String sexo, String cpf, UUID id) {
        super(name, data_nsc, sexo, cpf);
        this.id = id;
    }


    //LIGAÇÃO MANY TO MANY COM ESCOLA
    @ManyToMany
    @JoinTable(name = "tb_instrutor_escola",joinColumns = @JoinColumn(name = "id_instrutor"), inverseJoinColumns = @JoinColumn(name = "id_esc"))
    List<Escola> escolas = new ArrayList<>();

    public List<Escola> getEscolas(){
        return escolas;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instrutor)) return false;

        Instrutor instrutor = (Instrutor) o;

        return getId() != null ? getId().equals(instrutor.getId()) : instrutor.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
