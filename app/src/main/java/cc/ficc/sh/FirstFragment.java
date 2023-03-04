package cc.ficc.sh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import cc.ficc.sh.databinding.FragmentFirstBinding;
import cc.ficc.showlist.bean.AppBean;
import cc.ficc.showlist.item.VerticalDisplay;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        var showListView = binding.showList;
        showListView.setTitle("推荐");
        showListView.setSubtitle("2023装机必备");
        var appBeans = new ArrayList<AppBean>();
        for (int i = 0; i <= 10; i++) {
            var appBean = new AppBean();
            appBean.setMainImage("https://img1.baidu.com/it/u=868364201,1109837522&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500");
            appBean.setAppImage("https://gchat.qpic.cn/gchatpic_new/0/0-0-603F77D279AA70DB3983260BB45C9D83/0");
            appBean.setTitle("王者荣耀");
            appBean.setSubTitle("MOBA游戏");
            appBean.setVersion("8.2.1.9");
            appBean.setDownloadLink("下载链接" + i);
            appBeans.add(appBean);
        }
        var horizontalDisplay = new VerticalDisplay(getContext());
        horizontalDisplay.loadData(appBeans, (view1, downloadLink) -> {
            Toast.makeText(FirstFragment.this.getContext(), downloadLink, Toast.LENGTH_LONG).show();
        });
        showListView.setShowView(horizontalDisplay);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}