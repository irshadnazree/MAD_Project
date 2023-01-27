package ftmk.bitp3453.ftmkafee;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Vector;

import ftmk.bitp3453.ftmkafee.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySecondBinding binding;
    private OrderList order;
    private Vector<OrderList> orders;
    private OrderAdapter adapter;

    TextView txtViewItem, txtViewPrice;
    EditText edtQty1, edtQty2, edtQty3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnShow.setOnClickListener(this::fnShowOrder);

//        Kalau nak guna SQLITE
//        Studentdb attendance = new Studentdb(getApplicationContext());
//        ArrayList<OrderList> studentArrayList = (ArrayList<OrderList>) attendance.fnGetAllOrder();
//
//        if(studentArrayList.isEmpty()) {
//            orders = new Vector<>();
//        }
//        else {
//            orders = new Vector<OrderList>(studentArrayList);
//        }
//        adapter = new OrderAdapter(getLayoutInflater(), orders);

        orders = new Vector<>();
        adapter = new OrderAdapter(getLayoutInflater(), orders);

        binding.rcvMenu.setAdapter(adapter);
        binding.rcvMenu.setLayoutManager(new LinearLayoutManager(this));

//        kalau nak display quantity dgn price
//        edtQty1 = (EditText) findViewById(R.id.tvQty1);
//        edtQty2 = (EditText) findViewById(R.id.tvQty2);
//        edtQty3 = (EditText) findViewById(R.id.tvQty3);

//        txtViewItem = (TextView) findViewById(R.id.txtVwItem);
//        txtViewPrice = (TextView) findViewById(R.id.txtVwPrice);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_second);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    private void fnShowOrder(View view) {
//        String Burger1 = binding.edtBurger1.getText().toString();
        String QtyBurger1 = binding.tvQty1.getText().toString();
//        String Burger2 = binding.edtBurger2.getText().toString();
        String QtyBurger2 = binding.tvQty2.getText().toString();
//        String Burger3 = binding.edtBurger3.getText().toString();
        String QtyBurger3 = binding.tvQty3.getText().toString();

//        order = new OrderList(Burger1, QtyBurger1, Burger2, QtyBurger2, Burger3, QtyBurger3);
        order = new OrderList(QtyBurger1, QtyBurger2, QtyBurger3);

        orders.add(order);
        adapter.notifyItemInserted(orders.size());
    }

    public void fnGoNext(View view) {
        Intent intent = new Intent(getApplicationContext(), Receipt.class);
        startActivity(intent);
    }
}