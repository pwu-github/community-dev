package com.wp.community.provider;

import com.alibaba.fastjson.JSON;
import com.wp.community.dto.AccessTokenDTO;
import com.wp.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * Created by codedrinker on 2019/4/24.
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
//            log.error("getAccessToken error,{}", accessTokenDTO, e);
        }
        return null;
    }

    public GitHubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GitHubUser githubUser = JSON.parseObject(string, GitHubUser.class);
            return githubUser;
        } catch (Exception e) {
//            log.error("getUser error,{}", accessToken, e);
        }
        return null;
    }
}
