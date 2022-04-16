package com.escola_info.escola_info.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass//mapeamento para super classes
public abstract class Pessoa {
    private String name;
    //Mudar para instante_date
    private String data_nsc;
    private String sexo;
    private String cpf;

    public Pessoa(String name, String data_nsc, String sexo, String cpf) {
        this.name = name;
        this.data_nsc = data_nsc;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    public Pessoa() {

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
