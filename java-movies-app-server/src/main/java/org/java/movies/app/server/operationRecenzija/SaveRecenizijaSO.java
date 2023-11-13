/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationRecenzija;
import org.java.movies.app.server.dbrepository.Repository;
import org.java.movies.app.common.domain.Korisnik;
import org.java.movies.app.common.domain.Recenzija;
import org.java.movies.app.server.operation.AbstractGenericOperation;
/**
 *
 * @author Administrator
 */
public class SaveRecenizijaSO extends AbstractGenericOperation{
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Recenzija))
            throw new Exception("Neispravan objekat Recenzije!");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add(param);
    }
    
}
