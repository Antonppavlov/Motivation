package pavlov.p.anton.motivation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import pavlov.p.anton.motivation.R;

import pavlov.p.anton.motivation.app.DbConnection;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //создается новый поток в котором
        new Thread() {
            @Override
            public void run() {
                DbConnection.initConnection(getApplicationContext());

              //  imitateLogin();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

            }


        }.start();
    }


    private void imitateLogin() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
