package com.example.lopez1407.testingdb;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import com.example.lopez1407.testingdb.dao.DaoMaster;
import com.example.lopez1407.testingdb.dao.DaoSession;
import com.example.lopez1407.testingdb.dao.TestingDBDao;

/**
 * Created by lopez1407 on 4/2/2016.
 */
public class DaoApp extends Application{

    private static TestingDBDao testingDBDao;

    public static TestingDBDao getTestingDBDao(){
        return testingDBDao;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        /*
        DaoMaster & DaoSession are generated only once, they are used for db management
        TestingDBDao is specific for my TestingDB table
         */
        DaoMaster.DevOpenHelper helper  = new DaoMaster.DevOpenHelper(this, "testingDB-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();  // to avoid memory leaks
        testingDBDao = daoSession.getTestingDBDao();

    }
}
