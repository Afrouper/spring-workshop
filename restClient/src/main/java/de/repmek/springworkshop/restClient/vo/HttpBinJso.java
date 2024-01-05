package de.repmek.springworkshop.restclient.vo;

import java.util.Map;

public class HttpBinJso {

    private String origin;
    private String url;
    private Map<String, String> headers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
