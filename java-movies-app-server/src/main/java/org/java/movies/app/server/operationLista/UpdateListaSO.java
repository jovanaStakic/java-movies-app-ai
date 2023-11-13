/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationLista;

import java.sql.*;
import org.java.movies.app.common.domain.Film;
import org.java.movies.app.common.domain.Lista;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.java.movies.app.server.db.DBConnectionFactory;
import org.java.movies.app.server.operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class UpdateListaSO extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Lista))
            throw new Exception("Neispravan Lista objekat! ");
        Lista lista=(Lista) param;
        if(lista.getFilmovi().isEmpty())
            throw  new Exception("Lista nema filmova!");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Lista lista=(Lista) param;
        for (Film film : lista.getFilmovi()) {
            switch (film.getStatus()) {
                 case OBRISAN:
                    deleteFilmFromLF(lista, film);
                    break;
                case DODAT:
                    addFilmtToLF(lista, film);
                    break;
            }
        }
    }



private void deleteFilmFromLF(Lista lista, Film film) throws Exception {
    String query = "DELETE FROM LF WHERE listaID = " + lista.getId() + " AND filmID = " + film.getId();
    
    Connection connection=DBConnectionFactory.getInstance().getConnection();
    Statement statement=connection.createStatement();
    statement.executeUpdate(query);
}
private void addFilmtToLF(Lista lista, Film film){
        try {
            String query = "INSERT INTO LF (listaID, filmID) VALUES (?, ?)";
            Connection connection=DBConnectionFactory.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setLong(1, lista.getId());
            statement.setLong(2, film.getId());
            statement.execute();
        } catch (Exception ex) {
            Logger.getLogger(UpdateListaSO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }
    

