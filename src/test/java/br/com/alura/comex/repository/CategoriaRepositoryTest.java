package br.com.alura.comex.repository;

import br.com.alura.comex.model.entities.Categoria;
import br.com.alura.comex.model.entities.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CategoriaRepositoryTest {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private  ProdutoRepository produtoRepository;

//  @Autowired
//  private TestEntityManager testEntityManager;

  @Test
  public void deveRetornarUmaCategoria(){

    List<Categoria> categorias = categoriaRepository.findAll();
    assertNotNull(categorias);

  }

  @Test
  public void deveCadastrarDuasCategorias(){

    List<Categoria> categorias = List.of(
            new Categoria("JOGOS"),
            new Categoria("LIVROS")
    );

    List<Produto> produtos = List.of(
            new Produto("Skyrim",
                    "Quinto jogo da saga The Elder Scrolls",
                    new BigDecimal("160"),
                    100,
                    categorias.get(0)),
            new Produto("Lago Sem Nome",
                    "Autobiografia",
                    new BigDecimal("50"),
                    50,
                    categorias.get(1))
    );

    categoriaRepository.saveAll(categorias);
    List<Categoria> categoriaList = categoriaRepository.findAll();


    produtoRepository.saveAll(produtos);
    List<Produto> produtoList = produtoRepository.findAll();


    assertNotNull(categoriaList);
    assertNotNull(produtoList);
  }
}