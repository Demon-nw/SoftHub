package cc.ficc.showlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class ShowListView extends LinearLayoutCompat {
    private TextView mTitle, mSubtitle;
    private ImageView mImageView;
    private LinearLayout mLinearLayout;
    private ChipGroup mChipGroup = null;
    private boolean isMoreButton = false;
    private boolean isChipMode = false;

    public ShowListView(Context context){
        super(context);
        initView();
    }
    public ShowListView(Context context, @Nullable AttributeSet attributeSet){
        super(context,attributeSet);
        initView();
    }
    public ShowListView(Context context, @Nullable AttributeSet attributeSet,int i){
        super(context,attributeSet,i);
        initView();
    }
    private void initView(){
        setOrientation(VERTICAL);
        LayoutInflater.from(getContext())
                .inflate(R.layout.show_list, this, true);
        this.mTitle = findViewById(R.id.show_item_title);
        this.mSubtitle = findViewById(R.id.show_item_subtitle);
        this.mImageView = findViewById(R.id.show_item_image);
        this.mLinearLayout = findViewById(R.id.show_item_button);
        mChipGroup = new ChipGroup(getContext());
        mChipGroup.setPadding(
                dip2px(30),
                mChipGroup.getPaddingTop(),
                mChipGroup.getPaddingRight(),
                mChipGroup.getPaddingBottom());
        addView(mChipGroup);
        mChipGroup.setVisibility(View.GONE);
        mImageView.setClickable(true);
    }
    private int dip2px(int i) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (i * scale + 0.5f);
    }
    public void setShowView(ShowView showView){
        addView(showView,-1,-1);
    }
    public String getTitle() {
        return (String) mTitle.getText();
    }
    public String getSubtitle() {
        return (String) mSubtitle.getText();
    }
    public void setTitle(String title) {
        mTitle.setText(title);
    }
    public void setSubtitle(String subtitle) {
        if (subtitle != null && !subtitle.isEmpty()) {
            mSubtitle.setText(subtitle);
            mSubtitle.setVisibility(View.VISIBLE);
        } else {
            mSubtitle.setVisibility(View.GONE);
        }
    }
    public void setMoreButton(boolean open) {
        this.isMoreButton = open;
        if (open) {
            mImageView.setVisibility(View.VISIBLE);
        } else {
            mImageView.setVisibility(View.GONE);
        }
    }
    public void setButtonListener(OnClickListener listener) {
        this.mLinearLayout.setOnClickListener(listener);
    }
    public void setChipMode(boolean open) {
        this.isChipMode = open;
        if (open) {
            mLinearLayout.setVisibility(View.GONE);
            mChipGroup.setVisibility(View.VISIBLE);
        } else {
            mLinearLayout.setVisibility(View.VISIBLE);
            mChipGroup.setVisibility(View.GONE);
        }
    }
    public void addChip(Chip chip) {
        mChipGroup.addView(chip);
    }
    public void setOnCheckedStateChangeListener(ChipGroup.OnCheckedStateChangeListener listener) {
        this.mChipGroup.setOnCheckedStateChangeListener(listener);
    }

}
