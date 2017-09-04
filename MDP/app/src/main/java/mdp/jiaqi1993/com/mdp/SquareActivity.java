package mdp.jiaqi1993.com.mdp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vinu on 2/9/17.
 */

public class SquareActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));

    }
}