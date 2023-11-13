/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationLista;

import java.sql.*;
import org.java.movies.app.common.domain.Lista;
import org.java.movies.app.server.db.DBConnectionFactory;
import org.java.movies.app.server.operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class DeleteListaSO extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Lista)) {
            throw new Exception("Neispravan recenzija objekat!");
        }
        Lista lista=(Lista) param;
        if(lista.getId()<0)
            throw new Exception("Neispravan id liste koja se brise!");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Lista lista=(Lista) param;
        deleteRelatedEntities(lista);
        repository.delete(param);
    }
    public void deleteRelatedEntities(Lista lista) throws Exception {
        Connection connection=DBConnectionFactory.getInstance().getConnection();
        String query = "DELETE FROM lf WHERE ListaID ="+lista.getId();
        Statement statement=connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        }
}
