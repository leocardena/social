package com.social.retrofit;

import java.io.IOException;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.util.TraktAPIKey;
import com.social.trakt.util.TraktBaseUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitBuilder {
	
	@SuppressWarnings("unused")
	private final static RetrofitBuilder INSTANCE = new RetrofitBuilder();
	private final static Retrofit RETROFIT = RetrofitBuilder.getRetrofit();;
	
	private RetrofitBuilder() {
	}
	
	public static Retrofit getInstance() {
		return RETROFIT;
	} 
	
	private static Retrofit getRetrofit(){
		return new Retrofit.Builder()
				.baseUrl(TraktBaseUrl.URL.toString())
				.addConverterFactory(JacksonConverterFactory.create())
				.client(RetrofitBuilder.getClient()).build();
	}
	
	private static OkHttpClient getClient() {
		return new OkHttpClient.Builder().addInterceptor(new Interceptor() {

			public Response intercept(Chain chain) {
				Request original = chain.request();

				Request.Builder requestBuilder = original.newBuilder()
						.header("trakt-api-version", "2")
						.header("trakt-api-key", TraktAPIKey.KEY.toString())
						.header("Content-Type", "application/json")
						.method(original.method(), original.body());

				Request request = requestBuilder.build();
				
				try {
					return chain.proceed(request);
				} catch (IOException e) {
					 throw new RetrofitException("Erro ao criar interceptor para adicionar os headers");
				}
				
			}
		}).build();
	}
	
}
