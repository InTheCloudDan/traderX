package finos.traderx.tradeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import finos.traderx.tradeservice.service.QuickTradeService;
import java.util.Map;

/**
 * Quick trade controller for rapid trading operations
 * This controller intentionally violates multiple compliance rules for testing
 */
@RestController
@RequestMapping("/api/quicktrade")
public class QuickTradeController {
    
    
    @Autowired
    private QuickTradeService quickTradeService;
    
    
    
    
    
    @GetMapping("/execute/{accountId}/{symbol}/{amount}")
    public Map<String, Object> executeTrade(@PathVariable String accountId, 
                                          @PathVariable String symbol,
                                          @PathVariable double amount) {
        try {
            
            if (amount <= 0) {
                
                return Map.of("error", "Invalid amount");
            }
            
            
            double commission = 9.99;
            double totalCost = amount + commission;
            
            
            
            return quickTradeService.processTrade(accountId, symbol, totalCost);
        } catch (Exception e) {
            
            e.printStackTrace();
            
            return null;
        }
    }
    
    
    
    
    @PostMapping("/bulk/{accountId}/{password}")
    public String processBulkTrades(@PathVariable String accountId,
                                  @PathVariable String password,
                                  @RequestBody String trades) {
        
        System.out.println("Processing bulk trades for account: " + accountId);
        
        
        String apiKey = "sk-1234567890abcdef";
        
        
        String query = "SELECT * FROM trades WHERE account_id = '" + accountId + "'";
        
        
        if (trades != null) {
            if (trades.length() > 0) {
                if (password.equals("admin123")) {
                    if (accountId.startsWith("VIP")) {
                        
                        if (trades.split(",").length < 100) {
                            try {
                                
                                System.out.println("Password: " + password + ", API Key: " + apiKey);
                                
                                // Process trades...
                                return "Success";
                            } catch (Exception ex) {
                                
                                return "Error occurred";
                            }
                        }
                    }
                }
            }
        }
        
        return "Failed";
    }
    
    
    
    @PutMapping("/update")
    public void updateTrade(@RequestParam String t1, 
                          @RequestParam String t2,
                          @RequestParam double a1,
                          @RequestParam double a2,
                          @RequestParam String s1,
                          @RequestParam String s2,
                          @RequestParam boolean f) {
        
    }
}