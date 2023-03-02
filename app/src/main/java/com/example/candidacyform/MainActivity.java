package com.example.candidacyform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.lang.ref.Reference;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Context context;
    Button b;
    Member member;



    RadioButton male,female;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i = 0;


    TextInputEditText name,emailaddress,address,membership,age,dateofbirth,vision;

    String item;
    String item1;
    Spinner spinner;
    Spinner spinner1;



    String[] CivilStatus = {" Choose Civil Status","SINGLE", "MARRIED", "DIVORCED", "WIDOWED","OTHERS"};

    String[] ElectivePosition = {" Choose Elective Position"," DIRECTOR","AUDIT COMMITTEE","ELECTION COMMITTEE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ;//6 55//
        //FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //DatabaseReference = firebaseDatabase.getReference("Value");

        spinner = findViewById(R.id.status);
        spinner1 = findViewById(R.id.Xposition);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,CivilStatus);//9 13//
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,ElectivePosition);//9 13//
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);






        b = findViewById(R.id.submitform);
        member = new Member();
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        name = findViewById(R.id.Xname);
        emailaddress = findViewById(R.id.Xemailaddress);
        address = findViewById(R.id.Xaddress);
        membership = findViewById(R.id.Xmembership);
        age = findViewById(R.id.Xage);
        dateofbirth = findViewById(R.id.Xdateofbirth);
        vision = findViewById(R.id.Xvision);




        final FirebaseApp firebaseApp = FirebaseApp.initializeApp(MainActivity.this);


        reference = database.getInstance().getReference().child("Candidates");



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner = findViewById(R.id.status);
                spinner1 = findViewById(R.id.Xposition);

                spinner.setOnItemSelectedListener(MainActivity.this);
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,CivilStatus);//9 13//
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);

                ArrayAdapter arrayAdapter1 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,ElectivePosition);//9 13//
                arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(arrayAdapter1);




                final String Sname = name.getText().toString();
                final String Semail = emailaddress.getText().toString();
                final String Saddress = address.getText().toString();
                final String Smembership = membership.getText().toString()+"";
                final String Sage = age.getText().toString()+"";
                final String Sdob = dateofbirth.getText().toString()+"";
                final String Svision = vision.getText().toString()+"";
                final String Sitem = item;
                final String Sitem1 = item1;

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        SaveCandidates(item,item1);
                        //10 35

                        String m1 = male.getText().toString();
                        String m2 = female.getText().toString();




                        reference.child(Smembership).child("name").setValue(Sname);


                        reference.child(Smembership).child("email").setValue(Semail);


                        reference.child(Smembership).child("address").setValue(Saddress);


                        reference.child(Smembership).child("membership").setValue(Smembership);


                        reference.child(Smembership).child("age").setValue(Sage);


                        reference.child(Smembership).child("vision").setValue(Svision);


                        if ( item == "Choose Civil Status"){
                            Toast.makeText(MainActivity.this, "Please select a status", Toast.LENGTH_SHORT).show();
                        }else {
                            member.setCivilStatus(item);
                            reference.child(Smembership).child("civilstatus").setValue(member);

                            Toast.makeText(MainActivity.this, "value saved", Toast.LENGTH_SHORT).show();

                        }


                        if (male.isChecked()){
                            member.setGender(m1);
                            reference.child(Smembership).child("gender").setValue("Male");
                        }
                        else {
                            member.setGender(m2);
                            reference.child(Smembership).child("gender").setValue("Female");
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });








            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        item = spinner.getSelectedItem().toString();
        item1 = spinner1.getSelectedItem().toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    void SaveCandidates(String item, String item1){
        if ( item == "Choose Civil Status"){
            Toast.makeText(this, "Please select a status", Toast.LENGTH_SHORT).show();
        }else {
            member.setCivilStatus(item);

            Toast.makeText(this, "value saved", Toast.LENGTH_SHORT).show();

        }
        if (item1 == "Choose Elective Position"){
            Toast.makeText(this, "Please select a elective position", Toast.LENGTH_SHORT).show();
        }else {
            member.setElectivePosition(item1);

            Toast.makeText(this, "value saved", Toast.LENGTH_SHORT).show();
        }



    }




}