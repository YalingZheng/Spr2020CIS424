/****************************************************************************
Buffer overflow
For example, most implementations of the C programming language do not perform array bounds checking. 
One can then exploit the implementation of the programming language by the compiler and 
the computer architecture's assembly language conventions, 
to achieve aliasing effects by writing outside of the array (a type of buffer overflow). 
This invokes undefined behaviour according to the C language specification; 
however many implementations of C will show the aliasing effects described here.

If an array is created on the stack, with a variable laid out in memory directly beside that array, 
one could index outside the array and directly change the variable by changing the relevant array element. 
For example, if there is an int array of size 2 (for this example's sake, calling it arr), 
next to another int variable (call it i), arr[2] (i.e., the 3rd element) 
would be aliased to i if they are adjacent in memory.

*******************************************************************************/

#include <stdio.h>

int main()
{
      int arr[2] = { 1, 2 };
      int i=10;
    
      /* Write beyond the end of arr. Undefined behaviour in standard C, will write to i in some implementations. */
      arr[2] = 20;
    
      printf("element 0: %d \t", arr[0]); // outputs 1
      printf("element 1: %d \t", arr[1]); // outputs 2
      printf("element 2: %d \t", arr[2]); // outputs 20, if aliasing occurred
      printf("i: %d \t\t", i); // might also output 20, not 10, because of aliasing, but the compiler might have i stored in a register and print 10
      /* arr size is still 2. */
      printf("arr size: %d \n", (sizeof(arr) / sizeof(int)));
}

