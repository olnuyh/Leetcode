class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList();

        for (String word1 : words) {
            for (String word2 : words) {
                if (word1.equals(word2)) {
                    continue;
                }

                if (word2.contains(word1)) {
                    answer.add(word1);
                    break;
                }
            }
        }

        return answer;
    }
}