package zhangxuelei1506d.okhttp_lanjieqi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *日志拦截器，请求来了，现在这里处理，可以得到发请求到得到请求消耗了多长时间
 * 作用：可以排查网络请求速度慢的根本原因
 * 1.可能是网路不给力
 * 2.可能是服务器有问题（硬件，逻辑代码）
 * 3.可能是客户端的一个问题
 */
class LoggingInterceptor implements Interceptor {
  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();


    long t1 = System.nanoTime();

    System.out.println(" request  = " + String.format("Sending request %s on %s%n%s",
            request.url(), chain.connection(), request.headers()));
    Response response = chain.proceed(request);

    long t2 = System.nanoTime();

    //得出请求网络,到得到结果,中间消耗了多长时间
    System.out.println("response  " + String.format("Received response for %s in %.1fms%n%s",
            response.request().url(), (t2 - t1) / 1e6d, response.headers()));
    return response;
  }
}
