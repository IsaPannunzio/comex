package br.com.alura.comex.service.impl;

import br.com.alura.comex.model.entities.Cliente;
import br.com.alura.comex.repository.ClienteRepository;
import br.com.alura.comex.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {

        return clienteRepository.findAll();
    }

    @Override
    public Cliente listarPorCodigo(Long id) {

        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente inserir(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {

        return this.clienteRepository.save(cliente);
    }

    @Override
    public void remover(Long id) {

        this.clienteRepository.deleteById(id);
    }
}
