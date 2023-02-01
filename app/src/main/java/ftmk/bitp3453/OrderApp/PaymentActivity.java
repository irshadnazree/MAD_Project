package ftmk.bitp3453.OrderApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toast.makeText(PaymentActivity.this,"See you again!", Toast.LENGTH_SHORT).show();
    }
}