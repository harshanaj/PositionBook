package com.ibank.positionbook;

import com.ibank.model.EventKey;
import com.ibank.model.TradeEvent;

import java.util.HashMap;
import java.util.Map;

public class BookContainer {

    private final Map<EventKey, PositionBook> books;

    /**
     * This method is used to instantiate the book container.
     * book container kept all position books by event key
     */
    public BookContainer() {
        books = new HashMap<>();
    }

    /**
     * This method is used to add trade event to the position book.
     * @param tradeEvent trade event to add
     */
    public void addTradeEvent(TradeEvent tradeEvent) {
        EventKey eventKey = getEventKey(tradeEvent.getAccount(), tradeEvent.getSecurity());
        PositionBook positionBook = books.get(eventKey);

        if(positionBook == null) {
            positionBook = new PositionBook(eventKey);
            books.put(eventKey, positionBook);
        }

        positionBook.addEvent(tradeEvent);
    }

    /**
     * This method is used to get trade event key
     * @param account trading account
     * @param security security identifier
     */
    private EventKey getEventKey(String account, String security) {
        return new EventKey(account, security);
    }

    /**
     * This method is used to print the particular position book
     * @param account trading account
     * @param security security identifier
     */
    public void print(String account, String security) {
        EventKey eventKey = getEventKey(account, security);
        StringBuilder sb = new StringBuilder();
        PositionBook positionBook = books.get(eventKey);
        if(positionBook != null) {
            positionBook.print(sb);
        }
        System.out.println(sb);
    }

    /**
     * This method is used to print all position books
     */
    public void printAll() {
        StringBuilder sb = new StringBuilder();
        books.forEach((key, value) -> value.print(sb));
        System.out.println(sb);
    }

    /**
     * This method is used to clear all position books
     */
    public void clear() {
        books.clear();
    }
}
