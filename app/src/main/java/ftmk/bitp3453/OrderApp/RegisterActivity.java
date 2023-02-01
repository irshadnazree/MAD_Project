package ftmk.bitp3453.OrderApp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    EditText name, phoneNo;
    Button insert;

    DBHelper DB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initialise everything - editText + buttons + dbHelper
        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneNo);

        insert = findViewById(R.id.btnInsert);

        DB = new DBHelper(this);
        //-------------------------------------------


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String phoneNoTXT = phoneNo.getText().toString();


                Boolean checkInsertData = DB.insertUserData(nameTXT, phoneNoTXT);
                if(checkInsertData==true){
                    Toast.makeText(RegisterActivity.this,"New Entry Inserted.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Failed to insert entry, user might have existed.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                userDetails usrdetail = new userDetails(nameTXT, phoneNoTXT);
                intent.putExtra("user", usrdetail);
                startActivity(intent);

//                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//                String strMsg = ((EditText) findViewById(R.id.name)).getText().toString();
//                intent.putExtra("name", strMsg);
//
//                startActivity(intent);
            }
        });
    }
}