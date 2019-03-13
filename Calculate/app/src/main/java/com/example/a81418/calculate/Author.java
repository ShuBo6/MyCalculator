package com.example.a81418.calculate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Author extends AppCompatActivity{
    TextView text;
    Button back_to_calcu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author);
        back_to_calcu=findViewById(R.id.back_to_calcu);

        text=findViewById(R.id.my_info);

        text.setText("你没有看错\n这是一个彩蛋\n作者QQ：814183583");

        back_to_calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Author.this,CalculateMain.class);
                startActivity(intent1);

            }
        });
    }
}
