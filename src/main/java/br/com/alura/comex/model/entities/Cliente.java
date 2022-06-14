package br.com.alura.comex.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String telefone;
    @NotEmpty
    private String rua;
    @NotEmpty
    private String numero;
    @NotEmpty
    private String complemento;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private String cidade;
    @NotEmpty
    private String estado;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> listaDePedidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void setListaDePedidos(List<Pedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

    public Cliente() {
    }
}
