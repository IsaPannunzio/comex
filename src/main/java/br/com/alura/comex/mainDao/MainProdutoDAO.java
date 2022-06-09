package br.com.alura.comex.mainDao;

import br.com.alura.comex.dao.CategoriaDAO;
import br.com.alura.comex.dao.ProdutoDAO;
import br.com.alura.comex.model.entities.Categoria;
import br.com.alura.comex.model.entities.Produto;
import br.com.alura.comex.model.enums.Status;
import br.com.alura.comex.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class MainProdutoDAO {

    public static void main(String[] args) {

        Categoria livros = new Categoria("LIVROS", Status.ATIVA);
        Produto produto1 = new Produto("Senhora", "Romance Nacional", new BigDecimal("49"), 3, livros);
        Produto produto2 = new Produto("Colecionador de lágrimas", "Romance Nacional", new BigDecimal("49"), 3, livros);
        Produto produto3 = new Produto("Memórias de um Sargento de Milícias", "Romance Nacional", new BigDecimal("49"), 0, livros);
        Produto produto4 = new Produto("O cortiço", "Romance Nacional", new BigDecimal("49"), 0, livros);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);


        em.getTransaction().begin();

        categoriaDAO.cadastrar(livros);
        produtoDAO.cadastrar(produto1);
        produtoDAO.cadastrar(produto2);
        produtoDAO.cadastrar(produto3);
        produtoDAO.cadastrar(produto4);

        List<Produto> todos = produtoDAO.listarTodos();
        todos.forEach(p -> System.out.println(p.getNome()));

        List<Produto> indisp = produtoDAO.listarIndisponiveis();
        indisp.forEach(p -> System.out.println(p.getNome()));

        em.getTransaction().commit();
        em.close();
    }
}
