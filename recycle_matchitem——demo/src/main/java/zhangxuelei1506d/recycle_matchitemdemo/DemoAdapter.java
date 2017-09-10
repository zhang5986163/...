package zhangxuelei1506d.recycle_matchitemdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * date 2017/9/8
 * author:张学雷(Administrator)
 * functinn:RecycleView多布局的适配器
 * 1.创建一个类继承recycleView的adapter
 * 2.定义RecycleView.ViewHolder以方便多布局
 * 3.创建三种类型的Item布局及ViewHolder
 * 4.使用getItemViewType
 * 5.在OnCreateViewHoLder和OnBindViewHolder进行数据的判断加载
 *
 */
public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //布局填充器
    private final LayoutInflater layoutInflater;
    private List<DataModel> mlist = new ArrayList<>();

    public DemoAdapter(Context context, ArrayList<DataModel> list) {
        layoutInflater = LayoutInflater.from(context);
        mlist.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(layoutInflater.inflate(R.layout.item_type_one, parent, false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(layoutInflater.inflate(R.layout.item_type_two, parent, false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(layoutInflater.inflate(R.layout.item_type_three, parent, false));
        }

        return null;
    }

    //根据不同的position位置，返回不同类型
    @Override
    public int getItemViewType(int position) {
        return mlist.get(position).type;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        switch (getItemViewType(position)) {
//            case 1:
//                TypeOneViewHolder holderOne = (TypeOneViewHolder) holder;
//                holderOne.name.setText(mlist.get(position).name);
//                holderOne.avatar.setImageResource(mlist.get(position).avatarColor);
//                break;
//            case 2:
//                TypeTwoViewHolder holderTwo = (TypeTwoViewHolder) holder;
//                holderTwo.name.setText(mlist.get(position).name);
//                holderTwo.avatar.setImageResource(mlist.get(position).avatarColor);
//                holderTwo.content.setText(mlist.get(position).content);
//                break;
//            case 3:
//                TypeThreeViewHolder holderTree = (TypeThreeViewHolder) holder;
//                holderTree.name.setText(mlist.get(position).name);
//                holderTree.avatar.setImageResource(mlist.get(position).avatarColor);
//                holderTree.content.setText(mlist.get(position).content);
//                holderTree.contentimage.setImageResource(mlist.get(position).contentColor);
//                break;
//        }

        ((TypeAbstractViewHolder)holder).bindHolder(mlist.get(position));

    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }
}