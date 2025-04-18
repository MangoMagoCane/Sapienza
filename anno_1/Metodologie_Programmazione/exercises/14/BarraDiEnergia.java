public class BarraDiEnergia {
    protected int k;
    protected final int max = 10;

    void increase() {
        k++;
    }

    public String toString() {
        StringBuilder bar = new StringBuilder();

        for (int i = 0; i < k; i++) {

            bar.append("O");
        }
        for (int i = k; i < max; i++) {
            bar.append("=");
        }

        return bar.toString();
    }

    public static void main(String[] args) {
        BarraDiEnergia bar = new BarraDiEnergia();
        bar.increase();
        bar.increase();
        bar.increase();
        System.out.println(bar);

        BarraDiEnergia bar2 = new BarraDiEnergiaConPercentuale();
        bar2.increase();
        bar2.increase();
        bar2.increase();
        System.out.println(bar2);
    }
}
