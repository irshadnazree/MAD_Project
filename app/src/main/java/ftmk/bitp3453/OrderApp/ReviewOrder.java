package ftmk.bitp3453.OrderApp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewOrder extends AppCompatActivity {

    TextView viewOrder, viewTheUser, orderQuantity, totalPrice;
    Button update, payment;

    int oQuantity, nSand, nCof;
    double tPrice, pSand, pCof;

    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);

//        Intent intent = getIntent();
        userDetails detailsWeh = (userDetails) getIntent().getSerializableExtra("bawaDetails");

        setTitle("Order Review");
        viewTheUser = findViewById(R.id.viewUser);
        viewOrder = findViewById(R.id.viewOrder);
        orderQuantity = findViewById(R.id.orderQuantity);
        totalPrice = findViewById(R.id.totalPrice);
        payment = findViewById(R.id.btnPayment);
        update = findViewById(R.id.btnUpdate);

        viewTheUser.setText("\n\n Name : "+ detailsWeh.getName());

        Order odr = (Order) getIntent().getSerializableExtra("bawaOrder");
        viewOrder.setText("\n\n Quantity of Sandwich : "+ odr.getNumSandwich() + " piece(s)\n Quantity of Coffee: "+ odr.getNumCoffee() + " cup(s)");

        nSand = odr.getNumSandwich();
        nCof = odr.getNumCoffee();
        oQuantity = nSand + nCof;

        pSand = 2.5*nSand;
        pCof = 2*nCof;
        tPrice = pSand + pCof;

        orderQuantity.setText("\n\n Order Quantity: "+ oQuantity);
        totalPrice.setText("\n Total Price: RM"+ tPrice);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReviewOrder.this,"Thank you for ordering with us.", Toast.LENGTH_SHORT).show();

                double tpSandNo = pSand;
                double tpCofNo = pCof;

                Boolean checkInsertData = DB.insertReceipt(tpSandNo, tpCofNo);
                if(checkInsertData==true){
                    Toast.makeText(ReviewOrder.this,"Total Price Inserted.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ReviewOrder.this, "Failed to insert price, user might have existed.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                intent.putExtra("orderQty", oQuantity);
                intent.putExtra("totalPrice", tPrice);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
                startActivity(intent);
            }
        });

    }
}