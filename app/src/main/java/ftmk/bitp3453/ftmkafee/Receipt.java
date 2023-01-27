package ftmk.bitp3453.ftmkafee;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.text.BreakIterator;

import ftmk.bitp3453.ftmkafee.databinding.ActivityReceiptBinding;

public class Receipt extends AppCompatActivity {

    TextView txtViewItem, txtViewPrice;
    TextView txtViewName, txtViewTblNo;
    EditText edtQty1, edtQty2, edtQty3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        edtQty1 = (EditText) findViewById(R.id.tvQty1);
//        edtQty2 = (EditText) findViewById(R.id.tvQty2);
//        edtQty3 = (EditText) findViewById(R.id.tvQty3);

//        txtViewName = (TextView) findViewById(R.id.txtVwName);
//        txtViewTblNo = (TextView) findViewById(R.id.txtViewTblNo);
//        txtViewItem = (TextView) findViewById(R.id.txtVwItem);
//        txtViewPrice = (TextView) findViewById(R.id.txtVwPrice);
    }

    public void fnPay(View vw) {
        Integer strItemQty = Integer.valueOf(edtQty1.getText().toString()) + Integer.valueOf(edtQty2.getText().toString()) + Integer.valueOf(edtQty3.getText().toString());
        double burger1 = Integer.valueOf(edtQty1.getText().toString()) * 3.5;
        double burger2 = Integer.valueOf(edtQty2.getText().toString()) * 2.5;
        double burger3 = Integer.valueOf(edtQty3.getText().toString()) * 5.5;

        double strPrice = burger1 + burger2 + burger3;

//        txtViewName.setText("Customer Name: " + strVwName);
//        txtViewTblNo.setText("Table Number: " + strVwTblNo);
        txtViewItem.setText("Total item: " + strItemQty);
        txtViewPrice.setText("Total price to pay: RM" + strPrice);

        Toast.makeText(getApplicationContext(), "Thank you! See ya!", Toast.LENGTH_SHORT).show();
    }

}