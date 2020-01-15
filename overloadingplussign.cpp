/******************************************************************************

This is an example of overloading + in C++. 

The overloading of + is to calculate the summation of an array, instead of
the traditional meaning of + (usually means add two arrays together). 

the programmer defined + used between single-dimensioned array operands to mean the sum of all elements of both arrays. 
Because the usual meaning of vector addition is quite different from this, 
this unusual meaning could confuse both the author and the program’s readers.

This example demonstrates that allowing overloading of + may cause 
the program poor readability.

Run it on https://www.onlinegdb.com

*******************************************************************************/
#include <stdio.h>
#include <stdlib.h>     /* srand, rand */
#include <iostream>

using namespace std;
class RandomArray { 
private: 
    int* array; 
    int size;
public: 
    RandomArray(int r = 0)  {
        size = r;
        if (r > 0) 
            array = new int[r];
        for (int index = 0; index < size; index++)
           array[index] = rand() % 10 + 1;
    } 
      
    // This is automatically called when '+' is used with 
    // between two Complex objects 
    int operator + (int onevar) { 
        int sumofelements = 0;
        for (int index = 0; index < size; index++)
            sumofelements += array[index];
         return sumofelements; 
    } 
    void print() { 
        cout << "The random array is :";
        for (int index = 0; index < size; index++){
            cout << array[index] << " ";
        } 
        cout<<endl;
    }
};

int main()
{
    RandomArray myarray(3);
    
    myarray.print();
    int thesum = myarray + 0 ;
    cout<<thesum;

    return 0;
}
