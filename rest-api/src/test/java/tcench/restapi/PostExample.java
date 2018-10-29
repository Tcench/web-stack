package tcench.restapi;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PostExample {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.SECONDS)
            .connectTimeout(1000, TimeUnit.SECONDS)
            .build();

    String post(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    public static void main(String[] args) throws IOException {
        PostExample example = new PostExample();
//        String json = example.bowlingJson("Jesse", "Jake");
        String json = "{\n" +
                "  \"id\": 1001,\n" +
                "  \"localDateTime\": \"2018-10-29T16:37:51.674\",\n" +
                "  \"amount\": 2011.55\n" +
                "}";

        long startTime = System.nanoTime();   //获取开始时间
        String response = example.post("http://localhost:8888/demo-add", json);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);
    }
}
