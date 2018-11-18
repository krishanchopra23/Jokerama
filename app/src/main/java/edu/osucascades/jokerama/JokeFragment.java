package edu.osucascades.jokerama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

public class JokeFragment extends Fragment {

    private Joke mJoke;
    private TextView mJokeTextView;
    private int mLineJoke;
    //overriding on CreateView
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve the extra and fetch the joke
        UUID jokeId = (UUID) getActivity().getIntent()
                .getSerializableExtra(JokeActivity.EXTRA_JOKE_ID);
        mJoke = JokeLab.get(getActivity()).getJoke(jokeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);
        mJokeTextView = (TextView) v.findViewById(R.id.joke_fragment_text_view);

        mLineJoke = 0;
        updateJokeLine(mLineJoke);
        //set a listener on the textview
        mJokeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLineJoke++;
                updateJokeLine(mLineJoke);
            }
        });
        return v;
    }
    //update the joke when its done
    public void updateJokeLine(int index) {
        if (index >= 5) {
            mJoke.setViewed(true);
            return;
        }
        mJokeTextView.setText(mJoke.getLinesOfJoke()[index]);
    }
}
