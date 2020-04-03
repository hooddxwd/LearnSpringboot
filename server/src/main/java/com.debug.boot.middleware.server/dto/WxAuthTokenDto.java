package com.debug.boot.middleware.server.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;


@Configuration
@ConfigurationProperties(prefix = "wx.auth.token")
@Getter
@Setter
public class WxAuthTokenDto implements Serializable {

    private String appId;
    private String appSecrect;
    private String appRandom;
    private Integer appVersion;
}
