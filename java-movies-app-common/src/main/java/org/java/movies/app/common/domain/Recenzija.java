/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.common.domain;

import java.sql.Connection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Recenzija extends SearchingEntity implements Serializable{
    
    private Long id;
    private Date datumKreiranja;
    private int ocenaFilma;
    private String utisak;
    private Korisnik korisnik;
    private Film film;

    public Recenzija() {
    }

    public Recenzija(Long id, Date datumKreiranja, int ocenaFilma, String utisak, Korisnik korisnik, Film film) {
        this.id = id;
        this.datumKreiranja = datumKreiranja;
        this.ocenaFilma = ocenaFilma;
        this.utisak = utisak;
        this.korisnik = korisnik;
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public int getOcenaFilma() {
        return ocenaFilma;
    }

    public void setOcenaFilma(int ocenaFilma) {
        this.ocenaFilma = ocenaFilma;
    }

    public String getUtisak() {
        return utisak;
    }

    public void setUtisak(String utisak) {
        this.utisak = utisak;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.datumKreiranja);
        hash = 53 * hash + this.ocenaFilma;
        hash = 53 * hash + Objects.hashCode(this.utisak);
        hash = 53 * hash + Objects.hashCode(this.korisnik);
        hash = 53 * hash + Objects.hashCode(this.film);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recenzija other = (Recenzija) obj;
        if (this.ocenaFilma != other.ocenaFilma) {
            return false;
        }
        if (!Objects.equals(this.utisak, other.utisak)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datumKreiranja, other.datumKreiranja)) {
            return false;
        }
        if (!Objects.equals(this.korisnik, other.korisnik)) {
            return false;
        }
        return Objects.equals(this.film, other.film);
    }

    @Override
    public String toString() {
        String kratki;
        if(utisak!=null && utisak.length()>15){
            kratki=utisak.substring(0, 15);
        }else
            kratki=utisak;
        return film.getNaziv()+" "+ datumKreiranja+" ocenaFilma: "+ocenaFilma+ " utisak: "+kratki+"...";
        
    }

    @Override
    public String getTableName() {
        return "recenzija";
    }

    @Override
    public String getInsertColumns() {
        return "datumKreiranja, ocenaFilma, utisak, korisnikID, filmID";
    }

    @Override
    public String getInsertValues() {
       return "'" + new java.sql.Date(datumKreiranja.getTime()) + "'," + ocenaFilma + ",'" +utisak + "', " + korisnik.getId() + ", " + film.getId();
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
        List<GenericEntity> recenzije=new ArrayList<>();
        try{
            while(rs.next()){
                Zanr z=new Zanr(rs.getLong("film.zanrID"), "");
                Reziser r=new Reziser(rs.getLong("film.reziserID"),"",new Date(),"");
                Film f=new Film(rs.getLong("film.id"), rs.getString("film.naziv"), rs.getDate("film.datumIzlaska"),
                        rs.getInt("film.trajanjeFilma"), rs.getString("film.drzavaPorekla"), korisnik, 
                        z,r, new ArrayList<Uloga>());
                Recenzija recenzija=new Recenzija(rs.getLong("recenzija.id"),
                        rs.getDate("recenzija.datumKreiranja"), rs.getInt("recenzija.ocenaFilma"), 
                        rs.getString("recenzija.utisak"),
                        korisnik,  f);
                recenzije.add(recenzija);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return recenzije;
    }

    @Override
    public String getJoinTables() {
        return " JOIN film ON recenzija.filmID=film.id ";
    }

    @Override
    public String getAgregateFunctions() {
        return "";
    }

    @Override
    public String getSpecaialQueryEndings() {
        return "";
    }

    @Override
    public String getKorisnikIdentification() {
         return  " HAVING recenzija.korisnikID="+korisnik.getId();
    }

   
    
    @Override
    public Long getIdOfEntity() {
        return id;
    }
      @Override
    public void afterInsert(Connection connection, Long id) throws Exception{
    }

   

    @Override
    public String getUpdateText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setSearchCriteria() {
        if(film!=null){
            searchCriteria.put("filmID", film.getId().toString());
        }
    }
}
