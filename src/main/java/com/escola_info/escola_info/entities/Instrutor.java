package com.escola_info.escola_info.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_instrutor")
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    //Mudar para instante_date
    private String data_nsc;
    private String sexo;

    public Instrutor(){super();}

    public Instrutor(String name, String data_nsc, String sexo) {
        this.name = name;
        this.data_nsc = data_nsc;
        this.sexo = sexo;
    }
    //LIGAÇÃO MANY TO MANY COM ESCOLA
    @ManyToMany
    @JoinTable(name = "tb_instrutor_end",joinColumns = @JoinColumn(name = "id_instrutor"), inverseJoinColumns = @JoinColumn(name = "id_end"))
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData_nsc() {
        return data_nsc;
    }

    public void setData_nsc(String data_nsc) {
        this.data_nsc = data_nsc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
