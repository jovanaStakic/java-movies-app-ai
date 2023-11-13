/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.client.model;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.java.movies.app.common.domain.Film;

/**
 *
 * @author Administrator
 */
public class FullFilmTableModel extends AbstractTableModel{
    List<Film> filmovi;
    String[] kolone=new String[]{"Naziv","Datum izlaska","Trajanje filma","Drzava porekla","Zanr","Reziser"};
    
    public FullFilmTableModel(){
        filmovi=new LinkedList<>();
    }
    
    public FullFilmTableModel(List<Film> filmovi){
        this.filmovi=filmovi;
    }
    
    @Override
    public int getRowCount() {
        return filmovi.size();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film film=filmovi.get(rowIndex);
        switch(columnIndex){
            case 0: return film.getNaziv();
            case 1: return film.getDatumIzlaska();
            case 2: return film.getTrajajanjeFilma();
            case 3: return film.getDrzavaPorekla();
            case 4: return film.getZanr().getNazivZanra();
            case 5: return film.getReziser().getImePrezime();
            default: return "N/A";
    }
    }
    
    public Film getFilm(int row){
        return filmovi.get(row);
    }
    
    public void removeFilm(Film film){
        filmovi.remove(film);
        fireTableRowsDeleted(filmovi.size()-1, filmovi.size());
    }
    public void addFilm(Film film){
        filmovi.add(film);
        fireTableRowsInserted(filmovi.size()-1, filmovi.size());
    }
}
