package zhangxuelei1506d.okhttp_fengzhuang;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String json_path = "http://api2.hichao.com/stars?category=%E5%85%A8%E9%83%A8&pin=&ga=%2Fstars&flag=&gv=63&access_token=&gi=862949022047018&gos=5.2.3&p=2013022&gc=xiaomi&gn=mxyc_adr&gs=720x1280&gf=android&page=2";
    private String Login_path = "http://169.254.53.96:8080/web/LoginServlet";
    private String Picture_path = "https://10.url.cn/eth/ajNVdqHZLLAxibwnrOxXSzIxA76ichutwMCcOpA45xjiapneMZsib7eY4wUxF6XDmL2FmZEVYsf86iaw/";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView);

    }

    /**
     * 通过点击事件执行okhttp里封装的根据网址,获取字符串的逻辑操作.
     *
     * @param view
     */
    public void okhttp_json(View view) {

        OKhttpManager.getInstance().asyncJsonStringByURL("http://publicobject.com/helloworld.txt", new OKhttpManager.Func1() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
            }
        });

    }

    //像服务器提交账号及密码
    public void okhttp_table(View view) {
        HashMap<String,String> map=new HashMap<>();
        map.put("qq","10000");
        map.put("pwd","abcde");
        OKhttpManager.getInstance().sendComplexForm("http://169.254.53.96:8080/web/LoginServlet", map, new OKhttpManager.Func1() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
            }
        });
    }

    //下载图片
    public void okhttp_picture(View view) {

        OKhttpManager.getInstance().downImage("http://a3.topitme.com/0/1c/12/1128107705fd5121c0l.jpg", new OKhttpManager.Func2() {
            @Override
            public void onResponse(byte[] result) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
                mImageView.setImageBitmap(bitmap);


            }
        });



    }
}
