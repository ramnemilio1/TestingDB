package com.example;


import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {

    public static void main(String[] args) throws Exception{

        Schema schema  = new Schema(1,"com.example.lopez1407.testingdb.dao"); // 1 is the Schema version
        schema.enableKeepSectionsByDefault();
        createDatabase(schema);

        DaoGenerator generator = new DaoGenerator();
        generator.generateAll(schema, args[0]);


    }

    private static void createDatabase (Schema schema){

        Entity testingDB = schema.addEntity("TestingDB"); //creating table
        testingDB.addIdProperty();
        testingDB.addStringProperty("Name");
        testingDB.addStringProperty("Phone");

    }
}
