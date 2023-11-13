/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.java.movies.app.common.domain;

import java.sql.Connection;
import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getInsertColumns();

    String getInsertValues();

    void setId(long id);
    
    Long getIdOfEntity();
    
    List<GenericEntity> resultSetToList(ResultSet rs);

    String getJoinTables();

    String getAgregateFunctions();

    String getSpecaialQueryEndings();

    String getKorisnikIdentification();
    
    Map<String, String> getSearchCriteria();
    
    public void afterInsert(Connection connection, Long id) throws Exception;
    
    String getUpdateText();
    

}
