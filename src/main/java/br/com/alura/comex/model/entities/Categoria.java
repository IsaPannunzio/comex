package br.com.alura.comex.model.entities;

import br.com.alura.comex.model.enums.Status;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Categoria(int id, String nome, Status status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Categoria() {
    }
}
