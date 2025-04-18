public class BarraDiEnergiaConPercentuale extends BarraDiEnergia {
    public String toString() {
        StringBuilder bar = new StringBuilder();

        bar.append(super.toString());
        bar.append(" ");
        bar.append(Integer.toString(k*100 /max));
        bar.append("%");

        return bar.toString();
    }
}
