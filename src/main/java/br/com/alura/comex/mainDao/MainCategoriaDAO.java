package br.com.alura.comex.mainDao;

import br.com.alura.comex.dao.CategoriaDAO;
import br.com.alura.comex.model.entities.Categoria;
import br.com.alura.comex.model.enums.Status;
import br.com.alura.comex.utils.JPAUtil;

import javax.persistence.EntityManager;

public class MainCategoriaDAO {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Categoria categoria1 = new Categoria("INFORMÁTICA", Status.ATIVA);
        Categoria categoria2 = new Categoria("LIVROS", Status.ATIVA);
        Categoria categoria3 = new Categoria("JOGOS", Status.ATIVA);

        CategoriaDAO categoriaDao = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(categoria1);
        categoriaDao.cadastrar(categoria2);
        categoriaDao.cadastrar(categoria3);
        em.getTransaction().commit();

        categoria1.setNome("VESTUÁRIO");
        categoriaDao.atualizar(categoria1);

        categoria1.setStatus(Status.INATIVA);
        categoriaDao.atualizar(categoria1);

        em.close();
    }
}
