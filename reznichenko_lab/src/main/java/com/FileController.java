//package com;
//
//import com.functional.HouseFunctional;
//import com.house.House;
//
//import java.io.*;
//import java.util.Objects;
//
//public class FileController {
//    private static final String mainPath= ("D:\\Учеба\\программирование" +
//            "\\Java_projects\\AccountingSystem\\Cites\\");
//    private static final String[] houseParameters={"Number: №","Square: ","Population: ","Floors: ","Apartments: "};
//
//    private FileController(){
//        throw new AssertionError();
//    }
//
//    public static void saveCityInformation(City city) throws IOException {
//        String path=mainPath+city.getName()+".txt";
//        File file=new File(path);
//        if(!file.exists()) {
//            if (!file.createNewFile()) {
//                throw new IOException();
//            }
//        }
//        FileWriter fileWriter=new FileWriter(file);
//        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
//        for(House house: city.houses){
//            String[] parameters=prepareHouseToSave(house);
//            for(String parameter: parameters){
//                bufferedWriter.write(parameter);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.newLine();
//        }
//        bufferedWriter.flush();
//        bufferedWriter.close();
//        fileWriter.close();
//    }
//
//    public static void downloadCityInformation(City city) throws IOException {
//        String path=mainPath+city.getName()+".txt";
//        File file=new File(path);
//        FileReader fileReader=new FileReader(file);
//        BufferedReader bufferedReader=new BufferedReader(fileReader);
//        int[] parameters=new int[houseParameters.length];
//        if (bufferedReader.ready()) {
//            try {
//                for(int i=0; bufferedReader.ready(); ++i) {
//                    String line = bufferedReader.readLine();
//                    if (!line.isBlank()) {
//                        parameters[i] = Integer.parseInt(line.substring(houseParameters[i].length()));
//                    }
//                }
//                House house=new House();
//                FileController.prepareHouse(house, parameters);
//                city.houses.add(house);
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            System.out.println("Download");
//        }
//    }
//
//    private static String[] prepareHouseToSave(House house) throws IOException {
//        if(house==null){
//            throw new IOException();
//        }
//        String[] parameters=new String[5];
//        parameters[0]=houseParameters[0]+house.getNumber();
//        parameters[1]=houseParameters[1]+ (int)(HouseFunctional.countSqr(house));
//        parameters[2]=houseParameters[2]+ HouseFunctional.countTenants(house);
//        parameters[3]=houseParameters[3]+house.getFloors();
//        parameters[4]=houseParameters[4]+HouseFunctional.countApartments(house);
//        return parameters;
//    }
//
//    private static void prepareHouse(House house, int[] parameter){
//        house.setNumber(parameter[0]);
//        house.setFloorsNumber(parameter[3]);
//    }
//}
