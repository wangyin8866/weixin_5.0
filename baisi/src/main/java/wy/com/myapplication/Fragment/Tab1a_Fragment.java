package wy.com.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import wy.com.myapplication.R;
import wy.com.myapplication.adapter.TuiJianAdapter;
import wy.com.myapplication.entity.TuiJian;

/**
 * Created by DELL on 2016/7/4.
 */
public class Tab1a_Fragment extends Fragment {
    private static final String TAG = "Tab1a_Fragment";
    private View view;
    private ListView mListView;
    private String url = "http://api.budejie.com/api/api_open.php?a=list&c=data";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1a_main, null);
        mListView = (ListView) view.findViewById(R.id.lv_tuijian);
        mListView.setAdapter(new TuiJianAdapter(getDatas(url), getActivity()));
        return view;
    }

    private List<TuiJian> getDatas(final String url) {

        final List<TuiJian> list1 = new ArrayList<>();
//        JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                try {
//
//                    JSONArray jsonArray = jsonObject.getJSONArray("list");
//                    Gson gson = new Gson();
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        TuiJian tj = gson.fromJson(jsonArray.get(i).toString(), TuiJian.class);
//                        Log.e(TAG, tj.toString());
//                        list1.add(tj);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//            }
//        });
//        App.getHttpQueues().add(jsonObject);
        //创建okHttpClient对象
//        OkHttpClient mOkHttpClient = new OkHttpClient();
//        //创建一个Request
//        final Request request = new Request.Builder()
//                .url(url)
//                .build();
//        //new call
//        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//               String str= response.body().string();
//                try {
//                    JSONObject jsonObject = new JSONObject(str);
//                    JSONArray jsonArray = jsonObject.getJSONArray("list");
//                    Gson gson = new Gson();
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        TuiJian tj = gson.fromJson(jsonArray.get(i).toString(), TuiJian.class);
//                        list1.add(tj);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url1 = new URL(url);
                    HttpURLConnection conn= (HttpURLConnection) url1.openConnection();
                    InputStream is=conn.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is,"utf-8");
                    String result="";
                    String line;
                    BufferedReader br = new BufferedReader(isr);
                    while ((line=br.readLine())!=null) {
                        result += line;
                    }
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("list");
                    Gson gson = new Gson();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        TuiJian tj = gson.fromJson(jsonArray.get(i).toString(), TuiJian.class);
                        list1.add(tj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return list1;
    }
}
