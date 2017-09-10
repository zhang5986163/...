package zhangxuelei1506d.recycle_matchitemdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * date 2017/9/8
 * author:张学雷(Administrator)
 * functinn:抽取基类的原则
 * 1.子类共有，且实现相同的逻辑，抽取到基类中
 * 2.子类共有，但实现不同的逻辑，以抽象方法的形式定义到基类中。
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel model);
}
