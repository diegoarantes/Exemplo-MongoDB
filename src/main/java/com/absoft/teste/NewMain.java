package com.absoft.teste;

import com.absoft.db.Conexao;
import com.absoft.model.Cliente;
import com.absoft.model.Endereco;
import com.absoft.model.Pessoa;
import java.math.BigDecimal;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author diego
 */
public class NewMain {

    public static void main(String[] args) {
        Datastore ds = new Conexao().ds();

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Lays Arantes");
        pessoa.setCpf("666.666.666-66");
        pessoa.setIdade(23);
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Hélio de Freitas");
        endereco.setNumero("2345");

        Cliente cliente = new Cliente();

        cliente.setNome("Zézinho louco da silva");
        cliente.setSalario(new BigDecimal("2035.46"));
        ds.save(cliente);
        pessoa.setEndereco(endereco);
        pessoa.setCliente(cliente);
        
        ds.save(pessoa);

        Query<Pessoa> qr = ds.find(Pessoa.class);
        List<Pessoa> pessoas = qr.asList();
        pessoas.forEach((p) -> { 

            System.out.println(p.getNome() + " " + p.getCpf());

            System.out.println("Nome do Cliente: " + p.getCliente().getNome());
            System.out.println("Salário do Cliente: "+p.getCliente().getSalario());
            ds.delete(p.getCliente());
        });
    }

}
