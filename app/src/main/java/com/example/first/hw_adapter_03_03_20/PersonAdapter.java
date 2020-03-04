package com.example.first.hw_adapter_03_03_20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.first.hw_adapter_03_03_20.pojo.Person;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> personList = new ArrayList<>();

    public PersonAdapter(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public void addPerson(Person person){
        personList.add(person);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_cell, parent, false);
                return new StudentViewHolder(view);

            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_cell, parent, false);
                return new FamilyViewHolder(view);

            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_cell, parent, false);
                return new FriendViewHolder(view);

            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_cell, parent, false);
                return new PersonViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (personList.get(position).getType().toLowerCase()) {
            case "student":
                return 0;
            case "family":
                return 1;
            case "friend":
                return 2;
            default:
                return 3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.name.setText(personList.get(position).getName());

        if(holder instanceof FriendViewHolder){
            ((FriendViewHolder) holder).phone.setText(personList.get(position).getPhone());
        }
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    class PersonViewHolder extends RecyclerView.ViewHolder{

        TextView name;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }

    class StudentViewHolder extends PersonViewHolder{

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class FamilyViewHolder extends PersonViewHolder{

        public FamilyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class FriendViewHolder extends PersonViewHolder{

        TextView phone;
        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}
