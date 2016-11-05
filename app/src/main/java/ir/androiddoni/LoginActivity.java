package ir.androiddoni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import ir.androiddoni.javaClass.Parent;

public class LoginActivity extends AppCompatActivity {

    EditText edt_username,edt_password;
    CheckBox chk_save;
    Button btn_login,btn_exit;
//test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_username=(EditText)findViewById(R.id.edt_username);
        edt_password=(EditText)findViewById(R.id.edt_password);
        chk_save=(CheckBox)findViewById(R.id.chk_save);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_exit=(Button)findViewById(R.id.btn_exit);

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=edt_username.getText().toString();
                String password=edt_password.getText().toString();

                if(username.equals("android") && edt_password.getText().toString().equals("1")){


                    Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);

                    startActivity(intent);


                    String package1=getPackageName();

                    Parent.alert(getApplicationContext());

                    finish();


                }
                else {

                    Toast.makeText(LoginActivity.this, "wrong username or password,try again", Toast.LENGTH_SHORT).show();

                }




            }
        });


        Log.e("LifeCycle","OnCreate");


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle","onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle","onDestroy");
    }
}
