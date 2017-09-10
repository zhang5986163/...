package zhangxuelei1506d.okhttp_lanjieqi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp底层网络请求用的是socket，长连接
 */
public class MainActivity extends AppCompatActivity {
    private String Path = "http://publicobject.com/helloworld.txt ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 根据点击事件使用okhttp拦截器
     */

    public void interceptor(View view) {

        new Thread() {
            @Override
            public void run() {
                try {
                    //建立okhttpClient对象时传入拦截器对象
                    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
                    OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();

                    Request request = new Request.Builder().url(Path).build();

                    Response response = client.newCall(request).execute();

                    String string = response.body().string();

                    System.out.println(string);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    /**
     * 根据点击事件使用okhttp，网络拦截器
     */

    public void interceptorNetWork(View view) {
        new Thread() {
            @Override
            public void run() {
                try {//建立okhttp对象传入拦截器

                    //缓存拦截器：注意有两个,我们导包是用自己的，不要弄错

                    OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new CacheInterecepor()).build();

                    Request request = new Request.Builder().url(Path).build();

                    Response response = client.newCall(request).execute();

                    String string = response.body().string();
                    System.out.println(string);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
