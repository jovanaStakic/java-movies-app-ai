/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.clientThread;

import org.java.movies.app.common.communication.*;
import org.java.movies.app.common.domain.*;
import org.java.movies.app.server.controller.Controller;
import org.java.movies.app.server.server.*;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;

import java.net.Socket;


/**
 *
 * @author Administrator
 */
public class HandleClients extends Thread {

    Socket client;
    Sender<Response> sender;
    Reciever<Request> reciever;
    Korisnik prijavljenKorisnik;
    Gson gson;

    public HandleClients(Socket client) {
        this.client = client;
        sender = new Sender<Response>(client);
        reciever = new Reciever<Request>(client);
        gson=new Gson();
    }

    @Override
    public void run() {
        while (!client.isClosed()) {
            try {
                Request request = reciever.recieve(Request.class);
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                        	System.out.println(request);
                        	Korisnik korisnik =Controller.getInstance().login(gson.fromJson(gson.toJson(((LinkedTreeMap<?,?>) request.getArgument())), Korisnik.class));
                            response.setResult(korisnik);
                            prijavljenKorisnik = korisnik;
                            break;
                        case SAVE_FILM:
                            Film f = gson.fromJson(gson.toJson(request.getArgument()),Film.class);
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
                        	Film film = gson.fromJson(gson.toJson(request.getArgument()),Film.class);
                            film.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().findMovies(film));
                            break;
                        case GET_FILMOVI:
                            response.setResult(Controller.getInstance().getAll(new Film(Long.MIN_VALUE, null, null, Integer.MIN_VALUE, null, prijavljenKorisnik, null, null, null)));
                            break;
                        case SAVE_RECENZIJA:
                            Recenzija recenzija1 = gson.fromJson(gson.toJson(request.getArgument()), Recenzija.class);
                            recenzija1.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().saveRecenzija(recenzija1);
                            break;
                        case GET_RECENZIJE:
                            Recenzija recenzija = new Recenzija();
                            recenzija.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().getRecenzije(recenzija));
                            break;
                        case DELETE_RECENZIJA:
                            Controller.getInstance().deleteRecenzija(gson.fromJson(gson.toJson(request.getArgument()), Recenzija.class));
                            break;
                        case SAVE_LISTA:
                            Lista lista = gson.fromJson(gson.toJson(request.getArgument()), Lista.class);
                            lista.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().addLista(lista);
                            break;
                        case FIND_RECENZIJE:
                            Recenzija recenzija3 = gson.fromJson(gson.toJson(request.getArgument()), Recenzija.class);
                            recenzija3.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().findRecenzije(recenzija3));
                            break;
                        case DELETE_LISTA:
                            Lista lista1 =gson.fromJson(gson.toJson(request.getArgument()), Lista.class);
                            lista1.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().deleteLista(lista1);
                            break;
                        case FIND_LISTE:
                            Lista lista2 = gson.fromJson(gson.toJson(request.getArgument()), Lista.class);
                            lista2.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().findListe(lista2));
                            break;
                        case GET_LISTE:
                            Lista lista3 = new Lista();
                            lista3.setKorisnik(prijavljenKorisnik);
                            response.setResult(Controller.getInstance().getListe(lista3));
                            break;
                        case UPDATE_LISTA:
                            Lista lista4 = gson.fromJson(gson.toJson(request.getArgument()), Lista.class);
                            lista4.setKorisnik(prijavljenKorisnik);
                            Controller.getInstance().updateLista(lista4);
                            break;
                    }
                } catch (Exception e) {
                    
                    response.setException(new MyException(e.getMessage(), e.getClass().getSimpleName()));;
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
