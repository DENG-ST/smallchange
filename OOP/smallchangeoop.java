package smallchange.OOP;
//此类用来实现零钱通的各个功能 面向对象的方法
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallchangeoop {
    //属性
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

    //方法
    //总功能
    public void mainMenu(){
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
                    this.detail();
                    break;
                case"2":
                    this.income();
                    break;
                case"3":
                    this.pay();
                    break;
                case"4":
                    this.exit();
                    break;
                default:
                    System.out.println("输入错误");
            }
        }while(loop);
        System.out.println("========零钱通已退出========");
    }
    //子功能
    public void detail(){
        System.out.println(details);
    }
    public void income(){
        System.out.print("收益入账金额：");
        money=scanner.nextDouble();
        if(money<=0){
            System.out.println("金额应该大于0");
            return;
        }
        balance+=money;
        date=new Date();
        details+="\n收益入账\t+"+money+"\t"+sdf.format(date)+"\t余额："+balance;
    }
    public void pay(){
        System.out.print("消费说明：");
        costnote=scanner.next();
        System.out.print("消费金额：");
        money=scanner.nextDouble();
        if(money<=0 || money>balance){
            System.out.println("消费金额应该在0-"+balance);
            return;
        }
        balance-=money;
        date=new Date();
        details+="\n"+costnote+"\t+"+money+"\t"+sdf.format(date)+"\t余额："+balance;
    }
    public void exit(){
        String choice="";
        while(true){
            System.out.println("你确定要退出吗？y/n");
            choice=scanner.next();
            if(choice.equals("y")||choice.equals("n"))
                break;
        }
        if(choice.equals("y"))
            loop=false;
    }
}
