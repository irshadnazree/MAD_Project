package ftmk.bitp3453.testsqlite02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    TextView tvGreet, sandwich, coffee;
    Button btnOrder;
    EditText numSandwich, numCoffee;

    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        sandwich = findViewById(R.id.sandwich);
        coffee = findViewById(R.id.coffee);
        btnOrder = findViewById(R.id.btnOrder);
        numSandwich = findViewById(R.id.numSandwich);
        numCoffee = findViewById(R.id.numCoffee);

        DB = new DBHelper(this);

//        userDetails usrdet = (userDetails) getIntent().getSerializableExtra("user");
//        Order order = (Order) getIntent().getSerializableExtra("bawaOrder");

//        Intent intent = getIntent();

//        String strName =intent.getStringExtra("bawaNama");
        userDetails bwkDetails = (userDetails) getIntent().getSerializableExtra("bawaDetails");
        tvGreet = findViewById(R.id.tvGreet);

        tvGreet.setText("Hello and Welcome, "+bwkDetails.getName()+"\n"+"\n");

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numSandwichNO = numSandwich.getText().toString();
                String numCoffeeNO = numCoffee.getText().toString();

                //String userID = DB.getID(usrdet.getName(),usrdet.getTableNo());

                Boolean checkInsertData = DB.insertOrderMade(numSandwichNO, numCoffeeNO);
                if(checkInsertData==true){
                    Toast.makeText(MenuActivity.this,"New Order Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MenuActivity.this, "Failed to insert order", Toast.LENGTH_SHORT).show();
                }

                //Intent intent = new Intent(getApplicationContext(), ReviewOrder.class);
                //intent.putExtra("usr", usrdet);

                Intent intent = new Intent(getApplicationContext(), ReviewOrder.class);

                Order order = new Order(numSandwichNO, numCoffeeNO);
                intent.putExtra("bawaOrder", order);
                intent.putExtra("bawaDetails", bwkDetails);
                startActivity(intent);

            }
        });

    }
}
