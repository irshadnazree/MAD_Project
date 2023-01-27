package ftmk.bitp3453.ftmkafee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class FirstActivity extends AppCompatActivity {

    TextView txtvwWelcome;
    EditText edtName, edtTblNo;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        txtvwWelcome = (TextView) findViewById(R.id.txtvwWelcome);
        edtName = (EditText) findViewById(R.id.edtTxtName);
        edtTblNo = (EditText) findViewById(R.id.edtTblNo);
    }

    public void fnGreet(View vw) {
        String strName = edtName.getText().toString();
        String strTblNo = edtTblNo.getText().toString();

        txtvwWelcome.setText("Hello and welcome " + strName + "! \nYou table number are " + strTblNo + ".");

        Intent intent = new Intent(this, SecondActivity.class);
        String strMsg = ((EditText) findViewById(R.id.edtTxtName)).getText().toString();
        intent.putExtra("varStr1", strMsg);
        String strNum = ((EditText) findViewById(R.id.edtTblNo)).getText().toString();
        intent.putExtra("varStr2", strNum);
        startActivity(intent);
    }

}