package br.com.rafaelfaustini.srpg.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.Logger;

import br.com.rafaelfaustini.srpg.BuildConfig;
import br.com.rafaelfaustini.srpg.R;

public class LoggingUtil {
    public static void error(String tag,Exception e, Context context){
        if (BuildConfig.DEBUG) {
            Log.e(tag, e.getMessage());
        }
            Toast.makeText(context, context.getResources().getString(R.string.errorMessage), Toast.LENGTH_SHORT).show();
    }
}
