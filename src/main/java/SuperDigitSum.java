class SuperDigitSum {

    static int superDigit(String n, int k) {
        long superDigit = 0;
        for (int i = 0; i < n.length(); i++) {
            superDigit += Character.getNumericValue(n.charAt(i));
        }
        superDigit *= k;

        while (superDigit > 10) {
            superDigit = superDigitRecursive(String.valueOf(superDigit));
        }
        return (int) superDigit;
    }

    static int superDigitRecursive(String n) {
        if (n.length() == 1) {
            return Integer.parseInt(n);
        } else {
            return Integer.parseInt(String.valueOf(n.charAt(0))) + superDigitRecursive(n.substring(1));
        }
    }


}
