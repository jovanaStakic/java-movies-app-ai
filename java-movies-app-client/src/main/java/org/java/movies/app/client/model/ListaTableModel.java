/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.client.model;

import org.java.movies.app.common.domain.Film;
import org.java.movies.app.common.domain.Lista;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class ListaTableModel extends AbstractTableModel{
    List<Lista> liste;
    String[] kolone=new String[]{"Naziv liste","Filmovi","Datum kreiranja"};
    
    public ListaTableModel(){
        liste=new LinkedList<>();
    }
    
    public ListaTableModel(List<Lista> liste){
        this.liste=liste;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public int getRowCount() {
        return liste.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public Lista getLista(int row){
        return liste.get(row);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lista lista=liste.get(rowIndex);
        switch(columnIndex){
            case 0: return lista.getNazivListe();
            case 1: {String filmovi="";
                for (int i=0;i<3 && i<lista.getFilmovi().size();i++) {
                    filmovi+=lista.getFilmovi().get(i).getNaziv().concat(", ");
                }
                try{
            return filmovi.substring(0, 40);
                }catch(Exception e){
                    return filmovi;
                }
            
            }
            case 2: return lista.getDatumKreiranja();
            default: return "N/A";
        }
    }
    
}
