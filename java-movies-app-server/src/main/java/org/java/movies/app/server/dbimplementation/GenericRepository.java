/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java.movies.app.server.dbimplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.java.movies.app.common.domain.GenericEntity;
import org.java.movies.app.server.db.DbRepository;
import org.java.movies.app.server.db.DBConnectionFactory;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class GenericRepository implements DbRepository<GenericEntity> {

    @Override
    public void add(GenericEntity entity) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getInsertColumns()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
           
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();

            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
                entity.afterInsert(connection, id);
            }

            rsKey.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity entity) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").append(entity.getTableName()).append(" WHERE id=").append(entity.getIdOfEntity());
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.execute(query);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void update(GenericEntity entity) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ").append(entity.getTableName() + " SET ").append(entity.getUpdateText())
                    .append(" WHERE id=").append(entity.getIdOfEntity());
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.execute(query);
           

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity entity) throws Exception {
        List<GenericEntity> entityList;
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT *").append(entity.getAgregateFunctions()).append(" FROM ").
                    append(entity.getTableName()).append(entity.getJoinTables()).
                    append(entity.getSpecaialQueryEndings()).
                    append(entity.getKorisnikIdentification());
            String query = stringBuilder.toString();
            
            ResultSet rs = statement.executeQuery(query);
            entityList = entity.resultSetToList(rs);
            return entityList;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> find(GenericEntity entity) throws Exception {
        List<GenericEntity> foundEntities;
        try {
            Map<String, String> criteria = entity.getSearchCriteria();
            Connection connection = DBConnectionFactory.getInstance().getConnection();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT *").append(entity.getAgregateFunctions()).append(" FROM ").
                    append(entity.getTableName()).append(" ").append(entity.getJoinTables()).
                    append(entity.getSpecaialQueryEndings()).
                    append(entity.getKorisnikIdentification());

            stringBuilder.append(" AND ");

            boolean daLiJePrvi = true;
            for (Map.Entry<String, String> entry : criteria.entrySet()) {
                if (!daLiJePrvi) {
                    stringBuilder.append(" AND ");
                }
                String field = entry.getKey();
                String value = entry.getValue();
                if (field.startsWith("naziv")) {
                    stringBuilder.append(field).append(" LIKE '").append(value).append("%'");
                } else {
                    stringBuilder.append(field).append(" = '").append(value).append("'");
                }
                daLiJePrvi = false;
            }

            String query = stringBuilder.toString();
            
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            foundEntities = entity.resultSetToList(resultSet);
            return foundEntities;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
