package thul.app.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private static String songOne =
            "http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4";
    private static String songTwo =
            "http://mirrors.standaloneinstaller.com/video-sample/lion-sample.mp4";
    private static String songThree =
            "http://mirrors.standaloneinstaller.com/video-sample/Panasonic_HDC_TM_700_P_50i.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        tb.setSubtitle("Picture in Picture");

        findViewById(R.id.video_one).setOnClickListener(onClickListener);
        findViewById(R.id.video_two).setOnClickListener(onClickListener);
        findViewById(R.id.video_three).setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.video_one: {
                            showSelectedVideo(songOne);
                            break;
                        }
                        case R.id.video_two: {
                            showSelectedVideo(songTwo);
                            break;
                        }
                        case R.id.video_three:
                            showSelectedVideo(songThree);
                            break;
                    }
                }
            };
    public void showSelectedVideo(String url){
        Intent i = new Intent();
        i.setClass(this, PictureInPictureActivity.class);
        i.putExtra("videoUrl", url);
        startActivity(i);
    }
}