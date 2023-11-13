/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.client.model;
import org.java.movies.app.common.domain.Film;
import org.java.movies.app.common.domain.Glumac;
import org.java.movies.app.common.domain.Uloga;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Administrator
 */
public class UlogaTableModel extends AbstractTableModel{
    List<Uloga> uloge; 
    String[] columns=new String[]{"Glumac","Naziv uloge koju igra"};
    boolean editable=true;
            
    public UlogaTableModel(List<Uloga> uloge){
        this.uloge=uloge;
    }
    
    @Override
    public int getRowCount() {
        return uloge.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Uloga uloga=uloge.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return uloga.getGlumac().getImePrezime();
            case 1:
                return uloga.getNazivUloge();
            default:
                return "N/A";
        }
    }
    public List<Uloga> getUloge(){
        return uloge;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==1)
            return editable;
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Uloga uloga=uloge.get(rowIndex);
         switch (columnIndex) {
            case 1: uloga.setNazivUloge((String) aValue);
            
        }
    }
    
    public void addUloga(Glumac glumac,Film film){
        uloge.add(new Uloga(glumac, film, "Unesite naziv uloge..."));
        fireTableDataChanged();
    }
    public void changeEditable(){
        editable=false;
    }
}
