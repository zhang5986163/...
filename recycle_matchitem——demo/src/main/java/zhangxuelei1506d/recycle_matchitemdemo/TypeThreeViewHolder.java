package zhangxuelei1506d.recycle_matchitemdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * date 2017/9/8
 * author:张学雷(Administrator)
 * functinn:
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentimage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        name= (TextView) itemView.findViewById(R.id.name);
        content=(TextView) itemView.findViewById(R.id.content);
        avatar= (ImageView) itemView.findViewById(R.id.avatar);
        contentimage= (ImageView) itemView.findViewById(R.id.contentImage);

    }

    @Override
    public void bindHolder(DataModel model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
        contentimage.setBackgroundResource(model.contentColor);

    }
}
