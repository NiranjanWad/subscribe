package com.subscriptions.subscribe;

public class Netflix {
    private final long id;
    private final String content;

    public Netflix(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
