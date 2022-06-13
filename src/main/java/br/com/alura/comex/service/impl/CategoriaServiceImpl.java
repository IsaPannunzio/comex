package br.com.alura.comex.service.impl;

import br.com.alura.comex.model.entities.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarTodos() {

        return categoriaRepository.findAll();
    }

    @Override
    public Categoria listarPorCodigo(Long id) {

        return categoriaRepository.findById(id).get();
    }

    @Override
    public Categoria inserir(Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {

        return this.categoriaRepository.save(categoria);
    }

    @Override
    public void remover(Long id) {

        this.categoriaRepository.deleteById(id);
    }

}
