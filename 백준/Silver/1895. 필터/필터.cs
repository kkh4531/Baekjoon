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
            string input = Console.ReadLine();
            string[] tmp = input.Split(' ');
            int r = Convert.ToInt32(tmp[0]);
            int c = Convert.ToInt32(tmp[1]);

            int[,] map = new int[r, c];
            for (int i = 0; i < r; i++)
            {
                string str = Console.ReadLine();
                string[] splits = str.Split(' ');
                for (int j = 0; j < c; j++)
                {
                    map[i, j] = Convert.ToInt32(splits[j]);
                }
            }

            List<int> list = new List<int>();
            for (int i = 0; i < r; i++)
            {
                for (int j = 0; j < c; j++)
                {
                    if (!(j + 2 >= c || i + 2 >= r)) // 범위 안에 있음.
                    {
                        int[] tmpArr = new int[9];
                        tmpArr[0] = map[i, j]; tmpArr[1] = map[i, j + 1]; tmpArr[2] = map[i, j + 2];
                        tmpArr[3] = map[i + 1, j]; tmpArr[4] = map[i + 1, j + 1]; tmpArr[5] = map[i + 1, j + 2];
                        tmpArr[6] = map[i + 2, j]; tmpArr[7] = map[i + 2, j + 1]; tmpArr[8] = map[i + 2, j + 2];
                        Array.Sort(tmpArr);
                        list.Add(tmpArr[4]);
                    }
                }
            }
            int T = Convert.ToInt32(Console.ReadLine());
            int cnt = 0;
            foreach (int i in list)
            {
                if (i >= T) cnt++;
            }
            Console.WriteLine(cnt);
        }
    }
}
