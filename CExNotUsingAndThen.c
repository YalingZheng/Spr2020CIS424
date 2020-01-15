/******************************************************************************

                          C Example Not using And Then

*******************************************************************************/

#include <stdio.h>

int main()
{

    int* arrayint;
    
    if ((arrayint != NULL) && (arrayint[0] >= 100)) {
            printf("arrayint first ele is bigger than 100!");
    }
    else 
        printf("arrayint is EMPTY");
    
    return 0;
}
