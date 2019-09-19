package com.example.lishengbo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lishengbo.utils.DbUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName;
    private EditText mPass;
    /**
     * 登陆
     */
    private Button mBtn1;
    /**
     * 注册
     */
    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1:
                String name = mName.getText().toString();
                String pass = mPass.getText().toString();
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = DbUtil.getDbUtil().select(name);
                if(user!=null){
                    if(pass.equals(user.getPass())){
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
                    }
                }


                break;
            case R.id.btn2:
                Intent intent = new Intent(this, RegisActivity.class);
                startActivity(intent);
                break;
        }
    }
}
