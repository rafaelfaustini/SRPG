package br.com.rafaelfaustini.srpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.rafaelfaustini.srpg.model.Dice;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        }

    }
}