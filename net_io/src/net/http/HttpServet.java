package net.http;

import javax.swing.text.html.HTML;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpServet {
    private Map<String, String> supportGet = new HashMap<>();
    private Map<String,String> supportPost = new HashMap<>();
    private HttpServetGet httpServetGet;
    private HttpServetPost httpServetPost;

    public HttpServet() {

            this(new HttpServetPost(),new HttpServetGet());

    }

    public HttpServet(HttpServetPost httpServetPost, HttpServetGet httpServetGet) {
        this.httpServetPost = httpServetPost;
        this.httpServetGet = httpServetGet;
    }


    private boolean isSupported(String uri, METHOD method){
        if(method == METHOD.GET){
            return supportGet.keySet().contains(uri);
        }else{
            return supportPost.keySet().contains(uri);
        }
    }
    public void init(){
        Method[] methodgs = httpServetGet.getClass().getMethods();
        for(Method m : methodgs) {
            supportGet.put(m.getName(), "1");
        }
        Method[] methodps = httpServetPost.getClass().getMethods();
        for(Method m : methodps) {
            supportPost.put(m.getName(), "1");
        }
    }
    public void addRequest(Class clazz,METHOD method){

    }
    public void addRequest(Class clazz){
        addRequest(clazz,METHOD.GET);
    }
    private void call(String uri,HttpRequestPacket httpRequestPacket,HttpResponsePacket httpResponsePacket,METHOD method) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if(isSupported(uri.substring(1),method)){
            httpResponsePacket.setVersion(VERSION.one_one);
            httpResponsePacket.setStatus(STATUS.OK);
            Map<String,String> config = httpResponsePacket.getConfig();
            //config.put("Cache-Control", httpRequestPacket.config.get("Cache-Control"));
            config.put("Content-Type","text/html;charset=utf-8");
           // config.put("Content-length")
            Method method1 = this.httpServetGet.getClass().getMethod(uri.substring(1),new Class[]{HttpResponsePacket.class,HttpRequestPacket.class});
            method1.invoke(httpServetGet,httpResponsePacket,httpRequestPacket);
        }else{
            httpResponsePacket.setVersion(VERSION.one_one);
            httpResponsePacket.setStatus(STATUS.FOUND);
            httpResponsePacket.setReason("can't support the function");
        }
    }
    public void call(String uri,HttpRequestPacket httpRequestPacket,HttpResponsePacket httpResponsePacket) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        call(uri,httpRequestPacket,httpResponsePacket,httpRequestPacket.method);
    }
}
