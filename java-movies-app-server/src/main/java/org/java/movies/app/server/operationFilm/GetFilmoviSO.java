/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationFilm;

import org.java.movies.app.common.domain.Film;
import org.java.movies.app.common.domain.GenericEntity;
import org.java.movies.app.common.domain.Korisnik;
import java.util.List;
import org.java.movies.app.server.operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class GetFilmoviSO extends AbstractGenericOperation {

    List<GenericEntity> filmovi;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Film)) {
            throw new Exception("Neispravan film objekat!");
        }
        Film film = (Film) param;

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        filmovi = repository.getAll(param);
    }

    public List<GenericEntity> getMovies() {
        return filmovi;
    }
}
