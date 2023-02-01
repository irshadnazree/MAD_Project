package ftmk.bitp3453.testsqlite02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Let's get started!", Toast.LENGTH_SHORT).show();
    }

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    TextView mainTitle;
    Button pgRegister, pgLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        actionBarDrawerToggle.syncState();

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.nav_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                switch (item.getItemId()) {
                    case R.id.nav_main_activity:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_profile_activity:
                        intent = new Intent(getApplicationContext(), UserProfile.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_logout:
                        Toast.makeText(getApplicationContext(), "You are logged out! See ya!", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        mainTitle = findViewById(R.id.mainTitle);
        pgRegister = findViewById(R.id.pgRegister);
        pgLogin = findViewById(R.id.pgLogin);

        pgRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);

            }
        });

        pgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}