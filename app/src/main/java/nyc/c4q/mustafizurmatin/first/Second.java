package nyc.c4q.mustafizurmatin.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Second extends AppCompatActivity {

    String TAG = Second.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        String input = getIntent().getStringExtra("input");
        Log.d(TAG, "onCreate: " + input);

    }

}

