package ftmk.bitp3453.testsqlite02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    TextView tvGreet, sandwich, coffee;
    Button btnUpdate;
    EditText numSandwich, numCoffee;

    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        sandwich = findViewById(R.id.sandwich);
        coffee = findViewById(R.id.coffee);
        btnUpdate = findViewById(R.id.btnUpdate);
        numSandwich = findViewById(R.id.numSandwich);
        numCoffee = findViewById(R.id.numCoffee);

//        numSandwich = (EditText) findViewById(R.id.numSandwich);
//        numCoffee = (EditText) findViewById(R.id.numCoffee);

        DB = new DBHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String numSandNo = String.valueOf(numSandwich);
//                String numCofNo = String.valueOf(numCoffee);
                String numSandNo = numSandwich.getText().toString();
                String numCofNo = numCoffee.getText().toString();

                Boolean checkUpdateOrder = Boolean.valueOf(DB.updateOrder(numSandNo, numCofNo));
                if(checkUpdateOrder==true)
                    Toast.makeText(UpdateActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(UpdateActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), ReviewOrder.class);
                Order odrdetail = new Order(numSandNo, numCofNo);
                intent.putExtra("order", odrdetail);
                startActivity(intent);
            }
        });
    }
}