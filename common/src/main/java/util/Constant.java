package util;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/12 下午1:44
 */
public class Constant {
    public final static String BasicTypeRedis = "basic-type-redis";
    //链接地址
    public static String WebSocketPathPerfix = "/ws-push";
    public static String WebSocketPath = "/endpointWisely";
    //消息代理路劲
    public static String WebSocketBroadcastPath = "/topic";
    //前端发送给服务端请求地址
    public static final String ForeToServerPath = "/welcome";
    //服务端生产地址，客户端订阅地址以接收服务端生产的消息
    public static final String ProducerPath = "/topic/getResponse";
    //点对点消息推送地址前缀
    public static final String P2pPushBasePath = "/user";
    //点对点消息推送地址后缀，最后的地址为/user/用户识别码/msg
    public static final String P2pPushPath = "/msg";




    public static final String SITESETTINGCACHE_KEY="siteSetting";

}
