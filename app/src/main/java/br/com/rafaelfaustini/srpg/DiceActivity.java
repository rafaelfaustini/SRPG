package br.com.rafaelfaustini.srpg;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

import br.com.rafaelfaustini.srpg.entity.Dice;
import br.com.rafaelfaustini.srpg.util.LoggingUtil;

public class DiceActivity extends AppCompatActivity implements ShakeDetector.Listener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);
        setContentView(R.layout.activity_dice);
    }

    public void roll(View view){
        try {
            EditText editSides = findViewById(R.id.editCampaignStory);
            int faces = Integer.parseInt(editSides.getText().toString());
            Dice dice = new Dice(faces);
            TextView result = findViewById(R.id.diceResult);
            result.setVisibility(1);
            startCountAnimation(result, dice.roll());
        } catch (Exception e){
            LoggingUtil.error("DiceRoll", e, getApplicationContext());
        }
    }

    private void startCountAnimation(TextView result, int value) {
        ValueAnimator animator = ValueAnimator.ofInt(1, value);
        animator.setDuration(500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                result.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }

    @Override public void hearShake() {
        roll(this.findViewById(android.R.id.content).getRootView());
    }

}