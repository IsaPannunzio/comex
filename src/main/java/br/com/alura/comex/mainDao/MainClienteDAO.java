package br.com.alura.comex.mainDao;

import br.com.alura.comex.dao.ClienteDAO;
import br.com.alura.comex.model.entities.Cliente;
import br.com.alura.comex.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MainClienteDAO {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Isabella", "39391251803", "19991610810", "Rua Um", "10", " ", "Bairro Um", "Mogi Mirim", "SP");
        Cliente cliente2 = new Cliente("Camila", "38475432145", "13992345612", "Rua Dois", "12", "Complemento 1", "Bairro Um", "Mogi Mirim", "SP");
        Cliente cliente3 = new Cliente("Vitor", "39543256745", "19945641212", "Rua Três", "14", "Complemento 2", "Bairro Um", "Mogi Mirim", "SP");
        EntityManager em = JPAUtil.getEntityManager();

        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();

        clienteDAO.cadastrar(cliente1);
        clienteDAO.cadastrar(cliente2);
        clienteDAO.cadastrar(cliente3);

        List<Cliente> buscaPorNome = clienteDAO.listarPorNome("Isabella");
        buscaPorNome.forEach(p -> System.out.println(p.getNome()));

        em.getTransaction().commit();
        em.close();
    }
}
