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

import com.example.first.hw_adapter_03_03_20.pojo.Family;
import com.example.first.hw_adapter_03_03_20.pojo.Friend;
import com.example.first.hw_adapter_03_03_20.pojo.Person;
import com.example.first.hw_adapter_03_03_20.pojo.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameEt, phoneET, type_et;
    Button addPerson;
    RadioButton familyBtn, friendBtn, studentBtn, checkedBtn;
    RadioGroup radioG;

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
        addPerson = findViewById(R.id.add_person);
        radioG =findViewById(R.id.radioG1);
        familyBtn =findViewById(R.id.radio_family);
        friendBtn =findViewById(R.id.radio_friends);
        studentBtn =findViewById(R.id.radio_students);



        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person;
           //     switch (type_et.getText().toString().toLowerCase()){
           //         case  "s":
             //           person = new Student("Math", 59.0);
           //             break;
           //         case "f":
           //             person = new Friend();
            //            break;
            //        case "fa":
            //            person = new Family();
            //            break;
            //        default:
            //            person = new Student("history", 100);
             //   }

                // get selected radio button from radioGroup
                int selectedId = radioG.getCheckedRadioButtonId();
                checkedBtn = findViewById(selectedId);

                if (checkedBtn == familyBtn) {
                    person = new Family();
                }  else if ( checkedBtn == friendBtn){
                    person = new Friend();
                } else {
                    person = new Student("Math", 100);
                }

             person.setName(nameEt.getText().toString());
             person.setPhone(phoneET.getText().toString());
             adapter.addPerson(person);
            }
        });


    }
}
