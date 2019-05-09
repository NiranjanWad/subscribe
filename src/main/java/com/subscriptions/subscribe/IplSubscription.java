package com.subscriptions.subscribe;

public class IplSubscription {
    private final long id;
    private final String message;

    public IplSubscription(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
