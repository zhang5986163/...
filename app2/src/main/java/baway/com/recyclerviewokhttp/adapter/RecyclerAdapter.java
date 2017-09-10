package baway.com.recyclerviewokhttp.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import baway.com.recyclerviewokhttp.Bean.Data;
import baway.com.recyclerviewokhttp.R;
import baway.com.recyclerviewokhttp.utils.OnItemonclicklinear;

/**
 * Created by YU on 2017/8/24.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Data.DataBean> list;
    private Context context;
    private OnItemonclicklinear onItemonclicklinear;

    public void setOnItemonclicklinear(OnItemonclicklinear onItemonclicklinear) {
        this.onItemonclicklinear = onItemonclicklinear;

    }

    public RecyclerAdapter(List<Data.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //加载布局。
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        view = LayoutInflater.from(context).inflate(R.layout.item, null);
        viewHolder = new myViewHolder(view);
        return viewHolder;
    }
    //赋值
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Data.DataBean bean=list.get(position);
//        name, occupation, age, introduction;
        final myViewHolder myViewHolder= (myViewHolder) holder;
        myViewHolder.occupation.setText(bean.getOccupation());
        myViewHolder.age.setText(bean.getUserAge()+"岁");
        myViewHolder.introduction.setText(bean.getIntroduction());
        myViewHolder.name.setText(bean.getUserName());
        Glide.with(context).load(bean.getUserImg()).into(myViewHolder.imageView);
        //监听事件回调
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemonclicklinear.onClickListener(myViewHolder.itemView,position);
                ObjectAnimator animator=ObjectAnimator.ofFloat(myViewHolder.itemView,"alpha",0.0f,1.0f).setDuration(1000);
                animator.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, occupation, age, introduction;
        ImageView imageView;

        public myViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
            occupation = (TextView) itemView.findViewById(R.id.occupation);
            introduction = (TextView) itemView.findViewById(R.id.introduction);
            imageView = (ImageView) itemView.findViewById(R.id.iamge);
        }
    }
}
