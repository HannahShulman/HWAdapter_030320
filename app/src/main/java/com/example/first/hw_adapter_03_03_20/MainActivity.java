package com.example.first.hw_adapter_03_03_20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.first.hw_adapter_03_03_20.pojo.Family;
import com.example.first.hw_adapter_03_03_20.pojo.Friend;
import com.example.first.hw_adapter_03_03_20.pojo.Person;
import com.example.first.hw_adapter_03_03_20.pojo.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameEt, phoneET, type_et;
    Button addPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView personList = findViewById(R.id.person_list);

        //set layoutmanager to set orientation of cells layout
        personList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        ArrayList<Person> list = new ArrayList<Person>();
        final PersonAdapter adapter = new PersonAdapter(list);

        //attach adapter to recyclerview
        personList.setAdapter(adapter);

        nameEt = findViewById(R.id.name_et);
        phoneET = findViewById(R.id.phone_et);
//        type_et = findViewById(R.id.type_et);
        addPerson = findViewById(R.id.add_person);

        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person;

                RadioGroup radioGroup = findViewById(R.id.type_radio); //taking group of radio
                int selectedId = radioGroup.getCheckedRadioButtonId(); //checking, which one button was checked, getting id button (NOT id that you wrote in XML)
                RadioButton radioButton = (RadioButton) findViewById(selectedId); //taking special button by id

//                Toast.makeText(MainActivity.this, radioButton.getText().toString(), Toast.LENGTH_LONG).show(); //Testing code

                switch (radioButton.getText().toString().toLowerCase()){
                    case  "s":
                    case "student":
                        person = new Student("Math", 59.0);
                        break;
                    case "f":
                    case "friend":
                        person = new Friend();
                        break;
                    case "fa":
                    case "family":
                        person = new Family();
                        break;
                    default:
                        person = new Friend();
                }
             person.setName(nameEt.getText().toString());
             person.setPhone(phoneET.getText().toString());
             adapter.addPerson(person);
            }
        });


    }
}
