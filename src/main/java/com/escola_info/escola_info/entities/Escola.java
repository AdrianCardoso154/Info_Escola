package com.escola_info.escola_info.entities;

import com.escola_info.escola_info.entities.world.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_escola")
public class Escola implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,name = "nome_escola")
    @NotNull()
    private String nome_escola;

    @Column(nullable = false,name = "cnpj")
    @NotNull()
    private String cnpj;

    @Column(nullable = false,name = "email")
    @NotNull()
    private String email;

    @Column(nullable = false,name = "telefone")
    @NotNull()
    private String telefone;

    @Column(name = "whats")
    @NotNull()
    private String whats;

    public Escola() {
        super();
    }

    public Escola(String nome_escola, String cnpj, String email, String telefone, String whats) {
        this.nome_escola = nome_escola;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.whats = whats;
    }

    //LIGAÇÃO MANY TO ONE ESCOLA E ENDERECO
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Endereco getEndereco(){
        return endereco;
    }
    //LIGAÇÃO MANY TO MANY COM INSTRUTOR
    @ManyToMany(mappedBy = "escolas")
    @JsonIgnore
    List<Instrutor> instrutors = new ArrayList<>();

    public List<Instrutor> getInstrutors() {
        return instrutors;
    }
    //LIGAÇÃO MANY TO ONE COM ALUNO
        @OneToMany(mappedBy = "escola")
        private List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome_escola() {
        return nome_escola;
    }

    public void setNome_escola(String nome_escola) {
        this.nome_escola = nome_escola;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhats() {
        return whats;
    }

    public void setWhats(String whats) {
        this.whats = whats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Escola)) return false;

        Escola escola = (Escola) o;

        return getId() != null ? getId().equals(escola.getId()) : escola.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
