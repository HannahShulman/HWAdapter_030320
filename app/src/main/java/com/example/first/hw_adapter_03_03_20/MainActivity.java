package com.example.first.hw_adapter_03_03_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.first.hw_adapter_03_03_20.pojo.Family;
import com.example.first.hw_adapter_03_03_20.pojo.Friend;
import com.example.first.hw_adapter_03_03_20.pojo.Person;
import com.example.first.hw_adapter_03_03_20.pojo.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameEt, phoneET;
    RadioGroup typeRg;
    Button addPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        RecyclerView personList = findViewById(R.id.person_list);

        //set layoutmanager to set orientation of cells layout
        personList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        ArrayList<Person> list = new ArrayList<Person>();
        final PersonAdapter adapter = new PersonAdapter(list);

        //attach adapter to recyclerview
        personList.setAdapter(adapter);

        nameEt = findViewById(R.id.name_et);
        phoneET = findViewById(R.id.phone_et);
        addPerson = findViewById(R.id.add_person);
        typeRg = findViewById(R.id.type_rg);

        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person;
                switch (typeRg.getCheckedRadioButtonId()){
                    case  R.id.student_rb:
                        person = new Student("Math", 59.0);
                        addPerson(person , adapter);
                        break;
                    case R.id.friend_rb:
                        person = new Friend();
                        addPerson(person , adapter);
                        break;
                    case R.id.family_rb:
                        person = new Family();
                        addPerson(person , adapter);
                        break;
                    default:
                        Toast.makeText(context , "Please select a valid type" , Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    void addPerson(Person person , PersonAdapter adapter) {
        person.setName(nameEt.getText().toString());
        person.setPhone(phoneET.getText().toString());
        adapter.addPerson(person);
    }
}
