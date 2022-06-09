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
    private BigDecimal precoUnitario;
    private Long quantidade;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    private BigDecimal desconto;
    @Enumerated(EnumType.STRING)
    private TipoDesconto tipoDesconto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
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
    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public TipoDesconto getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipoDesconto tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public ItemDePedido(BigDecimal precoUnitario, long quantidade, Produto produto, Pedido pedido, TipoDesconto tipoDesconto, BigDecimal desconto) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
        this.tipoDesconto = tipoDesconto;
        this.desconto = desconto;
    }

    public ItemDePedido() {
    }
}
