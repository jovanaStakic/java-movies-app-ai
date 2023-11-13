/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.common.domain;

import java.sql.Connection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Film extends SearchingEntity implements Serializable {

    private Long id;
    private String naziv;
    private Date datumIzlaska;
    private int trajajanjeFilma;
    private String drzavaPorekla;
    private Korisnik korisnik;
    private Zanr zanr;
    private Reziser reziser;
    private List<Uloga> uloge;
    private Status status=Status.NEPROMENJEN;
    
    public Film() {
    }

    public Film(Long id, String naziv, Date datumIzlaska, int trajajanjeFilma, String drzavaPorekla, Korisnik korisnik, Zanr zanr, Reziser reziser, List<Uloga> uloge) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzlaska = datumIzlaska;
        this.trajajanjeFilma = trajajanjeFilma;
        this.drzavaPorekla = drzavaPorekla;
        this.korisnik = korisnik;
        this.zanr = zanr;
        this.reziser = reziser;
        this.uloge = uloge;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Reziser getReziser() {
        return reziser;
    }

    public void setReziser(Reziser reziser) {
        this.reziser = reziser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumIzlaska() {
        return datumIzlaska;
    }

    public void setDatumIzlaska(Date datumIzlaska) {
        this.datumIzlaska = datumIzlaska;
    }

    public int getTrajajanjeFilma() {
        return trajajanjeFilma;
    }

    public void setTrajajanjeFilma(int trajajanjeFilma) {
        this.trajajanjeFilma = trajajanjeFilma;
    }

    public String getDrzavaPorekla() {
        return drzavaPorekla;
    }

    public void setDrzavaPorekla(String drzavaPorekla) {
        this.drzavaPorekla = drzavaPorekla;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    
    public List<Uloga> getUloge() {
        return uloge;
    }

    public void setUloge(List<Uloga> uloge) {
        this.uloge = uloge;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.naziv);
        hash = 73 * hash + Objects.hashCode(this.datumIzlaska);
        hash = 73 * hash + this.trajajanjeFilma;
        hash = 73 * hash + Objects.hashCode(this.drzavaPorekla);
        hash = 73 * hash + Objects.hashCode(this.korisnik);
        hash = 73 * hash + Objects.hashCode(this.zanr);
        hash = 73 * hash + Objects.hashCode(this.reziser);
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
        final Film other = (Film) obj;
        if (this.trajajanjeFilma != other.trajajanjeFilma) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.drzavaPorekla, other.drzavaPorekla)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.datumIzlaska, other.datumIzlaska);
    }


 

    @Override
    public String toString() {
        return naziv + " ( datumIzlaska: " + datumIzlaska + ", trajajanjeFilma:" + trajajanjeFilma + ", drzavaPorekla: " + drzavaPorekla + ", zanr: " + zanr.getNazivZanra() + ", reziser: " + reziser.getImePrezime() + " )";
    }

    @Override
    public String getTableName() {
        return "film";
    }

    @Override
    public String getInsertColumns() {
        return "naziv, datumIzlaska, trajanjeFilma, drzavaPorekla, korisnikID, zanrID, reziserID";
    }

    @Override
    public String getInsertValues() {

        return "'" + naziv + "','" + new java.sql.Date(datumIzlaska.getTime()) + "'," + trajajanjeFilma + ",'" + drzavaPorekla + "'," + korisnik.getId() + "," + zanr.getId() + "," + reziser.getId();

    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    
    

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
        List<GenericEntity> filmovi = new ArrayList<>();
        try {
            while (rs.next()) {
                Zanr zanr = new Zanr(rs.getLong("zanr.id"), rs.getString("zanr.nazivZanra"));
                Reziser reziser = new Reziser(rs.getLong("reziser.id"), rs.getString("reziser.imePrezime"), rs.getDate("reziser.datumRodjenja"), rs.getString("reziser.drzavaPorekla"));
                List<Uloga> uloge = new ArrayList<>();
                String[] idGlumaca = rs.getString("glumciID").split(",");
                String[] imenaGlumaca = rs.getString("glumciIme").split(",");
                String[] naziviUloga=rs.getString("nazivUloga").split(",");
                for (int i = 0; i < idGlumaca.length; i++) {
                    uloge.add(new Uloga(new Glumac(Long.parseLong(idGlumaca[i].trim()), imenaGlumaca[i].trim()),new Film()
                            ,naziviUloga[i].trim()));
                }
                Film film = new Film(rs.getLong("id"), rs.getString("naziv"), rs.getDate("datumIzlaska"), rs.getInt("trajanjeFilma"),
                        rs.getString("drzavaPorekla"), korisnik, zanr, reziser, uloge);
                filmovi.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmovi;
    }

    @Override
    public String getJoinTables() {
        return " JOIN zanr ON film.zanrID=zanr.ID JOIN reziser ON film.reziserID=reziser.ID LEFT JOIN uloga \n"
                + "ON film.ID=uloga.filmID JOIN glumac ON uloga.glumacID=glumac.id ";
    }

    @Override
    public String getAgregateFunctions() {
        return ",GROUP_CONCAT(glumac.id SEPARATOR ', ') AS glumciID,GROUP_CONCAT(glumac.imePrezime SEPARATOR ', ') AS glumciIme,"
                + "GROUP_CONCAT(uloga.imeUloge SEPARATOR ', ') AS nazivUloga";
    }

    @Override
    public String getSpecaialQueryEndings() {
        return " GROUP BY film.id ";
    }

    @Override
    public String getKorisnikIdentification() {
        return "HAVING korisnikID=" + korisnik.getId();
    }

    @Override
    public void setSearchCriteria() {
        if (zanr != null) {
            searchCriteria.put("zanrID", zanr.getId().toString());
        }

        if (reziser != null) {
            searchCriteria.put("reziserID", reziser.getId().toString());
        }

        if (naziv != null) {
            searchCriteria.put("naziv", naziv);
        }
    }
    
    @Override
    public Long getIdOfEntity() {
        return id;
    }
    
    @Override
    public void afterInsert(Connection connection, Long id) throws Exception{
         for (Uloga uloga:uloge) {
            String query = "INSERT INTO Uloga (FilmID, GlumacID, imeUloge) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.setLong(2, uloga.getGlumac().getId());  
            statement.setString(3, uloga.getNazivUloge());
            statement.executeUpdate();
        }
    }

  

    @Override
    public String getUpdateText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
