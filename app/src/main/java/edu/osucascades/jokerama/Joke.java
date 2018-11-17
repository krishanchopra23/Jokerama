package edu.osucascades.jokerama;

import java.util.UUID;

public class Joke {

    private UUID mId;
    private String mTitle;
    private boolean mViewed;
    private String[] mLinesOfJoke;

    public Joke() {
        mId = UUID.randomUUID();
        mViewed = false;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isViewed() {
        return mViewed;
    }

    public void setViewed(boolean viewed) {
        mViewed = viewed;
    }

    public String[] getLinesOfJoke() {
        return mLinesOfJoke;
    }

    public void setLinesOfJoke(String[] linesOfJoke) {
        mLinesOfJoke = linesOfJoke;
    }
}
