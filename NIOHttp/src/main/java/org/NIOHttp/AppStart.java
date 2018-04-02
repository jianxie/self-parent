package org.NIOHttp;

/**
 * 服务器
 * @author jian.xie
 */
public class AppStart 
{
    public static void main( String[] args )
    {
    	new Thread(new Server()).start();
    }
}
