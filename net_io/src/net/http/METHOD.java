package net.http;

public enum METHOD {
    GET,
    POST,
    HEAD,
    DEL;
}
enum VERSION{
    one_one;
}
enum STATUS{
    OK,  //200
    Created,  //201
    Moved,   //301
    FOUND,      //302
    FORBIDDEN,  //403
    NOT_FOUND,    //404
    SERVER_ERROR, //500
    SERVER_UNAVALIABLE, //503
    HTTP_VERSION_ERROR; // 505
}





