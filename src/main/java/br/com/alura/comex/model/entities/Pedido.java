package br.com.alura.comex.model.entities;

import br.com.alura.comex.model.enums.TipoDesconto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private String cliente;
    private BigDecimal preco;
    private int quantidade;
    @Enumerated(EnumType.STRING)
    private TipoDesconto tipoDesconto;
    private LocalDate data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoDesconto getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipoDesconto tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public Pedido(Long id, String cliente, BigDecimal preco, int quantidade, TipoDesconto tipoDesconto, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tipoDesconto = tipoDesconto;
        this.data = data;
    }

    public Pedido() {
    }

    public void setData(LocalDate data) {
        this.data = data;




    }
}
