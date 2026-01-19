using System.Text;

namespace C__study;

class Program
{
    static void Main(string[] args)
    {

        int n = Convert.ToInt32(Console.ReadLine());
        HashSet<string> set = new HashSet<string>();

        string[] inputs = new string[n];
        for (int i = 0; i < n; i++)
        {
            char[] c = Console.ReadLine().ToCharArray();
            Array.Reverse(c);
            inputs[i] = new string(c);
        }
        int res = 0;
        for (int i = 0; i < inputs[0].Length; i++)
        {
            bool flag = false;
            int idx = 0;
            for (int j = 0; j < n; j++)
            {
                string tmp = "";
                for (int k = 0; k < i + 1; k++)
                {
                    tmp += inputs[j][k];
                }
                if (!set.Add(tmp)) // 중복되면 더 볼 필요도 없이 i++
                {
                    break;
                } else // 아직 중복이 안됐으면
                {
                    idx++;
                }
            }
            set.Clear();
            if (idx == n) {
                res = i + 1;
                break;
            }
            
        }
        Console.WriteLine(res);
    }
}
