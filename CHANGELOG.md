# Changelog

## 1.1.0

### Features

* The new `BitMatrix` class, which is a representation of a bi-dimensional array
  of booleans.
* Now using `IntArray` instead of `Array<Int>` in `BitArray` for performance
  purposes.

### Bug fixes

* Fix the bound checks in `BitArray`.

## 1.0

Initial release. The library consist of just the `BitArray` class, which is
a representation of an array of booleans packed into 32-bit integers for
memory-efficiency.
 