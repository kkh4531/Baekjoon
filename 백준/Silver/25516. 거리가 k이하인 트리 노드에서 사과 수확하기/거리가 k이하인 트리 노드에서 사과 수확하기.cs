using System.Text;

namespace C__study;

class Program
{

    static List<List<int>> graph;
    static int k;
    static void Main(string[] args)
    {

        string[] input = Console.ReadLine().Split(' ');

        int v = Convert.ToInt32(input[0]);
        k = Convert.ToInt32(input[1]);

        graph = new List<List<int>>();

        for (int i = 0; i < v; i++) graph.Add(new List<int>());

        for (int i = 0; i < v - 1; i++)
        {
            string[] tmp = Console.ReadLine().Split(' ');
            int parent = Convert.ToInt32(tmp[0]);
            int child = Convert.ToInt32(tmp[1]);
            graph[parent].Add(child);
        }

        apples = Console.ReadLine().Split(' ');


        tree();
        System.Console.WriteLine(cnt);
    }

    static int cnt;
    static string[] apples;
    private static void tree()
    {
        cnt = 0;
        Queue<int> queue = new Queue<int>();
        queue.Enqueue(0);
        if (apples[0] == "1") cnt++;
        bool flag = false;
        int cnt2 = 0;
        while (queue.Count != 0)
        {
            if (flag) break;
            int size = queue.Count;
            for (int i = 0; i < size; i++)
            {
                int now = queue.Dequeue();
                foreach (int nv in graph[now])
                {
                    if (cnt2 < k)
                    {
                        if (apples[nv] == "1") cnt++;
                        queue.Enqueue(nv);

                    } else
                    {
                        flag = true;
                    }
                }
            }
            cnt2++;
        }
    }
}
