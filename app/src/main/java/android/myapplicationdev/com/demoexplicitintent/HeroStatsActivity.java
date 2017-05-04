package android.myapplicationdev.com.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);
        TextView tvName = (TextView) findViewById(R.id.textName),
                tvStrength = (TextView) findViewById(R.id.textStrength),
                tvTechProwess = (TextView) findViewById(R.id.textTechnicalProwess);
        Button btnLike = (Button) findViewById(R.id.btnLike),
                btnDislike = (Button) findViewById(R.id.btnDislike);

        Intent i = getIntent();

        Hero hero = (Hero) i.getSerializableExtra("hero");
        tvName.append(hero.getName());
        tvStrength.setText("Strength: "+hero.getStrength());
        tvTechProwess.setText("Technical Prowess: "+hero.getTechnicalProwess());

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("like","like");
                setResult(RESULT_OK,i);
                finish();
            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("like","dislike");
                setResult(RESULT_OK,i);
                finish();
            }
        });

    }
}
