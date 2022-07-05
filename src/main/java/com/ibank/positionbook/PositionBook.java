package com.ibank.positionbook;

import com.ibank.model.EventKey;
import com.ibank.model.EventType;
import com.ibank.model.TradeEvent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PositionBook {

    private int totalQty;
    private final EventKey eventKey;

    private final Map<Integer, ArrayList<TradeEvent>> eventPosition;

    /**
     * This method is used to instantiate position book.
     * @param eventKey event key of the position book
     */
    public PositionBook(EventKey eventKey) {
        this.totalQty = 0;
        this.eventKey = eventKey;
        eventPosition = new LinkedHashMap<>();
    }

    /**
     * This method return the total quantity of the position book
     * @return int total quantity
     */
    public int getTotalQty() {
        return totalQty;
    }

    /**
     * This method is used to print position book.
     * @param builder String builder for concat all trade event deatils
     */
    public void print(StringBuilder builder) {
        builder.append(eventKey.getAccount());
        builder.append(" ");
        builder.append(eventKey.getSecurity());
        builder.append(" ");
        builder.append(totalQty);
        builder.append("\n");
        eventPosition.forEach((key, value) -> {
            for (TradeEvent tradeEvent : value) {
                tradeEvent.print(builder);
            }
        });
    }

    /**
     * This method is used to add trade event to the position book
     * @param tradeEvent Trade event to add
     */
    public void addEvent(TradeEvent tradeEvent) {
        assert Objects.equals(tradeEvent.getAccount(), eventKey.getAccount());
        assert Objects.equals(tradeEvent.getSecurity(), eventKey.getSecurity());

        switch (tradeEvent.getEventType()){
            case SELL:
                addSellEvent(tradeEvent);
                break;
            case BUY:
                addBuyEvent(tradeEvent);
                break;
            case CANCEL:
                addCancelEvent(tradeEvent);
                break;
        }
    }

    /**
     * This method is used to clear position book
     */
    public void clear() {
        totalQty = 0;
        eventPosition.clear();
    }

    private void addToPosition(TradeEvent tradeEvent) {
        ArrayList<TradeEvent> tradeEventArray = eventPosition.get(tradeEvent.getEventId());
        if(tradeEventArray == null) {
            tradeEventArray =  new ArrayList<>();
            tradeEventArray.add(tradeEvent);
            eventPosition.put(tradeEvent.getEventId(), tradeEventArray);
        } else {
            tradeEventArray.add(tradeEvent);
        }
    }

    private void addBuyEvent(TradeEvent tradeEvent) {
        addToPosition(tradeEvent);
        totalQty += tradeEvent.getQuantity();
    }

    private void addSellEvent(TradeEvent tradeEvent) {
        addToPosition(tradeEvent);
        totalQty -= tradeEvent.getQuantity();
    }

    private void addCancelEvent(TradeEvent tradeEvent) {
        TradeEvent previousEvent = eventPosition.get(tradeEvent.getEventId()).get(0);
        if(previousEvent != null) {
            if(previousEvent.getEventType() == EventType.BUY) {
                totalQty -= previousEvent.getQuantity();
            } else if(previousEvent.getEventType() == EventType.SELL) {
                totalQty += previousEvent.getQuantity();
            }
        }
        addToPosition(tradeEvent);
    }
}
