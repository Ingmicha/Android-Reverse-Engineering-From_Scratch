package com.flipcortex.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM = "com.flipcortex.helloworld.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.buttonSend);


        Intent i = new Intent(getApplicationContext(),MyService.class);

        startService(i);

        btn.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
//                EditText et = (EditText) findViewById(R.id.editTextListItem);
//                TextView tv = (TextView) findViewById(R.id.textView);
//                tv.setText(et.getText());
//
//                Intent i = new Intent(getApplicationContext(),DisplayListItems.class);
//                EditText et = (EditText) findViewById(R.id.editTextListItem);
//                String listItem = et.getText().toString();
//                i.putExtra(EXTRA_ITEM, listItem);
//                startActivity(i);

                Intent i = new Intent(getApplicationContext(),DisplayListItems.class);
                EditText et = (EditText) findViewById(R.id.editTextListItem);
                String listItem = et.getText().toString();
                if(listItem!=null){
                    ContentValues values = new ContentValues();
                    values.put(ListProvider.LISTITEM, listItem);
                    Uri uri = getContentResolver().insert(ListProvider.CONTENT_URI, values);
                    startActivity(i);
                }
            }
        });

    }

    private void requestPermissions(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if ((ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
                    ||(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED)) {
                requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_CONTACTS},0);
            }
        }
    }

    public void postItem(View view){
        EditText et = (EditText) findViewById(R.id.editTextListItem);
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(et.getText());

    }
}
