package com.ibank.model;

public class TradeEvent {

    private final int eventId;
    private final EventType eventType;
    private final String account;
    private final String security;
    private final int quantity;

    /**
     * This method is used to initialize Trade Event.
     * @param eventId trade event id
     * @param eventType trade event type (Buy, Sell or Cancel)
     * @param account trade event account
     * @param security trade event security identifier
     * @param quantity trade event quantity
     */
    public TradeEvent(int eventId, EventType eventType, String account, String security, int quantity) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.account = account;
        this.security = security;
        this.quantity = quantity;
    }

    /**
     * This method is used to print the trade event details.
     * @param builder StringBuilder to append the print contain
     */
    public void print(StringBuilder builder) {
        builder.append("\t\t[id: ");
        builder.append(eventId);
        builder.append(", ");
        builder.append(getEventType().toString());
        builder.append(", ");
        builder.append(account);
        builder.append(", ");
        builder.append(security);
        builder.append(", ");
        builder.append(quantity);
        builder.append("]\n");
    }

    public int getEventId() {
        return eventId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getAccount() {
        return account;
    }

    public String getSecurity() {
        return security;
    }

    public int getQuantity() {
        return quantity;
    }
}
