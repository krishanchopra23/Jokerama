package edu.osucascades.jokerama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {

    private Joke mJoke;
    private TextView mJokeTextView;
    //overriding on CreateView
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mJoke = new Joke();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);
        mJokeTextView = (TextView) v.findViewById(R.id.joke_fragment_text_view);
        mJokeTextView.setText(mJoke.getLinesOfJoke()[0]);
        return v;
    }
}
