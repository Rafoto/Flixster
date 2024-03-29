package com.example.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    String imageBaseUrl;
    // the poster size to use when fetching images, part of the url
    String posterSize;
    // the backdrop size to use when fetching images
    String backdropSize;

    public String getBackdropSize() {
        return backdropSize;
    }

    public Config(JSONObject object) throws JSONException {
        this.imageBaseUrl = imageBaseUrl;
        JSONObject images = object.getJSONObject("images");
        imageBaseUrl = images.getString("secure_base_url");
        // gets the poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the option at index 3 or w342 as a fallback
        posterSize = posterSizeOptions.optString(3,"w342");
        // parse the backdrop sizes and use the option at index 1 or w700 as a fallback
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOptions.optString(1, "w780");

    }
    public String getImageUrl(String size, String path){
        return String.format("%s%s%s", imageBaseUrl, size, path);
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }
}
