//package com.nomadlab.myretrofit3.repository;
//
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import retrofit2.Retrofit;
////
//public interface APIClient {
//
//    private fun createOkHttpClient(): OkHttpClient {
//        val builder = OkHttpClient.Builder()
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        builder.addInterceptor(interceptor)
//        return builder.build()
//    }
//
//    private OkHttpClient createOkHttpClient() {
//
//        return
//    }
//
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(API_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client).build();
//
//}
