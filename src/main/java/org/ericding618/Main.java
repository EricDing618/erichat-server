package org.ericding618;

import java.nio.file.Paths;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.String;

import org.ericding618.JsonTool;

public class Main{
    double VERSION = 0.1; //服务端的版本
    String SIGN_IN = "sign:";
    String QUIT = "quit:";
    String resources_dir = Paths.get("./src/main/java").toAbsolutePath().normalize() +"\\resources";

    public String GetTime(){ //获取当前时间，并以“年:月:日 时:分:秒”的格式输出
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public String GetOS(){
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("windows")) {
            return "Windows";
        } else if (os.contains("mac")) {
            return "macOS";
        } else if (os.contains("linux")) {
            return "Linux";
        } else {
            return "Unknown";
        }
    }

    public void PrintTimeSleep(String text){
        // 设置打字速度（毫秒）
        int speed = 50;

        // 逐字打印文本
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\n");
    }

    public void App() {
        PrintTimeSleep(resources_dir);
        PrintTimeSleep("欢迎使用FutureChat Server（v"+VERSION+"）！");
        PrintTimeSleep("当前时间为："+GetTime()+" 。");
        PrintTimeSleep("检测：本程序正在"+GetOS()+"操作系统上运行。");
        PrintTimeSleep("您可以输入“help”获取命令帮助，或者输入“quit”以退出程序。");
        PrintTimeSleep("您还可以输入其他命令，例如“login”或“create”。");
        JsonTool readset = new JsonTool();
        Map a = readset.writeMapToJson();
        System.out.println(readset.);
        int quit = 0;
        while (quit == 0){
            Scanner scan = new Scanner(System.in);
            System.out.print("> ");

            if (scan.hasNextLine()){
                String cmd = scan.nextLine();
                List<String> cmds = Arrays.asList(cmd.split(" "));

                if (cmd.equals("quit")){ //优先判断退出程序命令
                    scan.close();
                    System.out.println("Quit successfully.");
                    quit = 1;

                }else if (cmds.getFirst().equals("help")){
                    System.out.println("ok");

                }else if (cmds.getFirst().equals("login")){

                }else{
                    System.out.println("异常：没有命名为“"+cmds.getFirst()+"”的命令，请输入“help”获取命令帮助。");
                }
            }
        }
    }
    public void RunCommand() {

    }
    public static void main(String[] args) { // 运行
        Main run = new Main();
        run.App();

    }
}