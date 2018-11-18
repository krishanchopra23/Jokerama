package edu.osucascades.jokerama;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    protected Fragment createFragment() {
        return new JokeListFragment();
    }
}
