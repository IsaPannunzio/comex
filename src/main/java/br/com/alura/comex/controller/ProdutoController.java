package br.com.alura.comex.controller;

import br.com.alura.comex.model.entities.Produto;
import br.com.alura.comex.repository.ProdutoRepository;
import br.com.alura.comex.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produto")
@Api(value = "API REST Produto")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Lista todos os produtos")
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto> lista = produtoService.listarTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista o produto com ID correspondente")
    public ResponseEntity<Produto> listarPorCodigo(@PathVariable Long id) {
        Produto produto = produtoService.listarPorCodigo(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);

    }

    @PostMapping("/cadastro")
    @Operation(summary = "Insere um produto no banco de dados")
    public ResponseEntity<Produto> inserir(@RequestBody @Valid Produto produto) {
        produtoService.inserir(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza o produto com ID correspondente")
    public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long id, @RequestBody Produto produto) {
        boolean produtoeExiste = this.produtoRepository.existsById(produto.getId());

        if (!produtoeExiste) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        produto.setId(id);
        produto = produtoService.atualizar(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Remove o produto com ID correspondente")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        if (!produtoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        produtoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
