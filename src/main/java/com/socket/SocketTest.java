package com.socket;

/**desc:Socket编程
 * @author  zhoulk
 * date: 2019/4/29 0029
 */
public class SocketTest {
    public static void main(String[] args) {
        String ss = "12";
        String ss1 = "12";
        String ss2 ="1"+new String("2");
        char[] ss3 ={'1','2'};
        System.out.println(ss==ss1);
        System.out.println(ss.equals(ss1));
        System.out.println(ss==ss2);
        System.out.println(ss.equals(ss2));
      //  System.out.println(ss==ss3.toString());
        String ss4 = new String(ss3);
        String ss5 = ss3.toString();
        System.out.println(ss.equals(ss4));
        System.out.println(ss.equals(ss5));
    }
}
