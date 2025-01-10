class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] needs = new int[26];
        int[] temp;
        
        for (String word : words2) {
            temp = new int[26];
            
            for (char alpha : word.toCharArray()) {
                temp[alpha - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                needs[i] = Math.max(needs[i], temp[i]);
            }
        }

        List<String> answer = new ArrayList();

        for (String word : words1) {
            temp = new int[26];

            for (char alpha : word.toCharArray()) {
                temp[alpha - 'a']++;
            }

            boolean isUniversal = true;

            for (int i = 0; i < 26; i++) {
                if (temp[i] < needs[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                answer.add(word);
            }
        }
    

        return answer;
    }
}