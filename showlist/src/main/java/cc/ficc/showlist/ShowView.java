package cc.ficc.showlist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;

import cc.ficc.showlist.bean.AppBean;

public abstract class ShowView extends RecyclerView {
    public final static int HORIZONTAL_1 = 001;
    public final static int HORIZONTAL_2 = 002;
    private Subassembly subassembly;
    public ShowView(Context context){
        super(context);
    }
    protected void init(ArrayList<AppBean> appBeans,Subassembly subassembly){
        this.subassembly = subassembly;
        setAdapter(new adapter(appBeans));
    }
    public abstract View onCreateItemView();
    public interface Subassembly{
        void convert(@NonNull BaseViewHolder baseViewHolder, AppBean appBean);
    }
    class adapter extends BaseQuickAdapter<AppBean, BaseViewHolder>{
        public adapter(ArrayList<AppBean> beans){
            super(0,beans);
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
