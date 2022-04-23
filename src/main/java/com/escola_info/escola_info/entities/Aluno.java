package com.escola_info.escola_info.entities;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Aluno(){super();}

    public Aluno(String name, String data_nsc, String sexo, String cpf) {
        super(name, data_nsc, sexo, cpf);
    }

    //LIGAÇÃO MANY TO ONE COM ESCOLA
    @ManyToOne
    @JoinColumn(name = "id_escola")
    private Escola escola;

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
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
        if (!(o instanceof Aluno)) return false;

        Aluno aluno = (Aluno) o;

        return getId() != null ? getId().equals(aluno.getId()) : aluno.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
