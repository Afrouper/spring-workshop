package de.repmek.springworkshop.restclient;

import de.repmek.springworkshop.restclient.vo.HttpBinJso;
import org.springframework.web.service.annotation.GetExchange;

public interface HttpBinClient {

    @GetExchange("/get")
    String get();

    @GetExchange("/get")
    HttpBinJso getJson();
}
