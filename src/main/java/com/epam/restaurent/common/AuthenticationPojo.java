package com.epam.restaurent.common;

public class AuthenticationPojo {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    AuthenticationPojo(AuthenticationBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class AuthenticationBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public AuthenticationBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public AuthenticationBuilder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public AuthenticationBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public AuthenticationBuilder setPassword(String password){
            this.password = password;
            return this;
        }

        public AuthenticationPojo build(){
            return new AuthenticationPojo(this);
        }
    }
}
