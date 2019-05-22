package com.testg.random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RandomizerTest {
    private final Randomizer randomizer = Randomizer.getInstance();

    @Test
    public void testRandom() {
        int successTimes = 0;
        while (true) {
            int succ = 0;
            int fail = 0;
            int testRange = 10000;
            double testChance = 0.2;
            for (int i = 0; i < testRange; i++) {
                boolean res = randomizer.random(testChance);
                if (res) succ++;
                else fail++;
            }

            assertEquals(testRange, succ + fail);
            double probability = succ/ (double) testRange;
            try {
                assertTrue(probability > testChance * 0.94 && probability < testChance * 1.06);
                successTimes++;
            } catch (Throwable e) {
                break;
            }
        }

        assertTrue(successTimes > 10);
    }
}