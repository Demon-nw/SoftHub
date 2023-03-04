package cc.ficc.showlist.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

import cc.ficc.showlist.ICallback;
import cc.ficc.showlist.R;
import cc.ficc.showlist.ShowView;
import cc.ficc.showlist.bean.AppBean;

public class VerticalDisplay extends ShowView implements ShowView.Subassembly {
    int i = 1;
    private ICallback iCallback;

    public VerticalDisplay(Context context) {
        super(context);
        init(this);
        var linearLayoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(linearLayoutManager);
    }

    @Override
    public void loadData(ArrayList<AppBean> appBeans, ICallback iCallback) {
        this.iCallback = iCallback;
        setAdapter(new ShowView.Adapter(appBeans));
    }

    @Override
    public View onCreateItemView() {
        return LayoutInflater.from(getContext())
                .inflate(R.layout.show_item_vertical, this, false);
    }

    @Override
    public void convert(@NonNull BaseViewHolder baseViewHolder, AppBean appBean) {
        LinearLayout linearLayout = baseViewHolder.findView(R.id.progress_vertical);
        ImageView imageView = baseViewHolder.findView(R.id.imageView_vertical);
        Glide.with(getContext())
                .load(appBean.getAppImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(imageView);
        baseViewHolder.setText(R.id.textView_vertical, i + "");
        baseViewHolder.setText(R.id.textView2_vertical, appBean.getTitle());
        baseViewHolder.setText(R.id.textView3_vertical, appBean.getSubTitle());
        baseViewHolder.setText(R.id.textView4_vertical, appBean.getVersion());
        linearLayout.setOnClickListener(view -> {
            iCallback.itemClicked(view, appBean.getDownloadLink());
        });
        i++;
    }
}
