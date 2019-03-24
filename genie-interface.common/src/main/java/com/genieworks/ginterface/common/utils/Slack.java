package com.genieworks.ginterface.common.utils;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Setter
public class Slack {

    private String applicationName;
    private String slackWebHookUrl;

    public void sendSlack(String channel, String text) {
        String body =   "{                                              " +
                        "    \"channel\": \"" + channel+ "\"            " +
                        "  , \"username\": \"" + applicationName + "\"  " +
                        "  , \"text\": \"" + text + "\"                 " +
                        "}                                              ";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(body, requestHeaders);

        ResponseEntity<String> result = restTemplate.exchange(slackWebHookUrl, HttpMethod.POST, requestEntity, String.class);
    }
}

