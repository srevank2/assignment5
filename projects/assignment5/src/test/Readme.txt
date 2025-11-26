Part1-A Readme — Smell1AlmostBest.toPower tests

1) Positive exponent normal cases: 2^1, 2^2, 2^3, 1.5^2 -- equivalence class positive/positive
2) Exponent zero: x^0 = 1 for non-zero x -- boundary
3) Base zero: 0^3 = 0 and 0^0 = 1 (implementation-defined) -- boundary
4) Negative exponent: 2^-2 -> 0.25 -- negative testing/equivalence
5) Negative base odd/even: (-2)^3 = -8, (-2)^2 = 4 -- branch on sign
6) Large exponent: check overflow or Infinity handling
7) NaN base: invalid input handling

All tests are black-box (no modifications to production code).
