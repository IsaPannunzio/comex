package br.com.alura.comex.service.impl;

import br.com.alura.comex.model.entities.Produto;
import br.com.alura.comex.repository.ProdutoRepository;
import br.com.alura.comex.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarTodos() {

        return produtoRepository.findAll();
    }

    @Override
    public Produto listarPorCodigo(Long id) {

        return produtoRepository.findById(id).get();
    }

    @Override
    public Produto inserir(Produto produto) {

        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizar(Produto produto) {

        return this.produtoRepository.save(produto);
    }

    @Override
    public void remover(Long id) {

        this.produtoRepository.deleteById(id);
    }
}
