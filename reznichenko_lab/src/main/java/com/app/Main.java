package com.app;

/*in this program the construction of a house
  is based on the total budget, the price per square meter
  and the number of apartments per floor
*/

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        while (userInterface.getStatus()){  //program is true until the exit command is entered
            userInterface.working();
        }
    }
}
