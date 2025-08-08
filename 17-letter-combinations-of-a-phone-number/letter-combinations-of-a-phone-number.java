class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        generateCombos(new StringBuilder(), digits, 0);
        return res;
    }

    private void generateCombos(StringBuilder temp, String digits, int index) {
        // Base condition: A full combination is formed when the index reaches the end of digits string.
        if (index == digits.length()) {
            res.add(temp.toString());
            return;
        }

        // Get the current digit and its corresponding letters.
        char digit = digits.charAt(index);
        String letters = map.get(digit);

        // Iterate through all possible letters for the current digit.
        for (char letter : letters.toCharArray()) {
            // 1. Choose: Append the letter to the current combination.
            temp.append(letter);

            // 2. Explore: Recurse to the next digit.
            generateCombos(temp, digits, index + 1);

            // 3. Un-choose (Backtrack): Remove the last added letter to explore other combinations.
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}