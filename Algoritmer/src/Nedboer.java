
public class Nedboer {
    private static int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */

    public static void main(String[] args)
    {
        bedsteTreFerieUger();
        bedsteFerieUgerStart(1);
    }
    
    public static int bedsteTreFerieUger() {

        int minRainfall = Integer.MAX_VALUE;
        int bestStartIndex = 0;

        for (int i = 0; i < nedboerPrUge.length - 2; i++) {
            int currentRainfall = nedboerPrUge[i] + nedboerPrUge[i + 1] + nedboerPrUge[i + 2];
            if (currentRainfall < minRainfall) {
                minRainfall = currentRainfall;
                bestStartIndex = i;
            }
        }
        System.out.println(bestStartIndex);
        return bestStartIndex;
    }
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */
    
    public static int bedsteFerieUgerStart(int antal) {
        int minRainfall = Integer.MAX_VALUE;
        int bestStartIndex = 0;
        for(int i = 0; i < nedboerPrUge.length - antal; i++)
        {
            int currentRainfall = 0;
            for (int x = 0; x < antal; x++) {
            currentRainfall += nedboerPrUge[i + x];
        }

            if (currentRainfall < minRainfall) {
                minRainfall = currentRainfall;
                bestStartIndex = i;
            }
        }
        System.out.println(bestStartIndex);
        return bestStartIndex;
    }
    
    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        // TODO return -1 kun indsat så der ikke er compile fejl
        return -1;
    }
}
