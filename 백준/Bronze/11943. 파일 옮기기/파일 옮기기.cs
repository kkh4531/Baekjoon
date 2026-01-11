using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace study
{
    class Program
    {
        static void Main(string[] args)
        {
            string first = Console.ReadLine();
            string second = Console.ReadLine();
            string[] aArr = first.Split(' ');
            string[] bArr = second.Split(' ');

            int aApple = int.Parse(aArr[0]);
            int bOrange = int.Parse(aArr[1]);
            int cApple = int.Parse(bArr[0]);
            int dOrange = int.Parse(bArr[1]);

            int firstRes = aApple + dOrange;
            int secondRes = bOrange + cApple;

            Console.WriteLine(firstRes > secondRes ? secondRes : firstRes);
        }

        
    }
}
