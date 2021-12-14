package com.dataBase.service;

import com.dataBase.dao.CityDAO;
import com.dataBase.Util;
import com.functional.HouseFunctional;
import com.house.House;

import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CityService extends Util implements CityDAO{
    Connection connection=getConnection();
    private static CityService cityService;

    public static CityService cityService(){
        if(cityService == null){
            cityService = new CityService();
        }
        return cityService;
    }

    public CityService(){}

    @Override
    public void add(House house) throws SQLException {
        PreparedStatement preparedStatement=null;
        String sql="INSERT INTO CITY (ID,SQUARE,POPULATION,FLOORS,APARTMENTS,) VALUES(?,?,?,?,?)";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,house.getNumber());
            preparedStatement.setLong(2, (long) HouseFunctional.countSqr(house));
            preparedStatement.setLong(3,HouseFunctional.countTenants(house));
            preparedStatement.setLong(4,house.getFloors());
            preparedStatement.setLong(5,HouseFunctional.countApartments(house));
            preparedStatement.executeUpdate();
        }catch (SQLException | IOException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public Set<House> getAll() throws SQLException {
        Set<House> apartments=new HashSet<>();
        String sql = "SELECT ID, FLOORS FROM CITY";
        Statement statement=null;
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                House house=new House();
                house.setNumber((int) resultSet.getLong("ID"));
                house.setFloorsNumber((int) resultSet.getLong("FLOORS"));
                apartments.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return apartments;
    }

    @Override
    public House getByID(long id) throws SQLException {
        PreparedStatement preparedStatement=null;
        String sql = "SELECT ID, FLOORS FROM CITY WHERE ID=?";
        House house=new House();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            house.setNumber((int) id);
            house.setFloorsNumber((int) resultSet.getLong("FLOORS"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return house;
    }

    @Override
    public void remove(House house) throws SQLException {
        PreparedStatement preparedStatement=null;
        String sql = "DELETE FROM ADDRESS WHERE ID=?";
        try{
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setLong(1,house.getNumber());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}


