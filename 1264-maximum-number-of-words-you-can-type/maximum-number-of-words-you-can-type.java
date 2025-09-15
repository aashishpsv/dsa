class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
         boolean[] broken = new boolean[26];
        for (char b : brokenLetters.toCharArray()) broken[b - 'a'] = true;

        int count = 0;
        boolean wordHasBroken = false;
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (!wordHasBroken) ++count;
                wordHasBroken = false;
            } else {
                if (!wordHasBroken && broken[c - 'a']) wordHasBroken = true;
            }
        }
        if (!wordHasBroken) ++count;
        return count;
    }
}