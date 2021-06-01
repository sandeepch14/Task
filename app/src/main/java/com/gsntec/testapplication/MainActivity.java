package com.gsntec.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etext,numtext;
    Button btsave;
    RecyclerView recyclerView;
    List<Users> itemlist = new ArrayList<>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etext = findViewById(R.id.et_text);
        numtext = findViewById(R.id.numb_text);
        btsave =findViewById(R.id.bt_save);
        recyclerView = findViewById(R.id.recycler_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new CustomAdapter(itemlist);
        recyclerView.setAdapter(adapter);

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em =etext.getText().toString().trim();
                String n = numtext.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String numberPattern ="(0/91)?[7-9][0-9]{9}";
                //String numberPattern = "^\\+[0-9]{10,13}$";

                if (em.matches(emailPattern) && em.length() > 0)
                {
                    if(n.matches(numberPattern) && n.length()>0){
                        try {
                            String string = etext.getText().toString();
                            String string1 = numtext.getText().toString();

                            Users u = new Users(string,string1);
                            itemlist.add(u);

                            numtext.setText("");
                            etext.setText("");
                            adapter.notifyItemInserted(itemlist.size()-1);
                        } catch (NumberFormatException e) {
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Invalid Number", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    }