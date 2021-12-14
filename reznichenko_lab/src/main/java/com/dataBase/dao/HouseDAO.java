package com.dataBase.dao;

import com.house.Apartment;

import java.sql.SQLException;
import java.util.Set;

public interface HouseDAO {

    void add(Apartment apartment) throws SQLException;

    Set<Apartment> getAll() throws SQLException;

    Apartment getByID(long ID) throws SQLException;

    void remove(Apartment apartment) throws SQLException;
}
