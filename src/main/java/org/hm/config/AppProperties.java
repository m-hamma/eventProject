package org.hm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Data
@Component
public class AppProperties {

    private Jwt jwt;
    private Pagination pagination;

    @Data
    public static class Jwt {
        private String secret;
        private long expiration;
    }

    @Data
    public static class Pagination {
        private int defaultPageSize;
        private int maxPageSize;
    }
}