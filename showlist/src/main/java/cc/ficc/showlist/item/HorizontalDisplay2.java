package cc.ficc.showlist.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

import cc.ficc.showlist.ICallback;
import cc.ficc.showlist.R;
import cc.ficc.showlist.ShowView;
import cc.ficc.showlist.bean.AppBean;

public class HorizontalDisplay2 extends ShowView implements ShowView.Subassembly {
    private ICallback iCallback;

    public HorizontalDisplay2(Context context) {
        super(context);
        init(this);
        var linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
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
                .inflate(R.layout.show_item_horizontal2, this, false);
    }

    @Override
    public void convert(@NonNull BaseViewHolder baseViewHolder, AppBean appBean) {
        ImageView imageView = baseViewHolder.findView(R.id.imageView_horizontal2);
        ImageView imageView1 = baseViewHolder.findView(R.id.imageView2_horizontal2);
        LinearLayout linearLayout = baseViewHolder.findView(R.id.progress_horizontal2);
        Glide.with(getContext())
                .load(appBean.getMainImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(imageView);
        Glide.with(getContext())
                .load(appBean.getAppImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(imageView1);
        baseViewHolder.setText(R.id.textView_horizontal2, appBean.getTitle());
        baseViewHolder.setText(R.id.textView2_horizontal2, appBean.getSubTitle());
        baseViewHolder.setText(R.id.textView3_horizontal2, appBean.getVersion());
        linearLayout.setOnClickListener(view -> {
            iCallback.itemClicked(view, appBean.getDownloadLink());
        });
    }
}
