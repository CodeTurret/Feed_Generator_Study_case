package com.solvians.showcase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateUpdate {

    private  long timestamp;
    private  String isin;
    private  double bidPrice;
    private  int bidSize;
    private  double askPrice;
    private  int askSize;
    private  LocalDate maturityDate;


}
