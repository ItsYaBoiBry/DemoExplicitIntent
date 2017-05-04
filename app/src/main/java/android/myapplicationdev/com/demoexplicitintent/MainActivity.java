package android.myapplicationdev.com.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    int requestSuperCode = 1;
    int requestBatCode =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvSuperman = (TextView) findViewById(R.id.textViewSuperman),
                tvBatman = (TextView) findViewById(R.id.textViewBatman);
        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hero superman = new Hero("Superman",100,60);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                i.putExtra("hero", superman);
                startActivityForResult(i,requestSuperCode);
            }
        });
        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hero batman = new Hero("Batman",60,90);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                i.putExtra("hero", batman);
                startActivityForResult(i,requestBatCode);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == RESULT_OK){
            if(data != null){
                String like = data.getStringExtra("like");
                String statement = "";

                if(requestCode == requestSuperCode){
                    statement = "You "+like+" Superman";
                }else if(requestCode == requestBatCode){
                    statement = "You "+like+" Batman";
                }
                Toast.makeText(MainActivity.this,statement,Toast.LENGTH_LONG).show();
            }
        }
    }
}
