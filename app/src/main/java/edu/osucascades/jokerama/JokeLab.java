package edu.osucascades.jokerama;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JokeLab {

    private static JokeLab sJokeLab;
    private List<Joke> mJokes;
    private int mNumberOfJokes;
    private int mNumberOfJokesViewed;

    public static JokeLab getInstance(Context context) {
        if (sJokeLab == null) {
            sJokeLab = new JokeLab(context);
        }
        return sJokeLab;
    }

    private JokeLab(Context context) {
        mJokes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Joke joke = new Joke();
            joke.setTitle("Joke #" + i);
            joke.setLinesOfJoke(new String[]{
                    "Knock Knock", "Who's there?", "Someone",
                    "Someone who", "Something is up"
            });
            mJokes.add(joke);
        }
    }

    public List<Joke> getJokes() {
        return mJokes;
    }

    public Joke getJoke(UUID id) {
        for (Joke joke : mJokes) {
            if (joke.getId().equals(id)) {
                return joke;
            }
        }
        return null;
    }

    //create getters for joke totals and viewed totals
    public int getNumberOfJokes() {
        return mJokes.size();
    }

    public int getNumberOfJokesViewed() {
        mNumberOfJokesViewed = 0;
        for (Joke joke : mJokes) {
            if (joke.isViewed()) {
                mNumberOfJokesViewed++;
            }
        }
        return mNumberOfJokesViewed;
    }

    public void resetNumberOfJokesViewed() {
        for (Joke joke : mJokes) {
            joke.setViewed(false);
        }
        mNumberOfJokesViewed = 0;
    }
}
