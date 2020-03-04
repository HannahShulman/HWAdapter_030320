package com.example.mypersonactivity0103;



import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    EditText editText;
    TextView textView;
    Button addPersonButton;

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{


        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
