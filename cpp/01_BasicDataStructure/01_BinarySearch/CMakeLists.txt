cmake_minimum_required(VERSION 3.0)
project(BinarySearch)
set(CMAKE_CXX_STANDARD 14)

aux_source_directory(src 01_BinarySearch)

add_executable(BinarySearch main.cpp 1201_nthUglyNumber.cpp 1011_ShipWithinDays.cpp 875_minEatingSpeed.cpp)