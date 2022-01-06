package com.travelapp.retrofitregistrationsql;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelStudent {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("universityid")
    @Expose
    private String universityid;
    @SerializedName("coursecode")
    @Expose
    private String coursecode;

    public ModelStudent() {
    }

    public ModelStudent(String name, String universityid, String coursecode) {
        this.name = name;
        this.universityid = universityid;
        this.coursecode = coursecode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversityid() {
        return universityid;
    }

    public void setUniversityid(String universityid) {
        this.universityid = universityid;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }
}
