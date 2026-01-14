using System.Text;

namespace C__study;

class Program
{
    static void Main(string[] args)
    {

        int N = Convert.ToInt32(Console.ReadLine());
        int E = Convert.ToInt32(Console.ReadLine());

        int[] arr = new int[N + 1];
        int cnt = 0;
        for (int i = 0; i < E; i++)
        {
            string[] input = Console.ReadLine().Split(' ');
            int[] inputToInt = new int[input.Length - 1];
            int size = int.Parse(input[0]);
            bool flag = false;
            for (int j = 1; j <= size; j++)
            {
                int tmp = int.Parse(input[j]);
                inputToInt[j - 1] = tmp;
                if (tmp == 1)
                {
                    flag = true;
                    cnt++;
                }
            }
            if (flag)
            {
                for (int j = 1; j <= size; j++)
                {
                    arr[inputToInt[j - 1]]++;
                }
            } else
            {
                int max = arr.Max();
                for (int j = 1; j <= size; j++)
                {
                    arr[inputToInt[j - 1]] = max;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
        {
            if (arr[i] == cnt) sb.Append(i).Append('\n');
        }
        System.Console.WriteLine(sb);
    }
}
