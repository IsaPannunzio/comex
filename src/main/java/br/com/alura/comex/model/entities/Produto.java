package br.com.alura.comex.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private Long quantidadeEmEstoque;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public long getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(long quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setQuantidadeEmEstoque(Long quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto(int id, String nome, String descricao, BigDecimal precoUnitario, Long quantidadeEmEstoque, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    public Produto() {
    }
}

