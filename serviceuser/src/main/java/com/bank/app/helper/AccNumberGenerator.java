package com.bank.app.helper;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
@Component
public class AccNumberGenerator {

	private static final String BANK_CODE = "123";
    private static final String BRANCH_CODE = "001";

    
    // Ideally, this sequence should come from a database or Redis to be globally unique
    private final AtomicLong sequence = new AtomicLong(100000); // starts from 100000
  
    public String generateAccountNumber() 
    {
    long nextSeq = sequence.getAndIncrement();
    return BANK_CODE + BRANCH_CODE + String.format("%06d", nextSeq);
    }
}
