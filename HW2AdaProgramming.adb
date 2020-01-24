with Ada.Text_IO; use Ada.Text_IO;
procedure jdoodle is
   -- Assertion makes Ada reliable, you need to add 
   -- something as below for your homework
   -- pragma Assertion_Policy (Pre => Check, Post => Check)
   procedure DB_Entry (Name: String; Age: in out Integer)
   -- Precondition will be checked before the procedure
   -- Postcondition will be checked after the procedure
   -- You need to add something as below for your homework
   -- with Pre => Age >= 1,
   --      Post => Age <= 150
   is 
   begin
      Age := Age + 50;
      Put_Line(Name);
    end DB_Entry;
    currentage: Integer;
begin
    currentage := 3;
    DB_Entry("John", currentage);
    currentage:= 135;
    DB_Entry("", currentage);
end jdoodle;
