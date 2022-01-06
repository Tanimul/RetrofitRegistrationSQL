package com.travelapp.retrofitregistrationsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.travelapp.retrofitregistrationsql.databinding.ActivityShowListBinding;

import java.util.ArrayList;
import java.util.List;

public class ShowListActivity extends AppCompatActivity {
    private static final String TAG = "ShowListActivity";
    private ActivityShowListBinding activityShowListBinding;
    private StudentListAdapter studentListAdapter;
    private ArrayList<ModelStudent> students;
    StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityShowListBinding = ActivityShowListBinding.inflate(getLayoutInflater());
        setContentView(activityShowListBinding.getRoot());

        students = new ArrayList<>();
        studentListAdapter = new StudentListAdapter(students);
        activityShowListBinding.recViewShowList.setLayoutManager(new LinearLayoutManager(this));
        activityShowListBinding.recViewShowList.setAdapter(studentListAdapter);
        studentViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(StudentViewModel.class);


//        studentViewModel.getStudentList().observe(this, new Observer<List<ModelStudent>>() {
//            @Override
//            public void onChanged(List<ModelStudent> studentList) {
//               // Log.d(TAG, "onChanged: "+studentList.size());
//                students.addAll(studentList);
//                studentListAdapter.notifyDataSetChanged();
//            }
//        });

        studentViewModel.getStudentList().observe(this, new Observer<Modelrespose>() {
            @Override
            public void onChanged(Modelrespose modelrespose) {
                Log.d(TAG, "onChanged: " + modelrespose.getData().size());
                students.addAll(modelrespose.getData());
                studentListAdapter.notifyDataSetChanged();
            }
        });
    }
}