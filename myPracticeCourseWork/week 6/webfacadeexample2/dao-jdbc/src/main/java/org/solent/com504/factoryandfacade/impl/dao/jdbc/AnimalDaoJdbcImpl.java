/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.impl.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.solent.com504.factoryandfacade.model.dao.AnimalDao;
import org.solent.com504.factoryandfacade.model.dto.Animal;
import org.solent.com504.factoryandfacade.model.dto.AnimalType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author cgallen
 */
public class AnimalDaoJdbcImpl implements AnimalDao
{

    //FOR TUTORIAL SEE https://www.roseindia.net/tutorial/java/jdbc/dataaccessobjectdesignpattern.html  Data Access object (DAO) Design Pattern
    final static Logger LOG = LogManager.getLogger(AnimalDaoJdbcImpl.class);

    private ConnectionFactory connectionFactory;

    public AnimalDaoJdbcImpl(ConnectionFactory cf)
    {
        LOG.debug("AnimalDaoJdbcImpl trying to create new database table");
        this.connectionFactory = cf;

        // create database
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try
        {
            connection = connectionFactory.getConnection();

            String queryString = "CREATE TABLE ANIMAL (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, ADDRESS VARCHAR(255), NAME VARCHAR(255), SOUND VARCHAR(255), TYPE VARCHAR(255), PRIMARY KEY (ID))";

            ptmt = connection.prepareStatement(queryString);
            ptmt.execute();
        }
        catch (Exception e)
        {
            // see https://stackoverflow.com/questions/5866154/how-to-create-table-if-it-doesnt-exist-using-derby-db
            LOG.error("table creation exception (may happen if duplicate table exists)", e);
        }
        finally
        {
            // this releases all of the resources - must be in finally
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ptmt != null)
                {
                    ptmt.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                LOG.error("finally exception", e);
            }
            catch (Exception e)
            {
                LOG.error("rfinally exception", e);
            }
        }
    }

    @Override
    public Animal retrieve(long id)
    {
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        Animal animal = null;
        try
        {
            LOG.debug("retrieve called for id=  " + id);
            connection = connectionFactory.getConnection();

            String queryString = "SELECT ID, NAME, ADDRESS, SOUND, TYPE FROM ANIMAL WHERE ID=?";
            ptmt = connection.prepareStatement(queryString);
            ptmt.setLong(1, id);

            resultSet = ptmt.executeQuery();

            if (resultSet.next())
            {
                animal = new Animal();
                animal.setId(resultSet.getLong("ID"));
                animal.setName(resultSet.getString("NAME"));
                animal.setAddress(resultSet.getString("ADDRESS"));

                AnimalType animalType = new AnimalType();
                animal.setAnimalType(animalType);
                animalType.setSound(resultSet.getString("SOUND"));
                animalType.setType(resultSet.getString("TYPE"));
                LOG.debug("animal retrieved for id=  " + id + " " + animal);
                return animal;
            }
            else
            {
                LOG.debug("no animal retrieved for id=  " + id);
                return animal;
            }
        }
        catch (Exception e)
        {
            LOG.error("retrieve exception", e);
            throw new RuntimeException("retrieve exception", e);
        }
        finally
        {
            // this releases all of the resources - must be in finally
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ptmt != null)
                {
                    ptmt.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                LOG.error("finally exception", e);
            }
            catch (Exception e)
            {
                LOG.error("rfinally exception", e);
            }
            return animal;
        }
    }

    @Override
    public Animal updateOrSave(Animal animal)
    {
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try
        {
            LOG.debug("updateOrSave animal=  " + animal);
            connection = connectionFactory.getConnection();
            String queryString = null;

            if (animal.getId() == null)
            {
                queryString = "INSERT INTO ANIMAL (NAME, ADDRESS, SOUND, TYPE) VALUES(?,?,?,?)";
            }
            else
            {
                queryString = "UPDATE ANIMAL SET NAME=?, ADDRESS=?, SOUND=?, TYPE=? WHERE ID=?";
            }
            ptmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            ptmt.setString(1, animal.getName());
            ptmt.setString(2, animal.getAddress());
            ptmt.setString(3, animal.getAnimalType()
                                    .getSound());
            ptmt.setString(4, animal.getAnimalType()
                                    .getType());

            if (animal.getId() != null)
            {
                // updating animal with existing id
                ptmt.setLong(5, animal.getId());
                int rowAffected = ptmt.executeUpdate();
                if (rowAffected == 1)
                {
                    LOG.debug("updated animal=  " + animal);
                    return animal;
                }
                else
                {
                    LOG.debug("failed to update animal=  " + animal);
                    return null;
                }
            }
            else
            {
                // creating new animal
                int rowAffected = ptmt.executeUpdate();
                if (rowAffected == 1)
                {
                    // get candidate id
                    ResultSet rs = ptmt.getGeneratedKeys();
                    if (rs.next())
                    {
                        Long candidateId = rs.getLong(1);
                        animal.setId(candidateId);
                        LOG.debug("inserted animal=  " + animal);
                        return animal;
                    }
                }
            }
            return null;
        }
        catch (Exception e)
        {
            LOG.error("updateOrSave exception", e);
            throw new RuntimeException("updateOrSave exception", e);
        }
        finally
        {
            // this releases all of the resources - must be in finally
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ptmt != null)
                {
                    ptmt.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                LOG.error("finally exception", e);
            }
            catch (Exception e)
            {
                LOG.error("rfinally exception", e);
            }
        }
    }

    @Override
    public boolean delete(long id)
    {
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        Animal animal = null;
        try
        {
            LOG.debug("delete called for id=  " + id);
            connection = connectionFactory.getConnection();

            String queryString = "DELETE FROM ANIMAL WHERE ID=?";
            ptmt = connection.prepareStatement(queryString);
            ptmt.setLong(1, id);

            long rowAffected = ptmt.executeUpdate();
            if (rowAffected == 0)
            {
                LOG.debug("no rows deleted");
                return false;
            }
            LOG.debug(rowAffected + " rows deleted");
            return true;
        }
        catch (Exception e)
        {
            LOG.error("retrieve exception", e);
            throw new RuntimeException("retrieve exception", e);
        }
        finally
        {
            // this releases all of the resources - must be in finally
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ptmt != null)
                {
                    ptmt.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                LOG.error("finally exception", e);
            }
            catch (Exception e)
            {
                LOG.error("rfinally exception", e);
            }
        }
    }

    @Override
    public List<Animal> retrieve(Animal animalTemplate)
    {
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<Animal> animalList = new ArrayList();
        Animal animal = null;
        try
        {
            LOG.debug("retrieve called animalTemplate=" + animalTemplate);
            connection = connectionFactory.getConnection();

            List<String> valueList = new ArrayList<String>();

            String queryString = "SELECT ID, NAME, ADDRESS, SOUND, TYPE FROM ANIMAL WHERE TRUE=TRUE ";
            // WHERE TRUE=TRUE means WHERE always has a predicate ";

            if (animalTemplate.getName() != null)
            {
                queryString = queryString + "AND NAME LIKE ? "; //':name' ";
                valueList.add(animalTemplate.getName());
            }
            if (animalTemplate.getAddress() != null)
            {
                queryString = queryString + "AND ADDRESS LIKE ?  ";
                valueList.add(animalTemplate.getAddress());
            }
            if (animalTemplate.getAnimalType() != null && animalTemplate.getAnimalType()
                                                                        .getType() != null)
            {
                queryString = queryString + "AND TYPE LIKE ? ";
                valueList.add(animalTemplate.getAnimalType()
                                            .getType());
            }

            LOG.debug("queryString string built: " + queryString + "using parameters: ");
            ptmt = connection.prepareStatement(queryString);
            for (int index = 1; index <= valueList.size(); index++)
            {
                LOG.debug(" index:" + (index - 1) + "   value:" + valueList.get(index - 1));
                ptmt.setString(index, valueList.get(index - 1));
            }

            resultSet = ptmt.executeQuery();

            while (resultSet.next())
            {
                animal = new Animal();
                animal.setId(resultSet.getLong("ID"));
                animal.setName(resultSet.getString("NAME"));
                animal.setAddress(resultSet.getString("ADDRESS"));

                AnimalType animalType = new AnimalType();
                animal.setAnimalType(animalType);
                animalType.setType(resultSet.getString("TYPE"));
                animalType.setSound(resultSet.getString("SOUND"));
                LOG.debug("animal retrieved " + animal);
                animalList.add(animal);
            }
            if (animalList.isEmpty())
            {
                LOG.debug("retrieve - no animals retreived ");
            }
            return animalList;
        }
        catch (Exception e)
        {
            LOG.error("retrieve exception", e);
            throw new RuntimeException("retrieve exception", e);
        }
        finally
        {
            // this releases all of the resources - must be in finally
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ptmt != null)
                {
                    ptmt.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                LOG.error("finally exception", e);
            }
            catch (Exception e)
            {
                LOG.error("finally exception", e);
            }
        }
    }

    @Override
    public List<Animal> retrieveAll()
    {
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<Animal> animalList = new ArrayList();
        Animal animal = null;
        try
        {
            LOG.debug("retrieveAll() called ");
            connection = connectionFactory.getConnection();

            String queryString = "SELECT ID, NAME, ADDRESS, SOUND, TYPE FROM ANIMAL ";
            ptmt = connection.prepareStatement(queryString);

            resultSet = ptmt.executeQuery();

            while (resultSet.next())
            {
                animal = new Animal();
                animal.setId(resultSet.getLong("ID"));
                animal.setName(resultSet.getString("NAME"));
                animal.setAddress(resultSet.getString("ADDRESS"));

                AnimalType animalType = new AnimalType();
                animal.setAnimalType(animalType);
                animalType.setSound(resultSet.getString("SOUND"));
                animalType.setType(resultSet.getString("TYPE"));
                LOG.debug("animal retrieved " + animal);
                animalList.add(animal);
            }
            if (animalList.isEmpty())
            {
                LOG.debug("retrieveAll() - no animals retreived ");
            }
            return animalList;
        }
        catch (Exception e)
        {
            LOG.error("retrieve exception", e);
            throw new RuntimeException("retrieve exception", e);
        }
        finally
        {
            // this releases all of the resources - must be in finally
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ptmt != null)
                {
                    ptmt.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                LOG.error("finally exception", e);
            }
            catch (Exception e)
            {
                LOG.error("finally exception", e);
            }
        }
    }

    @Override
    public void deleteAll()
    {
        PreparedStatement ptmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try
        {
            LOG.debug("deleteAll called");
            connection = connectionFactory.getConnection();

            String queryString = "DELETE FROM ANIMAL";

            ptmt = connection.prepareStatement(queryString);
            ptmt.execute();
        }
        catch (Exception e)
        {

            LOG.error("deleteAll exception", e);
        }
        finally
        {
            // this releases all of the resources - must be in finally
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ptmt != null)
                {
                    ptmt.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                LOG.error("finally exception", e);
            }
            catch (Exception e)
            {
                LOG.error("finally exception", e);
            }
        }
    }

    // no need to synchronize - same as simple dao
    @Override
    public Animal create(AnimalType animalType)
    {
        Animal animal = new Animal();
        animal.setAnimalType(animalType);
        return animal;
    }
}
