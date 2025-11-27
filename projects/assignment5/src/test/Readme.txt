Part 1(a) — JUnit5 black-box test mapping
Files:
  - Smell1AlmostBestToPowerTest.java
  - Smell1AlmostBestToPowerExtraCoverageTest.java

1) Boundary cases
   - Exponent zero: testZeroExponent() — verifies x^0 returns 1 for various bases (positive, negative, zero).
   - Base zero: testBaseZero() — checks 0^3 == 0 and 0^0 == 1 (implementation-defined but instructor's impl returns 1).
   - Large exponent: testLargeExponent() — sanity-check for large exponent (no exception; expected numeric value).

2) Negative tests / failure cases (implementation-defined)
   - Negative exponent: testNegativeExponent() — implementation treats negative exponent as loop skip and returns 1; test documents behavior.
   - NaN/infinite cases (extra coverage): tests using reflection check that method does not throw unexpected exceptions.

3) Equivalence classes
   - Positive base, positive exponent (e.g., 2^1, 2^2, 3^2) -> normal cases
   - Negative base with odd exponent -> negative result
   - Negative base with even exponent -> positive result
   - pow == 1 -> returns base unchanged
   - pow large leads to overflow (int) — sanity check only

4) Extra coverage tests and why
   - Smell1AlmostBestToPowerExtraCoverageTest: uses reflection to invoke private toPower and inspects private `__cache` to verify caching behavior:
       * cache population on first calculation
       * subsequent lookups return cached values (multiple powers/entries)
       * pow==1 behavior
   - These extra tests increase branch/instruction coverage and exercise private caching internals without modifying production code.

Notes:
- All tests use JUnit5 (jupiter) and reflection to access the private static toPower method; no production code was changed.
- Reproduction: see run-tests.sh at repository root for commands used to compile, run tests under JaCoCo, and produce HTML reports.
