package edu.osucascades.jokerama;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

    protected Fragment createFragment() {
        return new JokeListFragment();
    }
}
