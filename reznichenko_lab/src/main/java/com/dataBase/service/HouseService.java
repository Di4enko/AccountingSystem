package com.dataBase.service;

import com.dataBase.dao.HouseDAO;
import com.dataBase.Util;
import com.house.Apartment;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class HouseService extends Util implements HouseDAO {
    private static HouseService houseService;
    Connection connection=getConnection();

    public static HouseService getHouseService(){
        if(houseService == null){
            houseService = new HouseService();
        }
        return houseService;
    }

    private HouseService(){}

    @Override
    public void add(Apartment apartment) throws SQLException {
        PreparedStatement preparedStatement=null;
        String sql="INSERT INTO HOUSE (ID,SQUARE,POPULATION) VALUES(?,?,?)";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,apartment.getNumber());
            preparedStatement.setLong(2, (long) apartment.getSquare());
            preparedStatement.setLong(3, apartment.getTenants());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
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
    public Set<Apartment> getAll() throws SQLException {
        Set<Apartment> apartments=new HashSet<>();
        String sql = "SELECT ID, SQUARE, POPULATION FROM HOUSE";
        Statement statement=null;
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Apartment apartment=new Apartment();
                apartment.setNumber((int) resultSet.getLong("ID"));
                apartment.setSquare((int) resultSet.getLong("SQUARE"));
                apartment.setTenants((int)resultSet.getLong("POPULATION"));
                apartments.add(apartment);
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
    public Apartment getByID(long id) throws SQLException {
        PreparedStatement preparedStatement=null;
        String sql = "SELECT ID, FLOORS, SQUARE FROM HOUSE WHERE ID=?";
        Apartment apartment=new Apartment();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            apartment.setNumber((int) id);
            apartment.setSquare((int) resultSet.getLong("SQUARE"));
            apartment.setTenants((int) resultSet.getLong("POPULATION"));
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
        return apartment;
    }

    @Override
    public void remove(Apartment apartment) throws SQLException {
        PreparedStatement preparedStatement=null;
        String sql = "DELETE FROM ADDRESS WHERE ID=?";
        try{
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setLong(1,apartment.getNumber());
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
