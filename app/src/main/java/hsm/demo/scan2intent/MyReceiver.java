package hsm.demo.scan2intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;

import java.util.Arrays;

/**
 * add to manifest for application:
 *
 <receiver android:name=".MyReceiver">
 <intent-filter>
 <action android:name="hsm.RECVRBI1" />
 </intent-filter>
 </receiver>
 */

public class MyReceiver extends BroadcastReceiver
{
    static String TAG="Scan2Intent-MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String keys = Arrays.toString(intent.getExtras().keySet().toArray());
        // [codeId, dataBytes, data, timestamp, aimId, version, charset, scanner]
        String[] mKeys=keys.split(" ");
        for (String s:mKeys) {
            Log.d(TAG, "key: "+s);
        }
        Log.d(TAG, "codeId: \t" + intent.getStringExtra("codeId"));
        Log.d(TAG, "dataBytes\t" + Arrays.toString(intent.getByteArrayExtra("dataBytes")));
        Log.d(TAG, "data: \t" + intent.getStringExtra("data"));
        Log.d(TAG, "timestamp: \t" + intent.getStringExtra("timestamp"));
        Log.d(TAG, "aimId: \t" + intent.getStringExtra("aimId"));
        Log.d(TAG, "version: \t" + intent.getIntExtra("version", -1));
        Log.d(TAG, "charset: \t" + intent.getStringExtra("charset"));
        Log.d(TAG, "scanner: \t" + intent.getStringExtra("scanner"));

    }
    /*
    mMap->
        value[0] = "b"
        value[1] = {byte[5]@4388}
        value[2] = "10110"
        value[3] = "2016-10-15T05:58:05.097+2:00"
        value[4] = "]A0"
        value[5] = {Integer@4392} "1"
        value[6] = "ISO-8859-1"
        value[7] = "dcs.scanner.imager"
     */
}