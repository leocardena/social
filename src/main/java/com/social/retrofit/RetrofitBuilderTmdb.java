package com.social.retrofit;

import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.util.TmdbAPIKey;
import com.social.tmdb.util.TmdbBaseUrl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Component
public class RetrofitBuilderTmdb {

	private final static Retrofit RETROFIT = RetrofitBuilderTmdb.getRetrofit();;

	private RetrofitBuilderTmdb() {
	}

	@Bean(name = "TMDBBean")
	public static Retrofit getInstance() {
		return RETROFIT;
	}

	private static Retrofit getRetrofit() {
		return new Retrofit.Builder().baseUrl(TmdbBaseUrl.URL.toString())
				.addConverterFactory(JacksonConverterFactory.create()).client(RetrofitBuilderTmdb.getClient()).build();
	}

	private static OkHttpClient getClient() {
		return new OkHttpClient.Builder().addInterceptor(new Interceptor() {

			public Response intercept(Chain chain) {
				Request original = chain.request();

				HttpUrl url = original.url().newBuilder().addQueryParameter("api_key", TmdbAPIKey.KEY.toString())
						.build();

				Request.Builder requestBuilder = original.newBuilder().header("Content-Type", "application/json")
						.method(original.method(), original.body());

				Request request = requestBuilder.url(url).build();

				try {
					return chain.proceed(request);
				} catch (IOException e) {
					throw new RetrofitException("Erro ao criar interceptor para adicionar os headers");
				}

			}
		}).build();
	}

}
