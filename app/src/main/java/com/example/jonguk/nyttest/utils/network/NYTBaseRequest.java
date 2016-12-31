package com.example.jonguk.nyttest.utils.network;

import com.example.jonguk.nyttest.utils.parser.GsonFactory;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

public class NYTBaseRequest {
    protected static <T> T createRequest(Class<T> service) {
        return NetworkManager.getInstance().create(service);
    }

    public static class BodyBuilder {
        private static final String MEDIA_TYPE = "application/json; charset=utf-8";
        private final HashMap<String, Object> map = new HashMap<>();

        public BodyBuilder append(String key, Object value) {
            map.put(key, value);
            return this;
        }

        public RequestBody build() {
            return RequestBody.create(MediaType.parse(MEDIA_TYPE),
                    GsonFactory.getGson().toJson(map));
        }
    }
}
