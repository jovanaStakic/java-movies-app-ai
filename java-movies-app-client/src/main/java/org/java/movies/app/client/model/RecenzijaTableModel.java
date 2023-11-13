/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.client.model;

import org.java.movies.app.common.domain.Recenzija;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class RecenzijaTableModel extends AbstractTableModel{
    List<Recenzija> recenzije;
    String[] kolone=new String[]{"Film","Datum kreiranja", "Ocena", "Utisak"};
    
    public RecenzijaTableModel(){
        recenzije=new LinkedList<>();
    }
    
    public RecenzijaTableModel(List<Recenzija> recenzije){
        this.recenzije=recenzije;
    }
    
    @Override
    public int getRowCount() {
        return recenzije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public Recenzija getRecenzija(int row){
        return recenzije.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recenzija recenzija=recenzije.get(rowIndex);
        switch(columnIndex){
            case 0: return recenzija.getFilm().getNaziv();
            case 1: return recenzija.getDatumKreiranja();
            case 2: return recenzija.getOcenaFilma();
            case 3: return recenzija.getUtisak().substring(0, 15);
            default: return"N/A";
        }
    }
    
}
