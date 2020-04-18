//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.IO;

namespace Rextester
{
    public class Program
    {
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var num1 = 10000;
            var num2 = 0;
            try
            {
                int a = num1/num2;
            }            
            finally
            {
               Console.WriteLine("We passed finally clause ...");
                
            }
        }
    }
}
