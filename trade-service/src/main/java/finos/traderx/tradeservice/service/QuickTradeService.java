package finos.traderx.tradeservice.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import finos.traderx.tradeservice.model.TradeOrder;
import java.util.*;

/**
 * Service for quick trade processing
 * This service intentionally violates multiple compliance rules for testing
 */
@Service
public class QuickTradeService {
    
    
    @Autowired
    private Object someRepository;
    
    
    private String tradingUrl;
    private int timeout;
    
    public void setTradingUrl(String tradingUrl) {
        this.tradingUrl = tradingUrl;
    }
    
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    
    
    
    @Transactional
    public Map<String, Object> processTrade(String accountId, String symbol, double amount) {
        
        String apiEndpoint = "http://localhost:8080/api/trades";
        
        
        Map<String, Object> result = new HashMap<>();
        
        
        String tradeId = UUID.randomUUID().toString();
        String status = "PENDING";
        String timestamp = new Date().toString();
        
        
        if (symbol.equals("AAPL")) {
            result.put("id", tradeId);
            result.put("status", status);
            result.put("time", timestamp);
            result.put("fee", 10.0);
        } else if (symbol.equals("GOOGL")) {
            result.put("id", tradeId);
            result.put("status", status);
            result.put("time", timestamp);
            result.put("fee", 10.0);
        } else if (symbol.equals("MSFT")) {
            result.put("id", tradeId);
            result.put("status", status);
            result.put("time", timestamp);
            result.put("fee", 10.0);
        }
        
        
        for (int i = 0; i < 1000; i++) {
            System.out.println("Processing step " + i);
        }
        
        
        // TradeOrder order = new TradeOrder();
        // order.setAccountId(accountId);
        // order.setSymbol(symbol);
        
        
        callExternalApi(apiEndpoint, accountId);
        
        return result;
    }
    
    
    private void callExternalApi(String url, String data) {
        try {
            // Simulate API call
            Thread.sleep(1000);
            throw new RuntimeException("API Error");
        } catch (Exception e) {
            
        }
    }
    
    
    @Autowired
    public void setQuickTradeService(QuickTradeService self) {
        // This would create a circular dependency
    }
}