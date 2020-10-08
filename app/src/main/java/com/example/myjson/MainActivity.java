package com.example.myjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    JSONObject obj, m_Obj, jo_inside;
    JSONArray m_jArry;
    List<Student> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            obj = new JSONObject(loadJSONFromAsset());
            m_Obj = obj.getJSONObject("resultdata");
            m_jArry = m_Obj.getJSONArray("student");
            for (int i = 0; i < m_jArry.length(); i++) {
                jo_inside = m_jArry.getJSONObject(i);
            }

            users = new Gson().fromJson(m_jArry.toString(), new TypeToken<List<Student>>() {
            }.getType());

            Log.i("data", "last data:" + users.get(users.size() - 1));
            Log.i("data", "data of Ram:" + users.get(2));
            duplicateId();
            duplicateName();
            duplicateSchool();


            studentName();

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void duplicateName() {
        for (int i = 0; i < (users.size()); i++) {
            for (int j = i + 1; j < (users.size() - 1); j++) {
                if (users.get(i).getName().equals(users.get(j).getName())) {
                    Log.i("data", "duplicate name:" + users.get(j).getName());
                }
            }
        }
    }

    private void duplicateSchool() {
        for (int i = 0; i < (users.size()); i++) {
            for (int j = i + 1; j < (users.size() - 1); j++) {
                if (users.get(i).getSchool().equals(users.get(j).getSchool())) {
                    Log.i("data", "duplicate school:" + users.get(j).getSchool());
                }
            }
        }

    }

    private void duplicateId() {
        for (int i = 0; i < (users.size()); i++) {
            for (int j = i + 1; j < (users.size()); j++) {
                if (users.get(i).getId() == users.get(j).getId()) {
                    Log.i("data", "duplicate Id:" + users.get(j).getId());
                }
            }
        }
    }


    private void studentName() {
        String temp;
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if ((users.get(i).getName()).compareToIgnoreCase(users.get(j).getName()) >= 0) {
                    temp = users.get(i).getName();
                    users.get(i).getName().equals(users.get(j).getName());
                    users.get(j).getName().equals(temp);
                    Log.i("data", "list" + users.get(i).getName());


                }
            }
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("example.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
