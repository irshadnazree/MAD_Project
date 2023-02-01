package ftmk.bitp3453.testsqlite02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import ftmk.bitp3453.testsqlite02.databinding.ActivityUserProfileBinding;

public class UserProfile extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    ImageView imgVwPic;
    TextView tvGreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        actionBarDrawerToggle.syncState();

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.nav_menu);
        imgVwPic = findViewById(R.id.imgVwProfile);
        Intent intent = getIntent();

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

        String strMsg = intent.getStringExtra("varStr1");
        tvGreet = findViewById(R.id.tvGreet);
        tvGreet.setText("Welcome to your profile!");
    }

    public void fnTakePic(View vw) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      tvGreet.setText(tvGreet.getText().toString() + "\n\nThis is your picture hehehe");
                                  }
                              }
                );
            }
        };

        Thread thr = new Thread(run);
        thr.start();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imgVwPic.setImageBitmap(bp);
    }
}