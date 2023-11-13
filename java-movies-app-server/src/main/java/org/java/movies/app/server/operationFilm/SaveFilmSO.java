/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.operationFilm;
import org.java.movies.app.common.domain.Film;
import org.java.movies.app.server.operation.AbstractGenericOperation;
/**
 *
 * @author Administrator
 */
public class SaveFilmSO extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
         if (!(param instanceof Film)) {
            throw new Exception("Neispravan film objekat!");
        }
        Film film = (Film) param;
        if(film.getKorisnik()==null)
            throw new Exception("Korisnik nije autentifikovan!");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add(param);
        //Sve moze da se pise
    }
    
}
