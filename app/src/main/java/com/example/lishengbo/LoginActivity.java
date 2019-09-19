package com.example.lishengbo;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.example.lishengbo.Bean.Linkman;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements LinkAdapter.OnItemClickListener, View.OnClickListener {

    private RecyclerView mRecy;
    private ArrayList<Linkman> linkmen;
    private LinkAdapter linkAdapter;
    private int posi;
    private Button mShan;
    private Button mXiu;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initPopu();
        initView();
    }

    private void initPopu() {

        View view = LayoutInflater.from(this).inflate(R.layout.item1, null);
        popupWindow = new PopupWindow(view,GridView.LayoutParams.MATCH_PARENT,GridView.LayoutParams.WRAP_CONTENT);
        mShan = (Button) view.findViewById(R.id.shan);
        mShan.setOnClickListener(this);
        mXiu = (Button) view.findViewById(R.id.xiu);
        mXiu.setOnClickListener(this);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());

    }

    private void initView() {
        mRecy = (RecyclerView) findViewById(R.id.recy);
        //添加布局管理器
        mRecy.setLayoutManager(new LinearLayoutManager(this));
//设置闲心
        mRecy.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        linkmen = new ArrayList<>();
//设置设配器
        linkAdapter = new LinkAdapter(this, linkmen);

        mRecy.setAdapter(linkAdapter);

        initData();
//监听条目
        linkAdapter.setOnItemClickListener(this);

    }




    @Override
    public void itemClick(int i) {
        posi = i;
        popupWindow.showAtLocation(mRecy,Gravity.CENTER,0,0);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.shan:
                linkmen.remove(posi);
                linkAdapter.notifyDataSetChanged();
                popupWindow.dismiss();
                break;
            case R.id.xiu:
                Linkman linkman = linkmen.get(posi);
                linkman.setHao("100303030");
                linkman.setName("王五");
                linkAdapter.notifyDataSetChanged();
                popupWindow.dismiss();
                break;
        }
    }
    private void initData() {

        ArrayList<Linkman> list = new ArrayList<>();
        list.add(new Linkman("张三", "10086"));
        list.add(new Linkman("李四", "10000"));
        linkmen.addAll(list);
        Log.d("tag", "initData: "+list.toString());
        linkAdapter.notifyDataSetChanged();
    }
}
