! 
! 
!                           Test FORTRAN variables
! 
! 


program variableTesting
implicit none

   ! declaring variables
   integer :: total      
   real :: average 
   complex :: cx  
   logical :: end 
   character(len=80) :: message ! a string of 80 characters
   
   !assigning values
   total = 20000  
   average = 1666.67   
   end = .true.   
   message = "A big Hello from cis424!" 
   cx = (3.0, 5.0) ! cx = 3.0 + 5.0i

   Print *, total
   Print *, average
   Print *, cx
   Print *, end
   Print *, message
   
end program variableTesting
