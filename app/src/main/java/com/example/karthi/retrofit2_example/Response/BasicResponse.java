package com.example.karthi.retrofit2_example.Response;

/**
 * Created by Karthi on 7/25/2016.
 */
public class BasicResponse {
    private JSONResponses[] filmList;
    private String success;
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

      public JSONResponses[] getFilmList() {
        return filmList;
    }

    public void setFilmList(JSONResponses[] filmList) {
        this.filmList = filmList;
    }
}
