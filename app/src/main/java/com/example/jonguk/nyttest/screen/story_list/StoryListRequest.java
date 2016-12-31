package com.example.jonguk.nyttest.screen.story_list;

import com.example.jonguk.nyttest.data.StoryListJson;
import com.example.jonguk.nyttest.utils.network.NYTBaseRequest;

import retrofit2.http.GET;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Jonguk on 2016. 12. 31..
 */

class StoryListRequest extends NYTBaseRequest {
    interface ApiService {
        @GET("svc/topstories/v2/home.json?api-key=cf23f0334a174fff975fc2400ccbfdd9")
        Observable<StoryListJson> getStoryList();
    }

    public static Observable<StoryListJson> getStoryList() {
        return createRequest(ApiService.class).getStoryList()
                .observeOn(AndroidSchedulers.mainThread());
    }
}
