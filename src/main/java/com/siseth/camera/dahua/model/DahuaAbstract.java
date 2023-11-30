package com.siseth.camera.dahua.model;

import com.siseth.camera.dahua.config.DahuaConfig;
import lombok.SneakyThrows;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class DahuaAbstract {
    protected String username;
    protected  String password;

    protected String url;
    protected String basicUrl;

    protected void valid(){
        if(this.username == null || this.password == null || this.basicUrl == null)
            throw new RuntimeException("Missing parameter");
    }

    @SneakyThrows
    protected byte[] getBytes() {
        return getEntity().getContent().readAllBytes();
    }
    protected Map<String, String> process() {
        return convert(decode(getEntity()));
    }

    private HttpEntity getEntity() {
        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(DahuaConfig.getTimeoutConfig())
                .build();
        HttpGet httpGet = new HttpGet(url.replaceAll(" ", "%20"));
        HttpContext httpContext = new BasicHttpContext();
        CloseableHttpResponse httpResponse = null;
        HttpEntity result = null;
        try {
            httpResponse = httpClient.execute(httpGet, httpContext);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
                Header authHeader = httpResponse.getFirstHeader(AUTH.WWW_AUTH);
                DigestScheme digestScheme = new DigestScheme();


                digestScheme.processChallenge(authHeader);

                UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
                httpGet.addHeader(digestScheme.authenticate(creds, httpGet, httpContext));

                httpResponse.close();
                httpResponse = httpClient.execute(httpGet);
            }
            result = new BufferedHttpEntity(httpResponse.getEntity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Cannot connect to camera");
        }finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private Map<String, String> convert(String response) {
        Map<String, String> map = new HashMap<>();
        String[] list = response.split("\n");
        if(list.length == 1 && (list[0].equals("OK\r") || list[0].equals("OK"))){
            map.put("result", "OK");
        } else if((list[0].equals("Error\r") || list[0].equals("Error"))){
            map.put("result", "Error");
        } else {
            for (String s : list) {
                String[] parts = s.split("=");
                if (parts[0] != null)
                    map.put(parts[0], parts[1].trim());
            }
        }
        return map;
    }

    @SneakyThrows
    private String decode(HttpEntity entity) {
        return entity != null ?
                EntityUtils.toString(entity) :
                "";
    }
}


