/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.common.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public abstract class SearchingEntity implements GenericEntity {

    protected Map<String, String> searchCriteria = new HashMap<>();

    @Override
    public final Map<String, String> getSearchCriteria() {
        setSearchCriteria();
        return searchCriteria;
    }

    public abstract void setSearchCriteria();

}
