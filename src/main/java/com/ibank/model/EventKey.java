package com.ibank.model;

import java.util.concurrent.atomic.AtomicInteger;

public class EventKey {
    private final String account;
    private final String security;

    /**
     * This method is used to initialize EventKey.
     * @param account Trading account
     * @param security  Trading security identifier
     */
    public EventKey(String account, String security) {
        this.account = account;
        this.security = security;
    }

    /**
     * Getter method for trading account.
     * @return String trading account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Getter method for trading account.
     * @return String trading Security identifier
     */
    public String getSecurity() {
        return security;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EventKey))
            return false;
        EventKey other = (EventKey)o;
        return (this.account != null && other.account != null && this.account.equals(other.account)) &&
                (this.security != null && other.security != null && this.security.equals(other.security));
    }

    @Override
    public final int hashCode() {
        AtomicInteger result = new AtomicInteger(17);
        if (account != null) {
            result.set(31 * result.get() + account.hashCode());
        }
        if (security != null) {
            result.set(31 * result.get() + security.hashCode());
        }
        return result.get();
    }
}
