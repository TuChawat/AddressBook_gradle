package com.bridgelabz.DotCSV;

import com.bridgelabz.ContactPerson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DotCSV {
    private static String Person;

    public static void main(String [] args) throws IOException {
        String filePath = "filepath.csv";
        Write(filePath);
        System.out.print(filePath);
        String filepath = "filepath.csv";
        Read(filePath);
        System.out.print(filePath);


    }

    private static void Read(String filePath) throws IOException {
        BufferedReader reader = null;
        try {
            List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length > 0 ) {
                ContactPerson contactPerson = new ContactPerson();
                contactPerson.setFirstname(fields[0]);
                contactPerson.setLastname(fields[1]);
                contactPerson.setAddress(fields[2]);
                contactPerson.setCity(fields[3]);
                contactPerson.setState(fields[4]);
            }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            reader.close();
        }
    }


    private static void Write(String filePath) throws IOException {
        List<ContactPerson> contactPersonList = new ArrayList<ContactPerson>();
        ContactPerson contactPerson1 = new ContactPerson();
        contactPerson1.setFirstname("Tushar");
        contactPerson1.setLastname("Chawat");
        contactPerson1.setAddress("Sewagram");
        contactPerson1.setCity("Wardha");
        contactPerson1.setState("Maharashtra");
        contactPersonList.add(contactPerson1);

        ContactPerson contactPerson2 = new ContactPerson();
        contactPerson2.setFirstname("Kunal");
        contactPerson2.setLastname("Urkude");
        contactPerson2.setAddress("Borgoan");
        contactPerson2.setCity("Wardha");
        contactPerson2.setState("Maharashtra");
        contactPersonList.add(contactPerson2);

        ContactPerson contactPerson3 = new ContactPerson();
        contactPerson3.setFirstname("Abhishek");
        contactPerson3.setLastname("Awachat");
        contactPerson3.setAddress("Hinganghat");
        contactPerson3.setCity("Hinganghat");
        contactPerson3.setState("Maharashtra");
        contactPersonList.add(contactPerson3);

        FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(filePath);
                fileWriter.append("firstname, lastname, address, city, state");
                fileWriter.append("\n");
                for (ContactPerson contactPerson : contactPersonList) {
                    fileWriter.append(contactPerson.getFirstname());
                    fileWriter.append(",");
                    fileWriter.append(contactPerson.getLastname());
                    fileWriter.append(",");
                    fileWriter.append(contactPerson.getAddress());
                    fileWriter.append(",");
                    fileWriter.append(contactPerson.getCity());
                    fileWriter.append(",");
                    fileWriter.append(contactPerson.getState());
                    fileWriter.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fileWriter.flush();
                fileWriter.close();
            }


        }


    }



