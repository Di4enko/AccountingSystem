package com.dataBase.dao;

import com.house.House;

import java.sql.SQLException;
import java.util.Set;

public interface CityDAO {
    void add(House house) throws SQLException;

    Set<House> getAll() throws SQLException;

    House getByID(long id) throws SQLException;

    void remove(House house) throws SQLException;
}
