package zhangxuelei1506d.week02demo_test;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Random randow;
    private myAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<myBean.美女Bean> list;
    private int page = 1;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boolean content = Utils4.isContent(this);
        if (content == true) {
            Toast.makeText(this, "网络已连接", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "网络未连接", Toast.LENGTH_SHORT).show();
        }


        recyclerView = (RecyclerView) findViewById(R.id.recycle_View);
        linearLayoutManager = new LinearLayoutManager(this);

        OkHttpManager.getInstance().asyncJsonStringByURL("http://c.3g.163.com/recommend/getChanListNews?channel=T1456112189138&size=20&passport=&devId=1uuFYbybIU2oqSRGyFrjCw%3D%3D&lat=%2F%2FOm%2B%2F8ScD%2B9fX1D8bxYWg%3D%3D&lon=LY2l8sFCNzaGzqWEPPgmUw%3D%3D&version=9.0&net=wifi&ts=1464769308&sign=bOVsnQQ6gJamli6%2BfINh6fC%2Fi9ydsM5XXPKOGRto5G948ErR02zJ6%2FKXOnxX046I&encryption=1&canal=meizu_store2014_news&mac=sSduRYcChdp%2BBL1a9Xa%2F9TC0ruPUyXM4Jwce4E9oM30%3D", new OkHttpManager.Func1() {


            @Override
            public void onResponse(String result) {

                list = new ArrayList<myBean.美女Bean>();
                Gson gson = new Gson();
                final myBean myBean = gson.fromJson(result, myBean.class);
                list = myBean.美女;
                List<Integer> heights = new ArrayList<Integer>();
                randow = new Random();
                for (int i = 0; i < list.size(); i++) {

                    heights.add(randow.nextInt(200) + 200);

                }

                adapter = new myAdapter(MainActivity.this, list, heights);


                recyclerView.setAdapter(adapter);
                //刷新适配器
                adapter.notifyDataSetChanged();
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));




                adapter.setOnItemClickListener(new myAdapter.onItemClickListener() {
                    @Override
                    public void onItemclic(View view, String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }



}
