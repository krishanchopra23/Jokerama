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
    private TextView mJokeTextView2;
    private TextView mJokeTextView3;
    private TextView mJokeTextView4;
    private TextView mJokeTextView5;
    private int mLineJoke;
    //overriding on CreateView
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve the extra and fetch the joke
        UUID jokeId = (UUID) getActivity().getIntent()
                .getSerializableExtra(JokeActivity.EXTRA_JOKE_ID);
        mJoke = JokeLab.getInstance(getActivity()).getJoke(jokeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);
        mJokeTextView = (TextView) v.findViewById(R.id.joke_fragment_text_view);
        mJokeTextView2 = (TextView) v.findViewById(R.id.joke_fragment_text_view2);
        mJokeTextView3 = (TextView) v.findViewById(R.id.joke_fragment_text_view3);
        mJokeTextView4 = (TextView) v.findViewById(R.id.joke_fragment_text_view4);
        mJokeTextView5 = (TextView) v.findViewById(R.id.joke_fragment_text_view5);

        mJokeTextView.setVisibility(View.VISIBLE);
        mJokeTextView2.setVisibility(View.INVISIBLE);
        mJokeTextView3.setVisibility(View.INVISIBLE);
        mJokeTextView4.setVisibility(View.INVISIBLE);
        mJokeTextView5.setVisibility(View.INVISIBLE);

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

        mJokeTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLineJoke++;
                mJokeTextView2.setVisibility(View.VISIBLE);
                updateJokeLine(mLineJoke);
            }
        });

        mJokeTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLineJoke++;
                mJokeTextView3.setVisibility(View.VISIBLE);
                updateJokeLine(mLineJoke);
            }
        });

        mJokeTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLineJoke++;
                mJokeTextView4.setVisibility(View.VISIBLE);
                updateJokeLine(mLineJoke);
            }
        });

        mJokeTextView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLineJoke++;
                mJokeTextView5.setVisibility(View.VISIBLE);
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

    //public void updateJokeLine(TextView view, int index) {
    //    view.setText(mJoke.getLinesOfJoke()[index]);
    //}
}
