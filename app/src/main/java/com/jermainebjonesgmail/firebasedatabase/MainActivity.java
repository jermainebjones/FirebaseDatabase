package com.jermainebjonesgmail.firebasedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText name,class_;
    private Button send;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        name = (EditText)findViewById(R.id.name);
        class_ = (EditText)findViewById(R.id.class_);

        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudents();
            }
        });
    }

    public void addStudents() {

        String studentName = name.getText().toString();
        String studentClass = class_.getText().toString();

        if (!TextUtils.isEmpty(studentName) && !TextUtils.isEmpty(studentClass)) {

            String id = databaseReference.push().getKey();

            Students students = new Students(id,studentName,studentClass);

            databaseReference.child(id).setValue(students);
            name.setText("");
            class_.setText("");

        }
        else {
            Toast.makeText(MainActivity.this, "Please type the Students Name or Class", Toast.LENGTH_LONG).show();
        }

    }


}
