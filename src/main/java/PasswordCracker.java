import java.util.stream.Collectors;

class PasswordCracker {

    static String passwordCracker(java.util.List<String> passwords, String loginAttempt) {
        StringBuffer currentWord = new StringBuffer();
        java.util.Map<Integer, java.util.List<String>> candidates = new java.util.HashMap<>();

        for (int i = 0; i < loginAttempt.length(); i++) {
            currentWord.append(loginAttempt.charAt(i));

            java.util.List<String> candidate = null;
            for (java.util.Map.Entry<Integer, java.util.List<String>> entry : candidates.entrySet()) {
                if (passwords.contains(loginAttempt.substring(entry.getKey(), i + 1))) {
                    candidate = new java.util.ArrayList<>(entry.getValue());
                    candidate.add(loginAttempt.substring(entry.getKey(), i + 1));
                    break;
                }
            }
            if (candidate != null) {
                candidates.put(i + 1, candidate);
            }

            if (passwords.contains(currentWord.toString())) {
                candidates.put(i + 1, java.util.Arrays.asList(currentWord.toString()));
            }
        }

        if (candidates.get(loginAttempt.length()) != null) {
            return candidates.get(loginAttempt.length()).stream().collect(Collectors.joining(" "));
        } else {
            return "WRONG PASSWORD";
        }
    }
}
