package finos.traderx.tradeservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

/**
 * Configuration for QuickTrade feature
 * This configuration intentionally violates configuration management principles
 */
@Configuration
public class QuickTradeConfig {
    
    
    private static final String PROD_DB_URL = "jdbc:postgresql://prod-db.example.com:5432/trades";
    private static final String API_KEY = "sk-prod-1234567890";
    
    
    private static final int TIMEOUT = 30000;
    private static final int RETRY_COUNT = 3;
    private static final double FEE_PERCENTAGE = 0.025;
    
    @Bean
    public String databaseUrl() {
        
        return PROD_DB_URL;
    }
    
    @Bean
    public Integer connectionTimeout() {
        
        return TIMEOUT;
    }
    
    
    @Bean
    public Object circularBeanA(Object circularBeanB) {
        return new Object();
    }
    
    @Bean
    public Object circularBeanB(Object circularBeanA) {
        return new Object();
    }
    
    
    @Bean
    public String getApiEndpoint() {
        return "https://api.production.tradingplatform.com/v1/trades";
    }
}