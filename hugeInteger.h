#include<vector>
#include<string>
using namespace std;
class hugeInteger
{
    private:
        vector<int> *data;
    public:
        hugeInteger();
        hugeInteger(const hugeInteger &other);
        hugeInteger(const string &s);
        ~hugeInteger();
        hugeInteger operator=(const hugeInteger &other) const;
        bool operator==(const hugeInteger &other) const;
        hugeInteger operator+(const hugeInteger &other) const;
        bool operator>(const hugeInteger &other) const;
        bool isZero() const;
        string toString() const;
};