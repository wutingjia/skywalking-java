package org.apache.skywalking.apm.testcase.tomcatclient.controller;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/case")
public class CaseController {

    @RequestMapping("/tomcatclient")
    @ResponseBody
    public String tomcatClientScenario() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://127.0.0.1:18080/tomcatserver-10.x-scenario/case/tomcat-10.x-scenario");
        try (final CloseableHttpResponse response = httpClient.execute(httpget)) {
            final HttpEntity entity = response.getEntity();
            try {
                return entity != null ? EntityUtils.toString(entity) : "";
            } catch (final ParseException ex) {
                throw new ClientProtocolException(ex);
            }
        }
    }

    @RequestMapping("/healthCheck")
    @ResponseBody
    public String healthCheck() throws Exception {
        return "Success";
    }
}
