package zhangxuelei1506d.week02demo_test;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * date 2017/9/10
 * author:张学雷(Administrator)
 * functinn:
 */

public class Utils4 {


    public static boolean isContent(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {

            return true;
        }


        return false;
    }
}
