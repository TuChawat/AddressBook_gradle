package com.bridgelabz.DotJSON;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteReadJSON {
    public static void main(String[] args) {
        JsonObject emps = new JsonObject();
        emps.addProperty("firstname", "Tushar");
        emps.addProperty("lastname", "Chawat");
        emps.addProperty("Address", "Sewagram");
        emps.addProperty("city", "Wardha");
        emps.addProperty("State", "Maharashtra");

        JsonObject empObj1 = new JsonObject();
        empObj1.addProperty( "AddressBook1", String.valueOf(emps));

        JsonObject emps2 = new JsonObject();
        emps.addProperty("firstname", "Tushar");
        emps.addProperty("lastname", "Chawat");
        emps.addProperty("Address", "Sewagram");
        emps.addProperty("city", "Wardha");
        emps.addProperty("State", "Maharashtra");

        JsonObject empObj2 = new JsonObject();
        empObj2.addProperty( "AddressBook2", String.valueOf(emps2));


        JsonArray empList = new JsonArray();
        empList.add(empObj1);
        empList.add(empObj2);
        try (FileWriter file  = new FileWriter("filepath.json")){
            file.write(empList.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
