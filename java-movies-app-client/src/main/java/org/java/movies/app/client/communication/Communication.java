/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.client.communication;

import org.java.movies.app.common.domain.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import org.java.movies.app.common.communication.*;

import java.util.List;
import java.util.Locale;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author Administrator
 */
public class Communication {
    private static Communication instance;
    Socket socket;
    Sender<Request> sender;
    Reciever<Response> reciever;
    Gson gson;
    
    private Communication() throws Exception {
       
            socket=new Socket("127.0.0.1", 9000);
            sender=new Sender<Request>(socket);
            reciever=new Reciever<Response>(socket);
            gson=new GsonBuilder().setDateFormat("MMM dd, yyyy").create();;
    
    }
    
    public static Communication getInstance() throws Exception{
        if(instance==null)
            instance=new Communication();
        return instance;
    }
    
    public Korisnik login(String korisnickoIme, String sifra) throws Exception {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        Request request = new Request(korisnik, Operation.LOGIN);
        sender.send(request);
        Response response =reciever.recieve(Response.class);

        if (response.getException() == null) {
            return gson.fromJson(gson.toJson(((LinkedTreeMap<?,?>) response.getResult())), Korisnik.class);
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public void saveFilm(Film film) throws Exception {
        Request request = new Request(film, Operation.SAVE_FILM);
        sender.send(request);
        
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {

        } else {
            throw new Exception(response.getException().getMessage());
        }
    }

    public List<Reziser> getReziseri() throws Exception {
        Request request = new Request(null, Operation.GET_REZISERI);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType = new TypeToken<List<Reziser>>(){}.getType();
        	//Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
        	List<Reziser> reziseri = gson.fromJson(gson.toJson(response.getResult()), listType);
            return reziseri;
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public List<Glumac> getGlumci() throws Exception {
        Request request = new Request(null, Operation.GET_GLUMCI);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType = new TypeToken<List<Glumac>>(){}.getType();
        	List<Glumac> glumci = gson.fromJson(gson.toJson(response.getResult()), listType);
            return glumci;
       } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public List<Zanr> getZanrovi() throws Exception {
        Request request = new Request(null, Operation.GET_ZANROVI);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType = new TypeToken<List<Zanr>>(){}.getType();
        	List<Zanr> zanrovi = gson.fromJson(gson.toJson(response.getResult()), listType);
            return zanrovi;
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public List<Film> findMovies(Film film) throws Exception {
        Request request = new Request(film, Operation.FIND_FILMOVI);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType=new TypeToken<List<Film>>() {}.getType();
        	//Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
        	List<Film> filmovi=gson.fromJson(gson.toJson(response.getResult()), listType);
            return filmovi;
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public List<Film> getFilmovi() throws Exception {
        Request request = new Request(null, Operation.GET_FILMOVI);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType=new TypeToken<List<Film>>() {}.getType();
        	//Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
        	List<Film> filmovi=gson.fromJson(gson.toJson(response.getResult()), listType);
            return filmovi;
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public void saveRecenzija(Recenzija recenzija) throws Exception {
        Request request = new Request(recenzija, Operation.SAVE_RECENZIJA);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {

        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public List<Recenzija> getRecenzije() throws Exception {
        Request request = new Request(null, Operation.GET_RECENZIJE);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType=new TypeToken<List<Recenzija>>() {}.getType();
        	List<Recenzija> recenzije=gson.fromJson(gson.toJson(response.getResult()), listType);
        	return recenzije;
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        Request request = new Request(recenzija, Operation.DELETE_RECENZIJA);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {

        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public void addLista(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.SAVE_LISTA);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {

        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }
    
    public List<Lista> getListe() throws Exception{
        Request request=new Request(null, Operation.GET_LISTE);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if(response.getException()==null){
        	Type listType=new TypeToken<List<Lista>>() {}.getType();
        	List<Lista> liste=gson.fromJson(gson.toJson(response.getResult()), listType);
        	return liste;
        }else{
        	throw new Exception(response.getException().getMessage());
        }
    }
    
     public List<Lista> findListe(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.FIND_LISTE);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType=new TypeToken<List<Lista>>() {}.getType();
        	List<Lista> liste=gson.fromJson(gson.toJson(response.getResult()), listType);
        	return liste;
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }
     
      public void deleteLista(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.DELETE_LISTA);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {

        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }
       public void updateLista(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.UPDATE_LISTA);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {

        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }

    public List<Recenzija> findRecenzije(Recenzija recenzija) throws Exception {
          Request request = new Request(recenzija, Operation.FIND_RECENZIJE);
        sender.send(request);
        Response response =reciever.recieve(Response.class);
        if (response.getException() == null) {
        	Type listType=new TypeToken<List<Recenzija>>() {}.getType();
        	List<Recenzija> recenzije=gson.fromJson(gson.toJson(response.getResult()), listType);
        	return recenzije;
        } else {
        	throw new Exception(response.getException().getMessage());
        }
    }
}
