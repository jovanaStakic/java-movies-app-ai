/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.server.formThread;

import org.java.movies.app.common.domain.Korisnik;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.java.movies.app.server.model.KorisnikTableModel;
import org.java.movies.app.server.server.Server;

/**
 *
 * @author Administrator
 */
public class FormThread extends Thread{
    
    boolean signal;
    KorisnikTableModel model;
    
    
    public FormThread(KorisnikTableModel model) {
       
        signal=false;
       this.model=model;
       
    }

    @Override
    public void run() {
        while (!signal) {            
            try {
                List<Korisnik> korisnici=Server.getAktivniKorisnici();
                model.refresh(korisnici);
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FormThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void stopThread(){
        signal=true;
    }
    
}
