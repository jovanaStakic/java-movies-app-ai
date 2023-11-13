/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationKorisnik;

import org.java.movies.app.common.domain.GenericEntity;
import org.java.movies.app.common.domain.Korisnik;
import java.util.List;
import org.java.movies.app.server.operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class GetKorisniciSO extends AbstractGenericOperation{

    List<GenericEntity> korisnici;
    @Override
    protected void preconditions(Object param) throws Exception {
           if (!(param instanceof Korisnik)) {
            throw new Exception("Neispravan korisnik objekat!");
        }
        Korisnik korisnik=(Korisnik) param;

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        korisnici=repository.getAll(param);
    }
      public List<GenericEntity> getKorisnici() {
        return korisnici;
    }
}
