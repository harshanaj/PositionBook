package com.ibank.positionbook;

import com.ibank.model.EventType;
import com.ibank.model.TradeEvent;
import org.junit.Before;
import org.junit.Test;

public class BookContainerTest {

    private BookContainer bookContainer;

    @Before
    public void setUp() throws Exception {
        bookContainer = new BookContainer();
    }

    @Test
    public void addTradeEvent() {
        // Buying Securities
        bookContainer.addTradeEvent(new TradeEvent(1, EventType.BUY, "ACC1", "SEC1", 100));
        bookContainer.addTradeEvent(new TradeEvent(2, EventType.BUY, "ACC1", "SEC1", 50));

        StringBuilder sb = new StringBuilder();
        bookContainer.print("ACC1", "SEC1");

        // Buying different Securities
        bookContainer.clear();

        bookContainer.addTradeEvent(new TradeEvent(3, EventType.BUY, "ACC1", "SEC1", 12));
        bookContainer.addTradeEvent(new TradeEvent(4, EventType.BUY, "ACC1", "SECXZY", 50));
        bookContainer.addTradeEvent(new TradeEvent(5, EventType.BUY, "ACC2", "SECXZY", 33));
        bookContainer.addTradeEvent(new TradeEvent(6, EventType.BUY, "ACC1", "SEC1", 20));

        bookContainer.printAll();

        // Buying and Selling Securities
        bookContainer.clear();

        bookContainer.addTradeEvent(new TradeEvent(10, EventType.BUY, "ACC1", "SEC1", 100));
        bookContainer.addTradeEvent(new TradeEvent(11, EventType.SELL, "ACC1", "SEC1", 50));

        bookContainer.printAll();

        // Cancelling events
        bookContainer.clear();

        bookContainer.addTradeEvent(new TradeEvent(21, EventType.BUY, "ACC1", "SEC1", 100));
        bookContainer.addTradeEvent(new TradeEvent(21, EventType.CANCEL, "ACC1", "SEC1", 0));
        bookContainer.addTradeEvent(new TradeEvent(22, EventType.BUY, "ACC1", "SEC1", 5));

        bookContainer.printAll();
    }

    @Test
    public void print() {
    }

    @Test
    public void printAll() {
    }

    @Test
    public void clear() {
    }
}