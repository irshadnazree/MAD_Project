package ftmk.bitp3453.OrderApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText name, phoneNo;

    DBHelper DB;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DB = new DBHelper(LoginActivity.this);

        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneNo);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString().trim();
                String phoneNoTXT = phoneNo.getText().toString().trim();

                if (nameTXT.equals("") || phoneNoTXT.equals("")) {
                    Toast.makeText(LoginActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    // check name and phone number if they exist/equal in the database  - if yes login to the app
                    Boolean userPassCheckResult = DB.checkUserDetails(nameTXT, phoneNoTXT);
                    if (userPassCheckResult==true) {
                        int user_no = DB.fetch_phoneNo(phoneNoTXT);
                        Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                        userDetails detailDia = new userDetails(nameTXT, phoneNoTXT);
                        intent.putExtra("bawaDetails", detailDia);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
