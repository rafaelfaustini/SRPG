package br.com.rafaelfaustini.srpg;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

import br.com.rafaelfaustini.srpg.model.Dice;
import br.com.rafaelfaustini.srpg.util.LoggingUtil;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);
        setContentView(R.layout.activity_main);
    }

    public void roll(View view){
        try {
            EditText editSides = findViewById(R.id.editDiceSides);
            int faces = Integer.parseInt(editSides.getText().toString());
            Dice dice = new Dice(faces);
            TextView result = findViewById(R.id.diceResult);
            String resultText = String.valueOf(dice.roll());
            result.setText(resultText);
            result.setVisibility(1);
        } catch (Exception e){
            LoggingUtil.error("DiceRoll", e, getApplicationContext());
        }
    }

    @Override public void hearShake() {
        roll(this.findViewById(android.R.id.content).getRootView());
    }
}