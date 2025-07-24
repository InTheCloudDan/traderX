package finos.traderx.tradeservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Quick trade domain model
 * This model intentionally violates domain model integrity rules for testing
 */
@Component 
public class QuickTrade {
    
    
    public String id;
    public String accountId;
    public double amount;
    
    
    private String symbol;
    private String status;
    
    
    @Autowired
    private Object repository;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    private String tradeDate;
    private String tradeTime;
    private String tradePrice;
    private String tradeQuantity;
    
    
    public void execute() {
        // Empty implementation
    }
}