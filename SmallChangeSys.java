package smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[]args){
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        String key="";

        //此处的零钱通明细我们采用简单的string拼接实现。还可以用数组存记录，但是数组大小没法确定不能动态增加；或者用对象。
        String details="-----------零钱通明细------------";
        double money=0;
        double balance=0;

        Date date=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");//必须用HH MM

        String costnote = "";


        do{
            System.out.println("====================零钱通菜单===================");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退    出");
            System.out.print("请选择1-4：");
            key=scanner.next();
            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case"2":
                    System.out.print("收益入账金额：");
                    money=scanner.nextDouble();
                    if(money<=0){
                        System.out.println("金额应该大于0");
                        break;
                    }
                    balance+=money;
                    date=new Date();
                    details+="\n收益入账\t+"+money+"\t"+sdf.format(date)+"\t余额："+balance;
                    break;
                case"3":
                    System.out.print("消费说明：");
                    costnote=scanner.next();
                    System.out.print("消费金额：");
                    money=scanner.nextDouble();
                    if(money<=0 || money>balance){
                        System.out.println("消费金额应该在0-"+balance);
                        break;
                    }
                    balance-=money;
                    date=new Date();
                    details+="\n"+costnote+"\t+"+money+"\t"+sdf.format(date)+"\t余额："+balance;
                    break;
                case"4":
                    String choice="";
                    while(true){
                        System.out.println("你确定要退出吗？y/n");
                        choice=scanner.next();
                        if(choice.equals("y")||choice.equals("n"))
                            break;
                    }
                    if(choice.equals("y"))
                        loop=false;
                    break;
                default:
                    System.out.println("输入错误");
            }
        }while(loop);
        System.out.println("========零钱通已退出========");

    }

}
