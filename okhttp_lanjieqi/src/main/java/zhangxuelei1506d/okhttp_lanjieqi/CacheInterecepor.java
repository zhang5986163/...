package zhangxuelei1506d.okhttp_lanjieqi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * date 2017/9/7
 * author:张学雷(Administrator)
 * functinn:自定义的缓存拦截器，如果服务器没有给文件在响应头定义缓存标签，那么我们在拦截器中手动给响应头加上标签
 * 1.自定义一个类，实现Intercept接口
 * 2.在intercept方法中写自己的逻辑
 * 3.
 */


/**
 * 数据返回过来有响应头，封装网络工具类，他是更加拿到响应头中的缓存标签来决定这一次发
 * 这一次请求的数据是否要进行缓存，如果没有，那么就不做缓存
 * 服务器那边有问题，本来这个数据是要做缓存的，他没有在响应头中添加
 * 标签，那么此时这一个数据我判断是没有缓存标签，就不会做缓存，我要为
 * 这条数据们重新去写网络请求，
 */
public class CacheInterecepor implements Interceptor{


    @Override
    public Response intercept(Chain chain) throws IOException {
        //得到Respinse对象
        Response response = chain.proceed(chain.request());
        Response builder = response.newBuilder().
                //设置缓存标签及60s的时长
                header("Cache-Control", "max-age=60").build();
        return builder;
    }
}
