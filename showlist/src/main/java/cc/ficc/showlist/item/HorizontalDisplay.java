package cc.ficc.showlist.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import cc.ficc.showlist.R;
import cc.ficc.showlist.ShowView;
import cc.ficc.showlist.bean.AppBean;

public class HorizontalDisplay extends ShowView implements ShowView.Subassembly{
    public HorizontalDisplay(Context context){
        super(context);
        var linearLayoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(linearLayoutManager);
    }

    @Override
    public View onCreateItemView() {
        var view = LayoutInflater.from(getContext())
                .inflate(R.layout.show_item_horizontal1,null,false);
        return view;
    }

    @Override
    public void convert(@NonNull BaseViewHolder baseViewHolder, AppBean appBean) {
        ImageView imageView = baseViewHolder.findView(R.id.imageView_horizontal1);
        Glide.with(getContext())
                .load(appBean.getAppImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(imageView);
        baseViewHolder.setText(R.id.textView_horizontal1,appBean.getTitle());
        baseViewHolder.setText(R.id.textView2_horizontal1,appBean.getSubTitle());
    }
}
