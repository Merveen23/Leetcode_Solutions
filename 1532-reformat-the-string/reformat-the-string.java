class Solution {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for(char c : s.toCharArray()) {
            if(Character.isLetter(c))
                letters.add(c);
            else
                digits.add(c);
        }

        if(Math.abs(letters.size() - digits.size()) > 1)
            return "";

        StringBuilder result = new StringBuilder();
        boolean letterTurn = letters.size() >= digits.size();

        int i = 0, j = 0;
        while(i < letters.size() || j < digits.size()) {
            if(letterTurn && i < letters.size())
                result.append(letters.get(i++));
            else if(!letterTurn && j < digits.size())
                result.append(digits.get(j++));

            letterTurn = !letterTurn;
        }
        return result.toString();
    }
}