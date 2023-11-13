/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationLista;

import org.java.movies.app.common.domain.GenericEntity;
import org.java.movies.app.common.domain.Lista;
import java.util.List;
import org.java.movies.app.server.operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class GetListeSO extends AbstractGenericOperation{
        List<GenericEntity> liste;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Lista)) {
            throw new Exception("Neispravan recenzija objekat!");
        }
        Lista lista=(Lista) param;
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        liste=repository.getAll(param);
    }
    
    public List<GenericEntity> getListe(){
        return liste;
    }
    
}
