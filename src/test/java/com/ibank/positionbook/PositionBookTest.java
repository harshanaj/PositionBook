package com.ibank.positionbook;

import com.ibank.model.EventKey;
import com.ibank.model.EventType;
import com.ibank.model.TradeEvent;
import org.junit.Before;
import org.junit.Test;

public class PositionBookTest {

    private PositionBook positionBook;

    @Before
    public void setUp() throws Exception {
        EventKey eventKey = new EventKey("ACC1", "SEC1");
        positionBook = new PositionBook(eventKey);
    }

    @Test
    public void getTotalQty() {
        positionBook.clear();

        TradeEvent tr1 = new TradeEvent(1, EventType.BUY, "ACC1", "SEC1", 100);
        TradeEvent tr2 = new TradeEvent(2, EventType.BUY, "ACC1", "SEC1", 150);

        positionBook.addEvent(tr1);
        positionBook.addEvent(tr2);

        assert(positionBook.getTotalQty() == 250);
    }

    @Test
    public void print() {
        positionBook.clear();

        TradeEvent tr1 = new TradeEvent(1, EventType.BUY, "ACC1", "SEC1", 100);
        TradeEvent tr2 = new TradeEvent(2, EventType.BUY, "ACC1", "SEC1", 150);

        positionBook.addEvent(tr1);
        positionBook.addEvent(tr2);

        StringBuilder sb = new StringBuilder();
        positionBook.print(sb);
    }

    @Test
    public void addEvent() {
        positionBook.clear();

        // Buy and Sell
        TradeEvent tr1 = new TradeEvent(1, EventType.BUY, "ACC1", "SEC1", 100);
        TradeEvent tr2 = new TradeEvent(2, EventType.SELL, "ACC1", "SEC1", 50);

        positionBook.addEvent(tr1);
        positionBook.addEvent(tr2);

        assert(positionBook.getTotalQty() == 50);

        // Buy and Cancel
        positionBook.clear();

        TradeEvent tr3 = new TradeEvent(1, EventType.BUY, "ACC1", "SEC1", 100);
        TradeEvent tr4 = new TradeEvent(1, EventType.CANCEL, "ACC1", "SEC1", 0);

        positionBook.addEvent(tr3);
        positionBook.addEvent(tr4);

        assert(positionBook.getTotalQty() == 0);

        // Buy and Cancel
        positionBook.clear();

        TradeEvent tr5 = new TradeEvent(1, EventType.SELL, "ACC1", "SEC1", 200);
        TradeEvent tr6 = new TradeEvent(1, EventType.CANCEL, "ACC1", "SEC1", 0);

        positionBook.addEvent(tr5);
        positionBook.addEvent(tr6);

        assert(positionBook.getTotalQty() == 0);

    }
}