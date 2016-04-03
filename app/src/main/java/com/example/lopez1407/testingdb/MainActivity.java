package com.example.lopez1407.testingdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lopez1407.testingdb.dao.TestingDB;
import com.example.lopez1407.testingdb.DaoApp;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDBResult;
    private Button btnShowDB;
    private Button btnAddDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBResult = (TextView)findViewById(R.id.tvDBResult);
        btnAddDB = (Button)findViewById(R.id.btnAddDB);
        btnShowDB = (Button)findViewById(R.id.btnShowDB);

        btnShowDB.setOnClickListener(this);
        btnAddDB.setOnClickListener(this);

    }

                @Override
                public void onClick(View v) {
                switch (v.getId()){

                    case R.id.btnAddDB:
                        Intent intent = new Intent(this, DataBase.class);
                        startActivityForResult(intent, 9999);
                        break;

                    case R.id.btnShowDB:

                        String str="";
                        List<TestingDB> list = DaoApp.getTestingDBDao().loadAll();
                        for(TestingDB element: list){
                            str=str+element.getId()+": "+element.getName()+"/ "+element.getPhone()+" ";
                        }

                        tvDBResult.setText(str);
                        break;





        }
    }

}
