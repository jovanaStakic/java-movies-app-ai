/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.clientThread;

import org.java.movies.app.common.communication.*;
import org.java.movies.app.common.domain.*;
import org.java.movies.app.server.controller.Controller;
import org.java.movies.app.server.server.*;
import java.io.IOException;

import java.net.Socket;


/**
 *
 * @author Administrator
 */
public class HandleClients extends Thread {

    Socket client;
    Sender sender;
    Reciever reciever;
    Korisnik prijavljenKorisnik;

    public HandleClients(Socket client) {
        this.client = client;
        sender = new Sender(client);
        reciever = new Reciever(client);
    }

    @Override
    public void run() {
        while (!client.isClosed()) {
            try {
                Request request = (Request) reciever.recieve();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Korisnik korisnik =Controller.getInstance().login((Korisnik) request.getArgument());
                            response.setResult(korisnik);
                            prijavljenKorisnik = korisnik;
                            break;
                        case SAVE_FILM:
                            Film f = (Film) request.getArgument();
                            f.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().saveFilm(f);
                            break;
                        case GET_ZANROVI:
                            response.setResult(Controller.getInstance().getZanrovi());
                            break;
                        case GET_REZISERI:
                            response.setResult(Controller.getInstance().getReziseri());
                            break;
                        case GET_GLUMCI:
                            response.setResult(Controller.getInstance().getGlumci());
                            break;
                        case FIND_FILMOVI:
                            Film film = (Film) request.getArgument();
                            film.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().findMovies(film));
                            break;
                        case GET_FILMOVI:
                            response.setResult(Controller.getInstance().getAll(new Film(Long.MIN_VALUE, null, null, Integer.MIN_VALUE, null, prijavljenKorisnik, null, null, null)));
                            break;
                        case SAVE_RECENZIJA:
                            Recenzija recenzija1 = (Recenzija) request.getArgument();
                            recenzija1.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().saveRecenzija(recenzija1);
                            break;
                        case GET_RECENZIJE:
                            Recenzija recenzija = new Recenzija();
                            recenzija.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().getRecenzije(recenzija));
                            break;
                        case DELETE_RECENZIJA:
                            Controller.getInstance().deleteRecenzija((Recenzija) request.getArgument());
                            break;
                        case SAVE_LISTA:
                            Lista lista = (Lista) request.getArgument();
                            lista.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().addLista(lista);
                            break;
                        case FIND_RECENZIJE:
                            Recenzija recenzija3 = (Recenzija) request.getArgument();
                            recenzija3.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().findRecenzije(recenzija3));
                            break;
                        case DELETE_LISTA:
                            Lista lista1 = (Lista) request.getArgument();
                            lista1.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().deleteLista(lista1);
                            break;
                        case FIND_LISTE:
                            Lista lista2 = (Lista) request.getArgument();
                            lista2.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().findListe(lista2));
                            break;
                        case GET_LISTE:
                            Lista lista3 = new Lista();
                            lista3.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().getListe(lista3));
                            break;
                        case UPDATE_LISTA:
                            Lista lista4 = (Lista) request.getArgument();
                            lista4.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().updateLista(lista4);
                            break;
                    }
                } catch (Exception e) {
                    
                    response.setException(e);
                }

                sender.send(response);
            } catch (Exception ex) {
                try {
                    client.close();
                    Server.removeKorisnik(client);
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }

            }

        }
    }

    public Korisnik getKorisnik() {
        return prijavljenKorisnik;
    }

    public Socket getClientSocket() {
        return client;

    }
}
