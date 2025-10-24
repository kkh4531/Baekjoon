import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Candidate implements Comparable<Candidate> {
    int num;

    public Candidate(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Candidate o) {
        return o.num - this.num;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        
        int dasomVotes = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Candidate> otherCandidates = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            otherCandidates.offer(new Candidate(num));
        }

        int bribeCount = 0;

        if (n == 1) {
            System.out.println(0);
            return;
        }

        while (true) {
            if (otherCandidates.isEmpty() || dasomVotes > otherCandidates.peek().num) {
                break;
            }

            Candidate topOtherCandidate = otherCandidates.poll();
            
            topOtherCandidate.num--;
            dasomVotes++;
            bribeCount++;

         
            otherCandidates.offer(topOtherCandidate);
        }

        System.out.print(bribeCount);
    }
}
