public class Main {

    public static void main(String[] args) {
        String[] shipNames = {
            "N2 Bomber",
            "J-Type 327",
            "NX Cruiser",
            "N1 Starfighter",
            "Royal Cruiser"
        };
        String[] classes = {
            "Heavy Fighter",
            "Light Combat",
            "Medium Fighter",
            "Medium Fighter",
            "Light Combat"
        };
        String[] deployments = {
            "Limited",
            "Unlimited",
            "Limited",
            "Unlimited",
            "Limited"
        };
        int[] inServiceYears = {
            21,
            1,
            18,
            25,
            4
        };
        System.out.printf("%-15s%-15s%-11s%-10s%n",
                          "SHIP NAME", "CLASS", "DEPLOYMENT", "IN SERVICE");

        for (int i = 0; i < shipNames.length; i++) {
            System.out.printf("%-15s%-15s%-11s%-10d%n",
                              shipNames[i],
                              classes[i],
                              deployments[i],
                              inServiceYears[i]);
        }
    }
}