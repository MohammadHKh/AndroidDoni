package ir.androiddoni.Authentication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ir.androiddoni.R;

/**
 * Created by Android on 10/28/2016.
 */

public class Login {

    public static void sign_in(final Activity activity) {

        LayoutInflater inflater=LayoutInflater.from(activity);

        View view=inflater.inflate(R.layout.login_layout,null);

        AlertDialog.Builder aBuiler = new AlertDialog.Builder(activity);
       final EditText edt_username=(EditText)view.findViewById(R.id.edt_username);
        final EditText edt_password=(EditText)view.findViewById(R.id.edt_password);
        aBuiler.setView(view);

        aBuiler.setPositiveButton(activity.getString(R.string.login_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(activity, edt_username.getText().toString()+""+edt_password.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        aBuiler.setNeutralButton(activity.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        aBuiler.show();


    }


}
