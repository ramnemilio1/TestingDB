package com.example.lopez1407.testingdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lopez1407.testingdb.dao.TestingDB;

import java.util.List;

/**
 * Created by lopez1407 on 4/3/2016.
 */
public class DataBase extends AppCompatActivity implements View.OnClickListener  {
    private EditText etName;
    private EditText etPhone;
    private Button btnSave;
    private Button btnClear;
    private TestingDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_layout);

        etName = (EditText)findViewById(R.id.etName);
        etPhone = (EditText)findViewById(R.id.etPhone);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnClear = (Button)findViewById(R.id.btnClear);

        db = new TestingDB();

        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnClear:
                cleaning();

            case R.id.btnSave:
                db.setName(etName.getText().toString());
                db.setPhone(etPhone.getText().toString());
                DaoApp.getTestingDBDao().insertInTx(db);
                setResult(RESULT_OK);
                finish();

                break;
        }
    }


    public void cleaning(){
        etName.setText("");
        etPhone.setText("");
    }
}
