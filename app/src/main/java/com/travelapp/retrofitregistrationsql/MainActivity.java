package com.travelapp.retrofitregistrationsql;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.travelapp.retrofitregistrationsql.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        studentViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(StudentViewModel.class);


        activityMainBinding.buttonRegActRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        activityMainBinding.buttonRegActShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShowListActivity.class));
            }
        });
    }

    private void insertData() {
        String fullName = activityMainBinding.edittextRegActFullName.getText().toString().trim();
        String universityId = activityMainBinding.edittextRegActUniversityId.getText().toString().trim();
        String courseCode = activityMainBinding.edittextRegActCourseCode.getText().toString().trim();

        if (fullName.isEmpty() || universityId.isEmpty() || courseCode.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill all field", Toast.LENGTH_SHORT).show();
            return;
        } else {

            ModelStudent modelStudent = new ModelStudent(fullName, universityId, courseCode);

            studentViewModel.createNewEvent(modelStudent).observe(MainActivity.this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    if (s != null && s.equalsIgnoreCase("Data Inserted")) {
                        Toast.makeText(MainActivity.this, "Event Created Successfully", Toast.LENGTH_SHORT).show();
                        Log.d("ddddddd", "onChanged: " + s);
                    } else {
                        Toast.makeText(MainActivity.this, "Something Went Wrong" + s, Toast.LENGTH_SHORT).show();
                        Log.d("ddddddd", "onChanged: " + s);
                    }

                }
            });

        }
    }
}