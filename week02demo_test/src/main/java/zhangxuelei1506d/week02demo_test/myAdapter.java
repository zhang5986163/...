package zhangxuelei1506d.week02demo_test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * date 2017/9/10
 * author:张学雷(Administrator)
 * functinn:
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    private Context context;
    private List<myBean.美女Bean> list;
    private List<Integer> heights;

    public myAdapter(Context context, List<myBean.美女Bean> list,List<Integer> heights) {
        this.context = context;
        this.list = list;
        this.heights=heights;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item, null);
        myViewHolder holder = new myViewHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        myBean.美女Bean bean = list.get(position);
//这步骤是用imageloder加载图片的
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(config);
        ImageLoader.getInstance().displayImage(list.get(position).img, holder.imageView);






    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView;


        public myViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    monItemClickListener.onItemclic(v,getLayoutPosition()+"");
                }
            });
        }
    }







         //点击事件recycleview点击事件的接口
         interface onItemClickListener{
             /**
              * 抽象方法，当recycleview某个被点击的时候回调
              * @param view  点击的item对象
              * @param data  点击时的数据
              */
             void onItemclic(View view,String data);

         }
         //创建接口
         private onItemClickListener monItemClickListener;

         //设置recycleview的某个监听
         public  void setOnItemClickListener(onItemClickListener onItemClickListener){
             monItemClickListener=onItemClickListener;

         }

}
