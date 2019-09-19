package com.example.lishengbo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lishengbo.persentr.RegisPersentr;
import com.example.lishengbo.utils.DbUtil;
import com.example.lishengbo.view.RegisView;

import java.util.List;

public class RegisActivity extends AppCompatActivity implements View.OnClickListener, RegisView {

    private ImageView mImg;
    private EditText mName;
    private EditText mPass1;
    private EditText mPass2;
    /**
     * 注册
     */
    private Button mZhu;
    private String path;
    private RegisPersentr regisPersentr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        regisPersentr = new RegisPersentr(this);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mImg.setOnClickListener(this);
        mName = (EditText) findViewById(R.id.name);
        mPass1 = (EditText) findViewById(R.id.pass1);
        mPass2 = (EditText) findViewById(R.id.pass2);
        mZhu = (Button) findViewById(R.id.zhu);
        mZhu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img:
                //访问相册
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,200);
                break;
            case R.id.zhu:

                String name = mName.getText().toString();
                String pass1 = mPass1.getText().toString();
                String pass2 = mPass2.getText().toString();


                if (TextUtils.isEmpty(name)){
                    ////判段name不能为空
                    Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (pass1.equals(pass2)){
                    //通知p层，插入数据
                    List<User> select = DbUtil.getDbUtil().select();
                    int id = select.size();
                    User user = new User(Long.valueOf(id+""),name,pass1,path);
                    regisPersentr.getData(user);
                }
                finish();

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200){
            //设置图片
            Uri uri = data.getData();
            path = uri.toString();
            mImg.setImageURI(uri);
        }
    }

    @Override
    public void ok(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void no(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
