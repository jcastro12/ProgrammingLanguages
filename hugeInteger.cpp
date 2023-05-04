// Author: Joshua Castro 
// Lab 1
// Date: February 2023
// This is the hugeInteger class with all required and requested methods and functionality
// sources used: https://stackoverflow.com/questions/2346806/what-is-a-segmentation-fault
// https://www.freecodecamp.org/news/string-to-int-in-c-how-to-convert-a-string-to-an-integer-example/
// https://cplusplus.com/reference/vector/vector/at/
// https://stackoverflow.com/questions/12702561/iterate-through-a-c-vector-using-a-for-loop

#include "hugeInteger.h"
#include<vector>
#include<string>
#include<iostream>
using namespace std;

// null constructor, creates a new hugeInteger with value "0"
// @param none
// @return none
    hugeInteger::hugeInteger()
    {
        data = new vector<int>();
        data -> push_back(0);
    }
// copy constructor, creates a new hugeInteger with value of hugeInteger "other"
// @param hugeInteger other to copy
// @return none
    hugeInteger::hugeInteger(const hugeInteger &other)
    {
        data = new vector<int>();
        for (auto i = other.data -> begin(); i != other.data -> end(); i++)
        {
            data -> push_back(*i);
        }
    }
// string constructor, creates a new hugeInteger with value based on string input, omitting non-numeric values
// @param string s
// @return none
    hugeInteger::hugeInteger(const string &s)
    {
        data = new vector<int>();
        for(int x = 0; x < s.size(); x++)
        {
            if(isdigit(s[x]))
            {
                data -> push_back((int)s[x]);
            }
        }
    }
// delete method to delete data vector
// @param none
// @return none
    hugeInteger::~hugeInteger()
    {
        delete data;
    }
// overloaded "=" operator, returns a copy of "other" data
// @param hugeInteger other to copy
// @return data pointer of new vector
    hugeInteger hugeInteger::operator=(const hugeInteger &other) const
    {
        for (auto i = other.data -> begin(); i != other.data -> end(); i++)
        {
            data->push_back(other.data -> at(*i));
        }
        return *this;
    }
// overloaded "==" operator, returns t/f if all elements of hugeInteger = all elements of other
// @param hugeInteger other to compare
// @return t/f representing equality of all elements in both data vectors
    bool hugeInteger::operator==(const hugeInteger &other) const
    {
        bool ret = true;
        if(this -> data -> size() != other.data -> size())
        {
            ret = false;
        }
        else 
        {
            for(int x = 0; x < this -> data -> size(); x++)
            {
                if(this -> data -> at(x) != other.data -> at(x))
                {
                    ret = false;
                }
            }
        }
        return ret;
    }
// overloaded "+" operator, returns a a new hugeInteger with data equal to sum of called data and param data
// @param hugeInteger other with data to be added
// @return new hugeInteger using string constructor, string is sum of two data vectors
    hugeInteger hugeInteger::operator+(const hugeInteger &other) const
    {
        long result = stoi(this -> toString()) + stoi(other.toString());
        string res = to_string(result);
        return hugeInteger(res);
    }
// overloaded ">" operator, returns a t/f showing if called hugeInteger is > param hugeInteger
// @param hugeInteger other to compare
// @return t/f representing if called hugeInteger is > than param hugeInteger
    bool hugeInteger::operator>(const hugeInteger &other) const
    {
        if(this -> data -> size() > other.data -> size())
        {
            return true;
        }
        else if (this -> data -> size() < other.data -> size())
        {
            return false;
        }
        else
        {
            for(int x = 0; x < this -> data -> size(); x++)
            {
                if (this -> data -> at(x) > other.data -> at(x))
                {
                    return true;
                }
                else if (this -> data -> at(x) < other.data -> at(x))
                {
                    return false;
                }
            }
        }
        return false;
    }
// isZero method, checks if each value in data vector is 0
// @param none
// @return t/f representing if hugeInteger is 0 or not
    bool hugeInteger::isZero() const
    {
        bool ret = true;
        for(int x = 0; x < this -> data -> size(); x++)
        {
            if(this -> data -> at(x)!=0)
            {
                ret = false;
            }
        }
        return ret;
    }
// toString method, converts data vector to a string 
// @param none
// @return string with value representing hugeInteger data vector
    string hugeInteger::toString() const
    {
        if (this -> data -> size() == 0)
        {
            string ret = "";
            return ret.c_str();
        }
        else
        {
            string s = "";
            for(int x = 0; x < this -> data -> size(); x++)
            {
                s = s+(char)(this -> data -> at(x));
            }
            return s.c_str();
        }
    }
