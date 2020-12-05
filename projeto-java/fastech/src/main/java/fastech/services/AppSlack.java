/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.services;

import org.json.JSONObject;

/**
 *
 * @author igor
 */
public class AppSlack {
    public static void slackSendMessage(String slackMessage) throws Exception {

        ConnectionSlack slack = new ConnectionSlack();

        JSONObject message = new JSONObject();
        message.put("text", slackMessage);
        
        slack.sendMessage(message);

    }
}
