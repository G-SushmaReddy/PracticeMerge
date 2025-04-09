package payloads;

public class BankAccount {
    private int id;
    private String name;
    private double balance;

    private BankAccount(BankAccountBuilder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.balance = builder.balance;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getBalance(){
        return this.balance;
    }

    public static class BankAccountBuilder{
        private int id;
        private String name;
        private double balance;

        public BankAccountBuilder setId(int id)
        {
            this.id = id;
            return this;
        }

        public BankAccountBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        public BankAccountBuilder setBalance(double balance)
        {
            this.balance = balance;
            return this;
        }

        public BankAccount build(){
            return new BankAccount(this);
        }
    }
}
