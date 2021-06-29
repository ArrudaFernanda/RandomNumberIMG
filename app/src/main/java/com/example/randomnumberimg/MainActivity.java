/**
 * Neste exemplo de gerador de números randomicos, usamos conceito de recursão.*/

package com.example.randomnumberimg;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   private ImageView img1, img2, img3, img4;
   private Button btnGerar;

   private final int imgs [] = {R.drawable.bola1, R.drawable.bola2, R.drawable.bola3, R.drawable.bola4, R.drawable.bola5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        btnGerar = findViewById(R.id.btnGerar);

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomImage();
            }
        });
    }

    public void randomImage(){
        Random random = new Random();
        int val1 = random.nextInt(5);//Gera números randomicos de 0 a 4
        int val2 = random.nextInt(5);
        int val3 = random.nextInt(5);
        int val4 = random.nextInt(5);

        if(val1 != val2 && val1 != val3 && val1 != val4){
            img1.setImageResource(imgs[val1]);
            if(val2 != val3 && val2 != val4){
                img2.setImageResource(imgs[val2]);
                if(val3 != val4){
                    img3.setImageResource(imgs[val3]);
                    img4.setImageResource(imgs[val4]);
                }else {
                    randomImage();
                }
            }else {
                randomImage();
            }
        }else {
            randomImage();
        }
    }
}