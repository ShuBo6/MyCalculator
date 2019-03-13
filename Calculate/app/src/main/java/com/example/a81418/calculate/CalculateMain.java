package com.example.a81418.calculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class CalculateMain extends AppCompatActivity implements View.OnClickListener {
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button point;
    private Button CE;
    private Button back;
    private Button chuquyu;
    private Button chu;
    private Button cheng;
    private Button jia;
    private Button jian;
    private Button dengyu;
    private TextView mintor;
    private ImageView logo;
    private StringBuilder sb =new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_main);
        num0=findViewById(R.id.num0);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        num5=findViewById(R.id.num5);
        num6=findViewById(R.id.num6);
        num7=findViewById(R.id.num7);
        num8=findViewById(R.id.num8);
        num9=findViewById(R.id.num9);
        point=findViewById(R.id.point);
        CE=findViewById(R.id.CE_btn);
        back=findViewById(R.id.BACK);
        chuquyu=findViewById(R.id.chuquyu);
        chu=findViewById(R.id.chu);
        cheng=findViewById(R.id.cheng);
        jia=findViewById(R.id.jia);
        jian=findViewById(R.id.jian);
        dengyu=findViewById(R.id.dengyu);
        mintor=findViewById(R.id.mintor);
        logo=findViewById(R.id.my_logo);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        point.setOnClickListener(this);
        CE.setOnClickListener(this);
        back.setOnClickListener(this);
        chuquyu.setOnClickListener(this);
        chu.setOnClickListener(this);
        cheng.setOnClickListener(this);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
        dengyu.setOnClickListener(this);
        logo.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.num0 :
                sb=sb.append("0");
                mintor.setText(sb);
                break;
            case R.id.num1 :sb=sb.append("1");
                mintor.setText(sb);
                break;
            case R.id.num2 :sb=sb.append("2");
                mintor.setText(sb);
                break;
            case R.id.num3 :sb=sb.append("3");
                mintor.setText(sb);
                break;
            case R.id.num4 :sb=sb.append("4");
                mintor.setText(sb);
                break;
            case R.id.num5 :sb=sb.append("5");
                mintor.setText(sb);
                break;
            case R.id.num6 :sb=sb.append("6");
                mintor.setText(sb);
                break;
            case R.id.num7 :sb=sb.append("7");
                mintor.setText(sb);
                break;
            case R.id.num8 :sb=sb.append("8");
                mintor.setText(sb);
                break;
            case R.id.num9 :sb=sb.append("9");
                mintor.setText(sb);
                break;
            case R.id.jia:sb=sb.append("+");
                mintor.setText(sb);
                break;
            case R.id.jian :sb=sb.append("-");
                mintor.setText(sb);
                break;
            case R.id.cheng :sb=sb.append("*");
                mintor.setText(sb);
                break;
            case R.id.chu :sb=sb.append("/");
                mintor.setText(sb);
                break;
            case R.id.chuquyu :sb=sb.append("%");
                mintor.setText(sb);
                break;
            case R.id.point :if (judge1()) {
                sb = sb.append(".");
                mintor.setText(sb);
            }
                break;
            case R.id.CE_btn :
                sb=sb.delete(0,sb.length());
                mintor.setText(sb);
                break;
            case R.id.BACK :if (sb.length() != 0) {
                sb = sb.delete(sb.length() - 1, sb.length());
                mintor.setText(sb);
            }
                break;
            case R.id.dengyu :if ((sb.length() > 1)) {
                    InfixInToDuffix inf = new InfixInToDuffix();
                    String jieguo;
                    try {
                        String a = inf.toSuffix(sb);
                        jieguo = inf.dealEquation(a);

                    } catch (Exception ex) {
                        jieguo = "ERROR";
                    }
                    mintor.setText(sb + "=" + jieguo);
                    sb = sb.delete(0, sb.length());
                    if (Character.isDigit(jieguo.charAt(0))) {
                        sb = sb.append(jieguo);
                    }
                }
                break;
            case R.id.my_logo:
                Intent intent=new Intent(CalculateMain.this,Author.class);
                startActivity(intent);
                finish();
                break;



        }
    }
    private boolean judge1() {
        String a = "+-*/.";
        int[] b = new int[a.length()];
        int max;
        for (int i = 0; i < a.length(); i++) {
            String c = "" + a.charAt(i);
            b[i] = sb.lastIndexOf(c);
        }
        Arrays.sort(b);
        if (b[a.length() - 1] == -1) {
            max = 0;
        } else {
            max = b[a.length() - 1];
        }
        if (sb.indexOf(".", max) == -1) {
            return true;
        } else {
            return false;
        }
    }
    private int judge2(){
        int a=0,b=0;
        for(int i = 0 ; i < sb.length() ;i++){
            if(sb.charAt(i)=='(' ) {
                a++;
            }
            if(sb.charAt(i)==')' ) {
                b++;
            }
        }
        if(a == b)
            return 0;
        if(a > b)
            return 1;
        return 2;
    }
}


