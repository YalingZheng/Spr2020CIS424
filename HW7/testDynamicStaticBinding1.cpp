/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

// C++ program to illustrate concept of static binding
#include <iostream>
#include <chrono> 
using namespace std;
using namespace std::chrono; 
class ComputeMulti
{
	public:

	int multi(int x, int y)
	{
		return x * y;
	}
};

class B
{
	public:
    	virtual int multi(int x, int y)
    	{
    	    cout<<"B multi called"<<endl;
    		return x * y;
    	}
};

class D: public B
{
	public:
    	int multi(int x, int y)
    	{
    	    cout<<"D multi called"<<endl;
    		return x * y;
    	}
};


int main()
{
    int numObjs = 1;
	ComputeMulti objs[numObjs];
	auto start = high_resolution_clock::now(); 
	for (int i=0; i<numObjs;i++){
	    objs[i].multi(10,20);
	  // cout << "Multiplication is " << obj.multi(10, 20) << '\n';
	}
	auto stop = high_resolution_clock::now(); 
	auto duration = duration_cast<microseconds>(stop - start); 
   // To get the value of duration use the count() 
   // member function on the duration object 
    cout << duration.count() << endl; 
   
	B baseobjs[numObjs];
	D derivedobjs[numObjs];
	B *basePtrs[numObjs];
	for (int i=0; i<numObjs;i++){
	    B* tempbasePtr = &(baseobjs[i]);
	    basePtrs[i] = tempbasePtr;
	    basePtrs[i]->multi(10, 20);
	    B* tempbasePtr2 = &(derivedobjs[i]);
	    basePtrs[i] = tempbasePtr2;
	    basePtrs[i]->multi(10, 20);
	  // cout << "Multiplication is " << obj.multi(10, 20) << '\n';
	}
	start = high_resolution_clock::now();
    for (int i=0; i<numObjs;i++){
	    basePtrs[i]->multi(10, 20);
	  // cout << "Multiplication is " << obj.multi(10, 20) << '\n';
	}
	stop = high_resolution_clock::now(); 
	duration = duration_cast<microseconds>(stop - start); 
  
    // To get the value of duration use the count() 
   // member function on the duration object 
   cout << duration.count() << endl; 
	return 0;
}
