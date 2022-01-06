package com.travelapp.retrofitregistrationsql;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class StudentRepository {
    private static final String TAG = "StudentRepository";

    private RetrofitAPI retrofitAPI;

    public StudentRepository() {
        retrofitAPI = ApiClient.getClient();

    }

    public LiveData<String> createNewStudent(ModelStudent event) {
        MutableLiveData<String> result = new MutableLiveData<>();
        Log.d(TAG, "createNewStudent: " + event.getName());


        retrofitAPI.createStudent(event).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG, "accept: " + s);
                        if (s != null) {
                            result.postValue(s);
                        } else {
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: " + throwable.getMessage());
                        result.postValue(null);
                    }
                });

        return result;
    }

//    public LiveData<List<ModelStudent>> getStudentList() {
//        MutableLiveData<List<ModelStudent>> result = new MutableLiveData<>();
//
//        retrofitAPI.studentList().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<ModelStudent>>() {
//                    @Override
//                    public void accept(List<ModelStudent> modelStudents) throws Exception {
//                        Log.d(TAG, "accept: ");
//                        if (modelStudents != null) {
//                            result.postValue(modelStudents);
//                        }
//                        else {
//                            result.postValue(null);
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.d(TAG, "get Student :  "+throwable);
//                    }
//                });
//
//        return result;
//    }

    public LiveData<Modelrespose> getStudentList() {
        MutableLiveData<Modelrespose> result = new MutableLiveData<>();

        retrofitAPI.getList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Modelrespose>() {
                    @Override
                    public void accept(Modelrespose modelrespose) throws Exception {
                        Log.d(TAG, "accept: ");
                        if(modelrespose!=null){
                            result.postValue(modelrespose);
                        }else {
                            result.postValue(null);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: Throw");
                    }
                });

        return result;
    }
}
