/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.client.model;

import org.java.movies.app.common.domain.Film;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class SimpleFilmTableModel extends AbstractTableModel{
    List<Film> filmovi;
    String[] columns=new String[]{"Naziv", "DatumIzlaska", "TrajanjeFilma", "DrzavaPorekla"};
    
    public SimpleFilmTableModel(){
        filmovi=new ArrayList<>();
    }
    
    public SimpleFilmTableModel(List<Film> filmovi){
        this.filmovi=filmovi;
    }
    
    @Override
    public int getRowCount() {
        return filmovi.size();
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
        Film film=filmovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return film.getNaziv();
            case 1:
                return film.getDatumIzlaska();
            case 2:
                return film.getTrajajanjeFilma();
            case 3:
                return film.getDrzavaPorekla();
            default:
                return "N/A";
        }
    }
    public void delete(Film film){
        filmovi.remove(film); 
        fireTableDataChanged();
    }
    
    public void add(Film film){
        filmovi.add(film);
        fireTableRowsInserted(filmovi.size()-1, filmovi.size());
        
    }
    
    public Film getFilm(int row){
        return filmovi.get(row);
    }
    
    public List<Film> getFilmovi(){
        
        return filmovi;
    }
}
