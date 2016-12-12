package com.absoft.db;

import com.absoft.util.BigDecimalConverter;
import com.mongodb.MongoClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author diego
 */
public class Conexao {

    //Novo Objeto Morphia
    final Morphia morphia = new Morphia();
    

    public Datastore ds() {
        morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
        
        
        Logger mongoLogger = Logger.getLogger("org.mongodb");
        mongoLogger.setLevel(Level.SEVERE); //Desabilita os logs

        // Cria a conexão com o MongoDB
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "absoft");
        //Indica o pacote onde ficarão as entidades
        morphia.mapPackage("com.absoft.model");
        datastore.ensureIndexes();

        return datastore;
    }

}
