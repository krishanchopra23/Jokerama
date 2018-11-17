package edu.osucascades.jokerama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class JokeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JokeFragment();
    }
}