package com.travelapp.retrofitregistrationsql;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    StudentRepository repository;


    public StudentViewModel(@NonNull Application application) {
        super(application);
        if(repository ==null){
            repository=new StudentRepository();
        }

    }


    public LiveData<String> createNewEvent(ModelStudent event){
        return  repository.createNewStudent(event);
    }


//    public LiveData<List<ModelStudent>> getStudentList() {
//        return repository.getStudentList();
//    }
public LiveData<Modelrespose> getStudentList() {
        return repository.getStudentList();
    }

}
