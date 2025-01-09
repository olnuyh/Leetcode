class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }

            list.add(temp);
        }

        return list.get(rowIndex);
    }
}