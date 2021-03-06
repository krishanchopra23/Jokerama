package edu.osucascades.jokerama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class JokeListFragment extends Fragment {

    private RecyclerView mJokeRecyclerView;
    private JokeAdapter mAdapter;
    private static final String DIALOG_RESET = "DialogReset";
    private static final int REQUEST_DECIDE = 0;

    //receive menu callbacks
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_list, container, false);
        mJokeRecyclerView = (RecyclerView) view.findViewById(R.id.joke_recycler_view);
        mJokeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    //respond to the dialog
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_DECIDE) {
            JokeLab jokeLab = JokeLab.getInstance(getActivity());
            jokeLab.resetNumberOfJokesViewed();
            updateUI();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    //inflate a menu resource
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_joke_list, menu);
    }
    //respond to menu selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset_jokes_viewed:
                //show the dialog fragment
                FragmentManager manager = getFragmentManager();
                ResetJokeFragment dialog = new ResetJokeFragment();
                dialog.setTargetFragment(JokeListFragment.this, REQUEST_DECIDE);
                dialog.show(manager, DIALOG_RESET);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //set the toolbar's subtitle
    private void updateSubtitle() {
        JokeLab jokeLab = JokeLab.getInstance(getActivity());
        int jokeCount = jokeLab.getJokes().size();
        int jokesViewed = jokeLab.getNumberOfJokesViewed();
        String subtitle = getString(R.string.subtitle_format, jokeCount, jokesViewed);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private class JokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private Joke mJoke;

        public JokeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_joke, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.joke_title);
        }
        //add a bind
        public void bind(Joke joke) {
            mJoke = joke;
            mTitleTextView.setText(mJoke.getTitle());
        }

        @Override
        public void onClick(View view) {
            Intent intent = JokeActivity.newIntent(getActivity(), mJoke.getId());
            startActivity(intent);
        }
    }
    //set an adapter
    private void updateUI() {
        JokeLab jokeLab = JokeLab.getInstance(getActivity());
        List<Joke> jokes = jokeLab.getJokes();

        if (mAdapter == null) {
            mAdapter = new JokeAdapter(jokes);
            mJokeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
        //update the subtitle
        updateSubtitle();
    }

    private class JokeAdapter extends RecyclerView.Adapter<JokeHolder> {

        private List <Joke> mJokes;

        public JokeAdapter(List <Joke> jokes) {
            mJokes = jokes;
        }

        @Override
        public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new JokeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeHolder holder, int position) {
            Joke joke = mJokes.get(position);
            holder.bind(joke);
            //set the background color black when viewed
            if (joke.isViewed()) {
                holder.itemView.setBackgroundColor(0);
            }
        }

        @Override
        public int getItemCount() {
            return mJokes.size();
        }
    }
}
