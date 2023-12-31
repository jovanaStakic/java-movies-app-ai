/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationLista;

import org.java.movies.app.common.domain.Lista;
import org.java.movies.app.server.operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class SaveListaSO extends AbstractGenericOperation{

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
        repository.add(param);
    }
    
}
