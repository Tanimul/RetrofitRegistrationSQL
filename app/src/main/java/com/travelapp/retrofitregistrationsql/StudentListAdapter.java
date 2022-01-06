package com.travelapp.retrofitregistrationsql;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentListViewholder> {
    private static final String TAG = "StudentListAdapter";
    private ArrayList<ModelStudent> modelStudents;

    public StudentListAdapter(ArrayList<ModelStudent> modelStudents) {
        this.modelStudents = modelStudents;
    }

    @NonNull
    @Override
    public StudentListViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_user_list, parent, false);
        return new StudentListViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListViewholder holder, int position) {
        ModelStudent modelStudent=modelStudents.get(position);
        holder.fullName.setText(modelStudent.getName());
        holder.universityId.setText(modelStudent.getUniversityid());
        holder.courseCode.setText(modelStudent.getCoursecode());
    }

    @Override
    public int getItemCount() {
        return modelStudents.size();
    }

    public class StudentListViewholder extends RecyclerView.ViewHolder {
        private TextView fullName, universityId, courseCode;

        public StudentListViewholder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.textview_list_fullName);
            universityId = itemView.findViewById(R.id.textview_list_universityId);
            courseCode = itemView.findViewById(R.id.textview_list_courseCode);
        }
    }
}
