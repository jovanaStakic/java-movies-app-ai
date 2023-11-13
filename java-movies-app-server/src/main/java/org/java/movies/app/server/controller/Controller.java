/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.controller;

import org.java.movies.app.common.domain.*;
import java.util.List;
import org.java.movies.app.server.operation.AbstractGenericOperation;
import org.java.movies.app.server.operationLista.DeleteListaSO;
import org.java.movies.app.server.operationRecenzija.DeleteRecenzijaSO;
import org.java.movies.app.server.operationLista.FindListaSO;
import org.java.movies.app.server.operationFilm.FindFilmoviSO;
import org.java.movies.app.server.operationFilm.GetGlumciSO;
import org.java.movies.app.server.operationLista.GetListeSO;
import org.java.movies.app.server.operationFilm.GetFilmoviSO;
import org.java.movies.app.server.operationRecenzija.GetRecenzijeSO;
import org.java.movies.app.server.operationFilm.GetReziseriSO;
import org.java.movies.app.server.operationFilm.GetZanroviSO;
import org.java.movies.app.server.operationLista.SaveListaSO;
import org.java.movies.app.server.operationFilm.SaveFilmSO;
import org.java.movies.app.server.operationKorisnik.GetKorisniciSO;
import org.java.movies.app.server.operationRecenzija.SaveRecenizijaSO;
import org.java.movies.app.server.operationLista.UpdateListaSO;
import org.java.movies.app.server.operationRecenzija.FindRecenzijeSO;

/**
 *
 * @author Administrator
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Korisnik login(Korisnik korisnik) throws Exception {
        AbstractGenericOperation getAll = new GetKorisniciSO();
        getAll.execute(new Korisnik());
        List<GenericEntity> korisnici = ((GetKorisniciSO) getAll).getKorisnici();
        for (GenericEntity genericEntity : korisnici) {
            Korisnik korisnik1 = (Korisnik) genericEntity;
            if (korisnik1.getKorisnickoIme().equals(korisnik.getKorisnickoIme()) && korisnik1.getSifra().equals(korisnik.getSifra())) {
                return korisnik1;
            }
        }
        throw new Exception("Pogrešno korisničko ime i/ili lozinka!");
    }

    public void saveFilm(Film film) throws Exception {
        AbstractGenericOperation saveMovie = new SaveFilmSO();
        saveMovie.execute(film);

    }

    public List<GenericEntity> getZanrovi() throws Exception {
        AbstractGenericOperation getAll = new GetZanroviSO();
        getAll.execute(new Zanr());
        return ((GetZanroviSO) getAll).getZanrovi();
    }

    public List<GenericEntity> getReziseri() throws Exception {
        AbstractGenericOperation getAll = new GetReziseriSO();
        getAll.execute(new Reziser());
        return ((GetReziseriSO) getAll).getReziseri();
    }

    public List<GenericEntity> findMovies(Film film) throws Exception {
        AbstractGenericOperation findAll = new FindFilmoviSO();
        findAll.execute(film);
        return ((FindFilmoviSO) findAll).getMovies();
    }

    public List<GenericEntity> getAll(Film film) throws Exception {
        AbstractGenericOperation getAll = new GetFilmoviSO();
        getAll.execute(film);
        return ((GetFilmoviSO) getAll).getMovies();
    }

    public void saveRecenzija(Recenzija recezija) throws Exception {
        AbstractGenericOperation saveRecenzija = new SaveRecenizijaSO();
        saveRecenzija.execute(recezija);
    }

    public List<GenericEntity> getRecenzije(Recenzija recenzija) throws Exception {
        AbstractGenericOperation getAll = new GetRecenzijeSO();
        getAll.execute(recenzija);
        return ((GetRecenzijeSO) getAll).getRecenzije();
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        AbstractGenericOperation delete = new DeleteRecenzijaSO();
        delete.execute(recenzija);
    }

    public void addLista(Lista lista) throws Exception {
        AbstractGenericOperation saveLista = new SaveListaSO();
        saveLista.execute(lista);
    }

    public Object getGlumci() throws Exception {
        AbstractGenericOperation getAll = new GetGlumciSO();
        getAll.execute(new Glumac());
        return ((GetGlumciSO) getAll).getGlumci();
    }

    public List<GenericEntity> findListe(Lista lista) throws Exception {
        AbstractGenericOperation find = new FindListaSO();
        find.execute(lista);
        return ((FindListaSO) find).getListe();
    }

    public void deleteLista(Lista lista) throws Exception {
        AbstractGenericOperation delete = new DeleteListaSO();
        delete.execute(lista);
    }

    public List<GenericEntity> getListe(Lista lista) throws Exception {
        AbstractGenericOperation getAll = new GetListeSO();
        getAll.execute(lista);
        return ((GetListeSO) getAll).getListe();
    }

    public void updateLista(Lista lista) throws Exception {
        AbstractGenericOperation update = new UpdateListaSO();
        update.execute(lista);
    }

    public Object findRecenzije(Recenzija recenzija) throws Exception {
           AbstractGenericOperation findAll = new FindRecenzijeSO();
        findAll.execute(recenzija);
        return ((FindRecenzijeSO) findAll).getRecenzije();
    }
}
