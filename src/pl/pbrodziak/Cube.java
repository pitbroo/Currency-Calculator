package pl.pbrodziak;

public class Cube {
    String currency;
    double rate;

    public Cube(String currency, Float rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public Cube setRate(Float rate) {
        this.rate = rate;
        return this;
    }
}
