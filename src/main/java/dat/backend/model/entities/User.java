package dat.backend.model.entities;

import java.util.Objects;

public class User
{
    private String username;
    private String password;
    private String accounttype;

    private double balance;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public User(String username, String password, String accounttype)
    {
        this.username = username;
        this.password = password;
        this.accounttype = accounttype;
    }

    public double getBalance() {
        return balance;
    }

    public User(String username, String password, String accounttype, double balance) {
        this.username = username;
        this.password = password;
        this.accounttype = accounttype;
        this.balance = balance;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAccounttype()
    {
        return accounttype;
    }

    public void setAccounttype(String accounttype)
    {
        this.accounttype = accounttype;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + accounttype + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.balance, balance) == 0 && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(accounttype, user.accounttype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, accounttype, balance);
    }
}
