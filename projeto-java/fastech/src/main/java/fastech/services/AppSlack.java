/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.services;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import org.json.JSONObject;

/**
 *
 * @author igor
 */
public class AppSlack {

    public static void slackSendMessage(String slackMessage) throws Exception {

        ConnectionSlack slack = new ConnectionSlack();

        JSONObject newJson = new JSONObject();
        newJson.put("text", slackMessage);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
        newJson.write(writer);
        writer.flush();

        String reconstitutedJSONString = new String(out.toByteArray(), "utf-8");
        JSONObject message = new JSONObject(reconstitutedJSONString);
    
        slack.sendMessage(message);

    }
}
