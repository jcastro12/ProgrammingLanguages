// Author: Joshua Castro 
// Lab 1
// Date: February 2023
// this is the main tester class that showcases all requested functionality
#include<iostream>
#include<string>
#include "hugeInteger.h"

using namespace std;

int main()
{
    // default constructor
    hugeInteger h1;
    // string constuctor
    string num = "123abc123";
    hugeInteger h2(num);
    // copy constructor
    hugeInteger h3(h2);
    // overloaded "==" (true)
    bool equal = h2==h3;
    // overloaded "==" (false)
    bool notequal = h1==h3;
    // overloaded "="
    hugeInteger h4 = h3;
    // overloaded "+"
    hugeInteger h5 = h2+h2;
    // overloaded ">" (true)
    bool greater = h5>h2;
    // overloaded "<" (false)
    bool less = h1>h2;
    // iszero (true)
    bool zero = h1.isZero();
    // iszero (false)
    bool zero1 = h2.isZero();
    // prints with tostring and bool results
    cout << h1.toString().c_str() << endl;
    cout << h2.toString().c_str() << endl;
    cout << h3.toString().c_str() << endl;
    cout << equal << endl;
    cout << notequal << endl;
    cout << h4.toString().c_str() << endl;
    cout << h5.toString().c_str() << endl;
    cout << greater << endl;
    cout << less << endl;
    cout << zero << endl;
    cout << zero1 << endl;
    return 0;
}