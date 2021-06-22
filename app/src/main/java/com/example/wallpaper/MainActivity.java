package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btnWall;
    Timer timer;
    Drawable drawable;
    WallpaperManager wallpaperManager;
    int prev=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        wallpaperManager = WallpaperManager.getInstance(this);
        btnWall = findViewById(R.id.buttonWallpaper);
        btnWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();

            }
        });
    }
    private void setWallpaper(){
        long delay;
        Object period;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1) {
                    drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.wallpaper1,null);
                    prev=2;
                }
                else if(prev==2){
                    drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.wallpaper2,null);
                    prev=3;
                }
                else if(prev==3){
                    drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.wallpaper3,null);
                    prev=4;
                }
                else if(prev==4){
                    drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.wallpaper4,null);
                    prev=1;
                }
                Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();
                try {
                    
                        wallpaperManager.setBitmap(wallpaper);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
        },10,3000);
    }
}