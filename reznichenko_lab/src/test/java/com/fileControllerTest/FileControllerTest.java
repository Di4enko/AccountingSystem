package com.fileControllerTest;

import com.FileController;
import com.house.Apartment;
import com.house.Floor;
import com.house.House;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileControllerTest {
    private static final String mainPath="D:\\Учеба\\программирование\\Java_projects\\AccountingSystem\\reznichenko_lab\\src\\" +
            "test\\java\\com\\fileControllerTest";
    private static FileController fileController;

    static {
        try {
            fileController = new FileController(mainPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveHouse(){
        House house =new House();
        Floor floor1=new Floor();
        Floor floor2=new Floor();
        Floor floor3=new Floor();
        floor1.apartments.add(Apartment.createApartmentWithParameters(37,3,1));
        floor1.apartments.add(Apartment.createApartmentWithParameters(45,1,2));
        floor2.apartments.add(Apartment.createApartmentWithParameters(50,5,3));
        floor2.apartments.add(Apartment.createApartmentWithParameters(32,5,4));
        floor3.apartments.add(Apartment.createApartmentWithParameters(41,2,5));
        floor3.apartments.add(Apartment.createApartmentWithParameters(26,3,6));
        house.floors.add(floor1);
        house.floors.add(floor2);
        house.floors.add(floor3);
        house.setFloorsNumber(3);
        house.setNumber(1);
        try {
            fileController.saveHouse(house);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File actualFile=new File(mainPath+"\\actualInformation.txt");
        File expectedFile=new File(mainPath+"\\House №1.txt");
        StringBuilder actualInformation=new StringBuilder();
        StringBuilder expectedInformation=new StringBuilder();
        try {
            FileReader fileReader=new FileReader(actualFile);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while(bufferedReader.ready()) {
                actualInformation.append(bufferedReader.readLine());
            }
            fileReader=new FileReader(expectedFile);
            bufferedReader=new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                expectedInformation.append(bufferedReader.readLine());
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!expectedFile.delete()){
            System.err.println("File deletion error");
        }
        assertEquals(expectedInformation.toString(),actualInformation.toString());
    }
}
