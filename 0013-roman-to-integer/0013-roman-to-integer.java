class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            char next = i < s.length() - 1 ? s.charAt(i + 1) : 0;
            switch (ch) {
                case 'I':
                    if (next == 'V') {
                        result += 4;
                        ++i;
                    } else if (next == 'X') {
                        result += 9;
                        ++i;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (next == 'L') {
                        result += 40;
                        ++i;
                    } else if (next == 'C') {
                        result += 90;
                        ++i;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (next == 'D') {
                        result += 400;
                        ++i;
                    } else if (next == 'M') {
                        result += 900;
                        ++i;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}