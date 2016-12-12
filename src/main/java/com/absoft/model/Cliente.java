package com.absoft.model;

import java.math.BigDecimal;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author diego
 */
@Entity(value = "clientes", noClassnameStored = true)
public class Cliente {

    @Id
    private ObjectId id;

    private String nome;

    private BigDecimal salario;

    public Cliente() {
    }

    
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
