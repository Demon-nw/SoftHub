package cc.ficc.showlist;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

import cc.ficc.showlist.bean.AppBean;

public abstract class ShowView extends RecyclerView {
    private Subassembly subassembly;
    public ShowView(Context context) {
        super(context);
    }

    protected void init(Subassembly subassembly) {
        this.subassembly = subassembly;
    }

    public abstract void loadData(ArrayList<AppBean> appBeans, ICallback iCallback);

    public abstract View onCreateItemView();

    public interface Subassembly {
        void convert(@NonNull BaseViewHolder baseViewHolder, AppBean appBean);
    }

    public class Adapter extends BaseQuickAdapter<AppBean, BaseViewHolder> {
        public Adapter(ArrayList<AppBean> beans) {
            super(0, beans);
        }

        @NonNull
        @Override
        protected BaseViewHolder createBaseViewHolder(@NonNull ViewGroup parent, int layoutId) {
            return createBaseViewHolder(onCreateItemView());
        }

        @Override
        protected void convert(@NonNull BaseViewHolder baseViewHolder, AppBean appBean) {
            subassembly.convert(baseViewHolder,appBean);
        }
    }
}
