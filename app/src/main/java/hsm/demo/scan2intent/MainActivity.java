package hsm.demo.scan2intent;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    private BroadcastReceiver myReceiver;
    static String TAG="Barcode Intent Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView1);
    }

    @Override
    protected void onResume(){
        super.onResume();
        //Create an Intent Filter
        IntentFilter intentFilter = new IntentFilter("hsm.RECVRBI");
        myReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG, "codeId: \t" + intent.getStringExtra("codeId"));
                Log.d(TAG, "dataBytes\t" + Arrays.toString(intent.getByteArrayExtra("dataBytes")));
                String d = intent.getStringExtra("data");
                Log.d(TAG, "data: \t" + intent.getStringExtra("data"));
                Log.d(TAG, "timestamp: \t" + intent.getStringExtra("timestamp"));
                Log.d(TAG, "aimId: \t" + intent.getStringExtra("aimId"));
                Log.d(TAG, "version: \t" + intent.getIntExtra("version", -1));
                Log.d(TAG, "charset: \t" + intent.getStringExtra("charset"));
                Log.d(TAG, "scanner: \t" + intent.getStringExtra("scanner"));
                if(d!=null && d.length()>0){
                    textView.setText(d);
                }
            }
        };
        this.registerReceiver(myReceiver, intentFilter);
    }
    @Override
    protected void onPause(){
        super.onPause();
        this.unregisterReceiver(this.myReceiver);
    }
}
