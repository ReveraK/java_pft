package ru.stqa.pft.sendbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Primes;

public class PrimeTest {

  @Test
  public void  testPrimes() {
    Assert.assertTrue(Primes.isPrimesFast(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void  testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimes(n));
  }
  @Test
  public void  testNonPrime() {
   Assert.assertFalse(Primes.isPrimes(Integer.MAX_VALUE - 2));
  }
}
