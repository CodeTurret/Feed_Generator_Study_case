package com.solvians.showcase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // TODO: Implement me.
        List<CertificateUpdate> updateList = new ArrayList<CertificateUpdate>();
        ISINGenerator isinGenerator = new ISINGenerator();
        for (int i = 0; i < threads * quotes; i++) {
            long timestamp = System.currentTimeMillis();
            String isin = isinGenerator.generateISIN();

            double bidPrice = round2(random.nextDouble(100.00, 200.01));
            int bidSize = random.nextInt(1000, 5001);
            double askPrice = round2(random.nextDouble(100.00, 200.01));
            int askSize = random.nextInt(1000, 10001);
            LocalDate maturityDate = LocalDate.now().plusDays(random.nextInt(1, 730));

            updateList.add(new CertificateUpdate(timestamp, isin, bidPrice, bidSize,
                    askPrice, askSize, maturityDate));
        }

        return updateList.stream();
    }

    /**
     * Add this method to precisely count the two digit values
     * @param value
     * @return double
     */
    private double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
