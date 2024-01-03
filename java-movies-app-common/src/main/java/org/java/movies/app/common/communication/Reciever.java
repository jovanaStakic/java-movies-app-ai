/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.common.communication;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 *
 * @author Administrator
 */
public class Reciever<T> {
    private Socket socket;
    private Gson gson;
    
    public Reciever(Socket socket) {
        this.socket = socket;
        gson=new GsonBuilder().create();
    }

public T recieve(Class<T> clazz) throws Exception{
        try {
        	BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return gson.fromJson(in.readLine(), clazz);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška kod prijema objekta! "+ex.getMessage());
        }
}    
    
}
