public class ThreeRecursionTypesExplained {

    // Dicotomico = lavorare sugli indici per dividerli in due ogni volta finchè left==right
    public static boolean dicotomico(int[] array, int left, int right) {
        boolean retVal = true; // Usiamo un booleano per tenere in memoria il valore da restituire, così useremo return una sola volta
        if (left == right) { // Questo è sempre uguale per qualsiasi esercizio dicotomico, serve per individuare il caso base ovvero quando non dobbiamo più dividere in due parti
            if (array[left] == 0) { // Questo check varia in base all'esercizio. A noi serve che l'array contenga ALMENO una volta il valore 0
                retVal = true; // Settiamo il valore del return invece che fare direttamente qui return true (così vuole il prof, ma è stupido)
            }
            else {
                retVal = false; // Settiamo il valore del return invece che fare direttamente qui return true (così vuole il prof, ma è stupido)
            }
        }
        else {
            int halfIndex = (left + right) / 2; // Calcola l'indice della metà della porzione di array che ci interessa. Notare che funziona sia con numero di elementi dell'array pari che dispari
            retVal = dicotomico(array, left, halfIndex) || dicotomico(array, halfIndex + 1, right); // Lancia la ricorsione sulle due nuove porzioni di array considerate
        }
        return retVal;
    }

    // Covariante == la variabile usata come contatore (in questo caso currentIndex) decresce con il decrescere della difficoltà del problema
    public static boolean covariante(int[] array, int currentIndex) {
        boolean retVal = false;
        if (currentIndex < 0) { // Caso base, la ricorsione ha già controllato tutti gli indici da a.length - 1 a 0, quindi per evitare di finire in un ciclo infinito facciamo un return false che non andrà ad alterare il risultato booleano finale in quanto abbiamo un OR (||)
            retVal = false;
        }
        else {
            retVal = array[currentIndex] == 0 || covariante(array, currentIndex - 1); // Usiamo || perchè vogliamo che ALMENO un elemento dell'array sia 0. Se volessimo che tutti fossero 0 basterebbe sostituire con && MA AL TEMPO STESSO CAMBIARE IL RETURN del caso base a true perchè altrimenti un false invaliderebbe l'AND.
        }
        return retVal;
    }

    // Controvariante == la variabile usata come contatore (in questo caso currentIndex) CRESCE con il DE-CRESCERE della difficoltà del problema
    public static boolean controVariante(int[] array, int currentIndex) {
        boolean retVal = false;
        if (currentIndex >= array.length) {
            retVal = false; // Caso base, la ricorsione ha già controllato tutti gli indici da 0 a a.length - 1, quindi per evitare di finire in un ciclo infinito facciamo un return false che non andrà ad alterare il risultato booleano finale in quanto abbiamo un OR (||)
        }
        else {
            retVal = array[currentIndex] == 0 || controVariante(array, currentIndex + 1); // Usiamo || perchè vogliamo che ALMENO un elemento dell'array sia 0. Se volessimo che tutti fossero 0 basterebbe sostituire con && MA AL TEMPO STESSO CAMBIARE IL RETURN del caso base a true perchè altrimenti un false invaliderebbe l'AND.
        }
        return retVal;
    }

    public static boolean wrapperDicotomico(int[] array) {
        return dicotomico(array, 0, array.length - 1); // Usiamo un wrapper per evitare di dover chiamare direttamente il metodo dicotomico() dovendogli passare 0 e array.length - 1...è più comodo!
    }

    public static boolean wrapperCovariante(int[] array) {
        return covariante(array, array.length - 1); // Usiamo un wrapper per evitare di dover chiamare direttamente il metodo wrapperCovariante() dovendogli passare array.length - 1 come indice iniziale da cui partire...è più comodo!
    }

    public static boolean wrapperControVariante(int[] array) {
        return controVariante(array, 0); // Usiamo un wrapper per evitare di dover chiamare direttamente il metodo wrapperControVariante() dovendogli passare 0 come indice iniziale da cui partire...è più comodo!
    }

    public static void main(String[] args) {
        // Vogliamo verificare se ALMENO un elemento del seguente array ha valore 0
        int[] arr = { 5, 0, 7, 5, 7, 2 };

        System.out.println(wrapperDicotomico(arr));
        System.out.println(wrapperCovariante(arr));
        System.out.println(wrapperControVariante(arr));
    }
}