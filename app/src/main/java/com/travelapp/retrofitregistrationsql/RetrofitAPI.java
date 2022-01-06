package com.travelapp.retrofitregistrationsql;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("insert.php")
    Observable<String> createStudent(@Body ModelStudent modelStudent);

    //    @GET("retrive.php")
//    Observable<List<ModelStudent>> studentList();
    @GET("retrive.php")
    Observable<Modelrespose> getList();
}
