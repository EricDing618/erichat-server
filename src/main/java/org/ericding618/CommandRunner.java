package org.ericding618;

import java.util.List;
import java.util.Map;
import org.ericding618.JsonTool;
import org.ericding618.tools;

public class CommandRunner {
    JsonTool CommandJson = new JsonTool();
    tools tool = new tools();

    public Boolean CommandNameIsTrue(String cmd) {
        try {
            Map<String, List> Command = CommandJson.parseJSONToMapList(tool.GetResourcePath("CommandConfig.json"));
            boolean value = Command.get("CommandList").contains(cmd);
            return value;
        }catch (Exception e){
            System.out.println("错误：配置损坏。");
            //e.printStackTrace();
            return false;
        }
    }
}
