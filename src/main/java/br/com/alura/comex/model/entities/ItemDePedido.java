package br.com.alura.comex.model.entities;


import br.com.alura.comex.model.enums.TipoDesconto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itensDePedidos")
public class ItemDePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal precoUnitario = BigDecimal.ZERO;
    private int quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    private BigDecimal desconto;
    private TipoDesconto tipoDesconto;

    public ItemDePedido(int quantidade, Produto produto, Pedido pedido, BigDecimal desconto, TipoDesconto tipoDeDesconto) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = produto.getPrecoUnitario();
        this.desconto = desconto;
        this.tipoDesconto = tipoDesconto;
    }

    public ItemDePedido() {

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoDesconto getTipoDeDesconto() {
        return tipoDesconto;
    }

    public void setTipoDeDesconto(TipoDesconto tipoDeDesconto) {
        this.tipoDesconto= tipoDeDesconto;
    }

    public BigDecimal getValor() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }
}
