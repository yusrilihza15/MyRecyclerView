package id.ac.poliban.dts.indra.myrecyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class HeroDetail extends AppCompatActivity {
    private TextView tvNameDetail;
    private TextView tvDetailDetail;
    private ImageView imPhotoDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);

        tvNameDetail = findViewById(R.id.tv_detail_hero);
        tvDetailDetail = findViewById(R.id.tv_detailDetail);
        imPhotoDetail = findViewById(R.id.img_detail_photo);

        if (getIntent().getExtras()!=null)
            showHeroDetail();
    }

    private void showHeroDetail() {
        Hero hero = (Hero) getIntent().getSerializableExtra("hero");

        Glide.with(this)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(200,200))
                .into(imPhotoDetail);
        tvNameDetail.setText(hero.getName());
        tvDetailDetail.setText(hero.getDetail());
    }
}
