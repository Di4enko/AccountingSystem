package com;

import com.functional.HouseFunctional;
import com.house.House;

import java.io.*;

public class FileController {
    private static String mainPath;
    private static final String[] houseParameters = {"Number: №", "Square: ", "Population: ", "Floors: ", "Apartments: "};

    public FileController(String path) throws IOException{
        mainPath = path;
        File file=new File(path);
        if(!file.exists()) {
            if (!file.mkdir()) {
                throw new IOException();
            }
        }
    }

    public void saveHouse(House house) throws IOException {
        if(house==null) {
            throw new IOException();
        }
        String path = mainPath + "\\House №" + house.getNumber() + ".txt";
        File file = new File(path);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException();
            }
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String[] parameters = prepareHouseToSave(house);
        for (String parameter : parameters) {
            bufferedWriter.write(parameter);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    private String[] prepareHouseToSave(House house) throws IOException {
        if (house == null) {
            throw new IOException();
        }
        String[] parameters = new String[5];
        parameters[0] = houseParameters[0] + house.getNumber();
        parameters[1] = houseParameters[1] + (int) (HouseFunctional.countSqr(house));
        parameters[2] = houseParameters[2] + HouseFunctional.countTenants(house);
        parameters[3] = houseParameters[3] + house.getFloors();
        parameters[4] = houseParameters[4] + HouseFunctional.countApartments(house);
        return parameters;
    }

    public String getMainPath(){
        return mainPath;
    }
}