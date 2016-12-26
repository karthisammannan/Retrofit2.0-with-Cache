package com.example.karthi.retrofit2_example;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.karthi.retrofit2_example.Adaper.ListviewAdapter;
import com.example.karthi.retrofit2_example.Helper.ApiClient;
import com.example.karthi.retrofit2_example.Helper.ApiInterface;
import com.example.karthi.retrofit2_example.Response.BasicResponse;
import com.example.karthi.retrofit2_example.Response.JSONResponses;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView list_view;
    ListviewAdapter adapter;
    public static ArrayList<JSONResponses> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view = (ListView) findViewById(R.id.listView);
        get_data();
    }

    private void get_data() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<BasicResponse> call = apiService.getData();
        call.enqueue(new Callback<BasicResponse>() {
            @Override
            public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                String success = response.body().getSuccess();
                if (success.equals("1")) {
                    Log.v("response", success + "");
                    BasicResponse jsonResponse = response.body();
                    data = new ArrayList<>(Arrays.asList(jsonResponse.getFilmList()));
                    if (data.size() > 0) {
                        list_view.setVisibility(View.VISIBLE);
                        Log.v("Data", " " + data);
                        adapter = new ListviewAdapter(MainActivity.this, data);
                        list_view.setAdapter(adapter);
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<BasicResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
