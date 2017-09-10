package zhangxuelei1506d.recycle_matchitemdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.attr.type;

/**
 * 实现RecycleView多布局效果
 * 1搭建环境（添加依赖，添加控件，初始化控件）
 * 2初始化数据
 * 3创建适配器
 * 4设置适配器，还有布局管理器
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataModel> list;
    private DemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        //初始化数据
        initData();

        adapter = new DemoAdapter(this, list);
        //设置适配器
        recyclerView.setAdapter(adapter);

        //设置布局管理器，否则无法显示

        //参数1：上下文 2：规定是横着还是竖着 3：正着排列还是倒着排列
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false) {
        });

        
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置listview和gridView效果混排，无论一行两列还是一行一列都是GridViewManager，做了一个监听器
        //让其显示显示是一行一列还是一行两列
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //拿一下当前itme是什么类型type
                int type = recyclerView.getAdapter().getItemViewType(position);
                //根据类型，决定GridLayoutManager，一行占用几列
                if(type==DataModel.TYPE_THREE){
                    return manager.getSpanCount();

                }else{
                    return 1;
                }
            }
        });

    }

    int colors[] = {android.R.color.holo_blue_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light};

    /**
     * Type:分类型
     * String name
     * String content
     * color
     */
    private void initData() {
        //创建一个集合存放bean类
        list = new ArrayList<DataModel>();
        //创建20条item
        for (int i = 0; i < 20; i++) {
           // int type = (int) (Math.random() * 3 + 1);

            //listview和GridView效果混排，数据类型重新划分，真是开发中拿数据类型就可以了
            int type;
            if(i<5||(i>15&&i<20)){
                type=1;

            }else if(i<10||i>20){
                type=2;
            }else{
                type=3;
            }


            //创建bean类
            DataModel data = new DataModel();

            //实际开发，则是解析服务器拿到的数据
            data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "Name" + i;
            data.content = "Content" + i;
            data.contentColor = colors[(type + 1) % 2];

            list.add(data);
        }





    }
}
