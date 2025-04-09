package com.epam.restaurent.common;

public class ExamplePojo {
    private int userId;
    private String title;
    private String body;

    // Private constructor
    private ExamplePojo(Builder builder) {
        this.userId = builder.userId;
        this.title = builder.title;
        this.body = builder.body;
    }

    // Getters (needed for serialization)
    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    // Builder Class
    public static class Builder {
        private int userId;
        private String title;
        private String body;

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public ExamplePojo build() {
            return new ExamplePojo(this);
        }
    }
}
