namespace C__study;

class Program
{
    static void Main(string[] args)
    {
        int n = Convert.ToInt32(Console.ReadLine());
        string input = Console.ReadLine();
        string[] villages = input.Split(' ');
        int max = -1;
        int idx = 0;
        for (int i = 0; i < n; i++)
        {
            int tmp = Convert.ToInt32(villages[i]);
            if (tmp > max)
            {
                idx = i;
                max = tmp;
            }
        }
        villages[idx] = "0";
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += Convert.ToInt32(villages[i]);
        }
        Console.WriteLine(sum);
    }
}
