package com.solvians.showcase;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class CertificateUpdate {

    private long timestamp;
    private String isin;
    private double bidPrice;
    private int bidSize;
    private double askPrice;
    private int askSize;
    private LocalDate maturityDate;

    public CertificateUpdate(long timestamp, String isin, double bidPrice, int bidSize, double askPrice, int askSize, LocalDate maturityDate) {
    }


    @Override
    public String toString() {
        return "CertificateUpdate{" +
                "timestamp=" + timestamp +
                ", isin='" + isin + '\'' +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", maturityDate=" + maturityDate +
                '}';
    }
}
