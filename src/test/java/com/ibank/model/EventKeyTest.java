package com.ibank.model;

import org.junit.Before;
import org.junit.Test;

public class EventKeyTest {

    private EventKey eventKey, emptyEventKey;

    @Before
    public void setUp() throws Exception {
       eventKey = new EventKey("ACC1", "SEC1");
       emptyEventKey = new EventKey("", "");
    }

    @Test
    public void getAccount() {
        assert(eventKey.getAccount() == "ACC1");
    }

    @Test
    public void getSecurity() {
        assert(eventKey.getSecurity() == "SEC1");
    }

    @Test
    public void testEquals() {
        // check with same object
        assert(eventKey.equals(eventKey));

        // check instanceOf
        String testString = new String("ACC1");
        assert(!eventKey.equals(testString));

        // check with same Account and Security
        EventKey newEventKey = new EventKey("ACC1", "SEC1");
        assert(eventKey.equals(newEventKey));

        // check empty
        EventKey emptyEventKey = new EventKey("", "");
        assert(!eventKey.equals(emptyEventKey));

        // check different
        EventKey differentEventKey = new EventKey("ACC2", "SEC2");
        assert(!eventKey.equals(differentEventKey));
    }

    @Test
    public void testHashCode() {
        EventKey newEventKey = new EventKey("ACC1", "SEC1");
        assert(eventKey.hashCode() == newEventKey.hashCode());
    }

    @Test
    public void testGetAccount() {
    }

    @Test
    public void testGetSecurity() {
    }

    @Test
    public void testEquals1() {
    }

    @Test
    public void testHashCode1() {
    }
}