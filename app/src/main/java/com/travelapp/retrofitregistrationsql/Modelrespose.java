package com.travelapp.retrofitregistrationsql;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Modelrespose {
    @SerializedName("data")
    @Expose
    private List<ModelSt dent> data = null;
    @SerializedName("success")
    @Expose
    private String success;

    public List<ModelStudent> getData() {
        return data;
    }

    public void setData(List<ModelStudent> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
