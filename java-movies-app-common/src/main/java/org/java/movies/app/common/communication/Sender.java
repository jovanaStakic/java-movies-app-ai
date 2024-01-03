/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.common.communication;


import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 *
 * @author Administrator
 */
public class Sender<T> {
    private Socket socket;
    private Gson gson;
    
    public Sender(Socket socket) {
        this.socket = socket;
        this.gson=new GsonBuilder().create();
    }
    
    public void send(T obj) throws Exception{
        try {
        	PrintWriter out=new PrintWriter(socket.getOutputStream());
            out.println(gson.toJson(obj));
            //System.out.print(gson.toJson(obj));
            out.flush(); 
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greška kod slanja objekta!\n"+ex.getMessage());
        }
    }
}
