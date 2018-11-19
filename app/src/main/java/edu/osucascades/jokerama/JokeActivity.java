package edu.osucascades.jokerama;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;


import java.util.UUID;

public class JokeActivity extends SingleFragmentActivity {

    public static final String EXTRA_JOKE_ID = "edu.osucascades.jokerama.joke_id";

    public static Intent newIntent(Context packageContext, UUID jokeId) {
        Intent intent = new Intent(packageContext, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE_ID, jokeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new JokeFragment();
    }
}