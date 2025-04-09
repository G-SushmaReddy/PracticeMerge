package payloads;

public class Authenticate {

    private String username;
    private String password;
    private Boolean rememberMe;

    private Authenticate(AuthenticateBuilder builder)
    {
        this.username = builder.username;
        this.password = builder.password;
        this.rememberMe = builder.rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public static class AuthenticateBuilder{
        private String username;
        private String password;
        private Boolean rememberMe;

        public AuthenticateBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }

        public AuthenticateBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }

        public AuthenticateBuilder setRememberMe(Boolean rememberMe)
        {
            this.rememberMe = rememberMe;
            return this;
        }

        public Authenticate build(){
            return new Authenticate(this);
        }
    }
}
