package com.ibank.model;

import org.junit.Before;
import org.junit.Test;

public class TradeEventTest {

    TradeEvent tr1 = null;
    TradeEvent tr2 = null;

    @Before
    public void setUp() throws Exception {
         tr1 = new TradeEvent(1, EventType.BUY, "ACC1", "SEC1", 100);
    }

    @Test
    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append("\t\t[id: ");
        builder.append(tr1.getEventId());
        builder.append(", ");
        builder.append(tr1.getEventType().toString());
        builder.append(", ");
        builder.append(tr1.getAccount());
        builder.append(", ");
        builder.append(tr1.getSecurity());
        builder.append(", ");
        builder.append(tr1.getQuantity());
        builder.append("]\n");

        StringBuilder sb = new StringBuilder();
        tr1.print(sb);

        assert(sb.toString().contentEquals(builder.toString()));
    }

    @Test
    public void getEventId() {
        assert(tr1.getEventId() == 1);
    }

    @Test
    public void getEventType() {
        assert(tr1.getEventType() == EventType.BUY);
    }

    @Test
    public void getAccount() {
        assert(tr1.getAccount() == "ACC1");
    }

    @Test
    public void getSecurity() {
        assert(tr1.getSecurity() == "SEC1");
    }

    @Test
    public void getQuantity() {
        assert(tr1.getQuantity() == 100);
    }
}