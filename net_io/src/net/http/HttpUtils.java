package net.http;

import java.lang.reflect.InvocationTargetException;

public class HttpUtils {

    public static String parseVersionToString(VERSION version){
        if(version == VERSION.one_one){
            return "HTTP/1.1";
        }
        return null;
    }
    public static VERSION parseStringToVersion(String str){
        return VERSION.one_one;
    }
    public static boolean parseStringToHttpPacket(HttpRequestPacket httpRequestPacket,String str){
        int index_r = 0;
        int index_b = 0;
        int index_nb = 0;
        int index_m = 0;
        index_r = str.indexOf('\n');
        if(index_r == -1){
            return false;
        }
        String temp = str.substring(0,index_r);
        if(temp.substring(0,3).equals("GET")){
            httpRequestPacket.setMethod(METHOD.GET);
            temp = temp.substring(4);
        }else if(temp.substring(0,4).equals("POST")){
            httpRequestPacket.setMethod(METHOD.POST);
            temp = temp.substring(5);
        }else if(temp.substring(0,4).equals("HEAD")){
            httpRequestPacket.setMethod(METHOD.HEAD);
            temp = temp.substring(5);
        }else{
            return false;
        }
        index_b = temp.indexOf(' ');
        httpRequestPacket.setUri(temp.substring(0,index_b));
        temp = temp.substring(index_b + 1);
        httpRequestPacket.setVersion(HttpUtils.parseStringToVersion(temp.substring(5)));
        while(true) {
            index_nb = index_r;
            index_r = str.indexOf('\n', index_nb + 1);
            if (index_r == -1 || str.substring(index_nb + 1, index_r + 1).equals("\r\n")) {
                break;
            }
            temp = str.substring(index_nb + 1, index_r - 1);
            index_m = temp.indexOf(":");
            httpRequestPacket.config.put(temp.substring(0, index_m), temp.substring(index_m + 2));
        }
        httpRequestPacket.body = str.substring(index_nb + 2);
        return true;
    }
    public static boolean packedHttpResponsePacket(HttpResponsePacket httpResponsePacket,HttpRequestPacket httpRequestPacket) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HttpServet httpServet = new HttpServet();
        httpServet.init();
        if(httpRequestPacket.method == METHOD.GET){
            httpServet.call(httpRequestPacket.uri,httpRequestPacket,httpResponsePacket);
        }else if(httpRequestPacket.method == METHOD.POST){
            httpServet.call(httpRequestPacket.uri,httpRequestPacket,httpResponsePacket);
        }else{
            httpResponsePacket.setVersion(VERSION.one_one);
            httpResponsePacket.setStatus(STATUS.FOUND);
            httpResponsePacket.setReason("can't support the function");
        }
        return true;
    }
    public static String parseStatusToString(STATUS status){
        String str = null;
        switch (status){
            case OK:
                str = "200";
                break;
            case Created:
                str = "201";
                break;
            case Moved:
                str = "301";
                break;
            case FOUND:
                str = "302";
                break;
            case FORBIDDEN:
                str = "403";
                break;
            case NOT_FOUND:
                str = "404";
                break;
            case SERVER_ERROR:
                str = "500";
                break;
            case SERVER_UNAVALIABLE:
                str = "503";
                break;
            case HTTP_VERSION_ERROR:
                str = "505";
                break;
             default:
                 str = "404";
                 break;

        }
        return str;
    }

}
