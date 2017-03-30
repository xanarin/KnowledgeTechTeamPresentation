public class Squarer {
    private double x;
    private double initZ;
    private int rounds;

    public Squarer(double newX, double newZ, int newRounds) {
        this.x = newX;
        this.initZ = newZ;
        this.rounds = newRounds;
    }

    public double getSquareRoot() {
        double z = initZ;

        for (int i = 0; i < rounds; i++) {
            z = z - (Math.pow(z, 2.0) - x)/(2*z);
        }
        return z;
    }
}
