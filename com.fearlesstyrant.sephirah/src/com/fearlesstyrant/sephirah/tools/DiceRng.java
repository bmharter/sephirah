package com.fearlesstyrant.sephirah.tools;

public final class DiceRng {
	public interface Source { int[] ints(int num, int min, int max); }

    private static volatile Source source = new JavaRng(); // default

    public static void setSource(Source newSource) {
        source = java.util.Objects.requireNonNull(newSource);
    }

    public static Source getSource() { return source; }
    public static void set(Source s) { source = s; }

    public static final class JavaRng implements Source {
        private final java.util.Random rnd;
        public JavaRng() { this.rnd = new java.util.Random(); }
        public JavaRng(long seed) { this.rnd = new java.util.Random(seed); }
        @Override public int[] ints(int num, int min, int max) {
            int[] out = new int[num];
            for (int i = 0; i < num; i++) out[i] = min + rnd.nextInt((max - min) + 1);
            return out;
        }
    }

    public static final class RandomOrgSource implements Source {
        @Override public int[] ints(int num, int min, int max) { 
            return Dice.trueRandom(num, min, max); // call your existing method
        }
    }
}
