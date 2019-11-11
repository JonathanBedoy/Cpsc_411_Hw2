package com.cpsc41102.homework2.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.cpsc41102.homework2.R;
import com.cpsc41102.homework2.StudentDetailActivity;
import com.cpsc41102.homework2.model.Student;
import com.cpsc41102.homework2.model.StudentDB;

public class SummaryLVAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return StudentDB.getInstance().getStudent().size();
    }

    @Override
    public Object getItem(int i) {
        return StudentDB.getInstance().getStudent().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        } else row_view = view;

        Student s = StudentDB.getInstance().getStudent().get(i);

        TextView firstNameView = row_view.findViewById(R.id.first_name);
        firstNameView.setText(s.getFirstName());
        TextView lastNameView = row_view.findViewById(R.id.last_name);
        lastNameView.setText(s.getLastName());

        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //
                        Toast.makeText(view.getContext(), "View Object was touched", Toast.LENGTH_SHORT).show();


                        // Page Navigation
                        Intent intent = new Intent(view.getContext(), StudentDetailActivity.class);
                        intent.putExtra("PersonIndex", ((Integer) view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );

        return row_view;
    }


}
