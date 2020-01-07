package com.example;

/**
 * 模拟 servlet 登录
 */
public class LoginServlet {

    private static String username;
    private static String password;

    synchronized public static void doPost(String name,String pwd){

        try {
            username = name;

            if("a".equals(username)){
                Thread.sleep(5000);
            }
            password = pwd;
            System.out.println("username="+username+" , password="+password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


class Run{
    public static void main(String[] args) {

        /**
         *  synchronized 排队进入方法，谁先得到线程，谁先执行
         *
         *  不加 非线程安全，b先执行，a则等待5秒执行
         */

        Alogin alogin = new Alogin();
        Blogin blogin = new Blogin();
        alogin.start();
        blogin.start();

    }
}


/**
 * 登录用户A
 */
class Alogin extends Thread{

    @Override
    public void run(){
        LoginServlet.doPost("a","123");
    }
}

/**
 * 登录用户B
 */
class Blogin extends Thread{
    @Override
    public void run(){
        LoginServlet.doPost("b","456");
    }
}

