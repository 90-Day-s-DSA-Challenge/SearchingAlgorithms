public class NextGreaterLetter {
//    744. Find Smallest Letter Greater Than Target
//    https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';

        System.out.println(nextGreatestLetter(letters, target));

    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target >= letters[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

            /**
             start = 0
             end = 2

             mid = 0 + (2-0)/2 = 1;

             letters[1] = 'f'
             target = 'a'

             if (target >= letters[mid]) → 'a' >= 'f' → FALSE

             end = mid - 1 = 0
             --------------------------------------------------

             start = 0
             end = 0

             mid = 0 + (0 - 0) / 2 = 0
             letters[mid] = 'c'

             if (target >= letters[mid]) → 'a' >= 'c' → FALSE

             end = mid - 1 = -1

             --------------------------------------------------
             start = 0
             end = -1

             loop end


             */
        }

        return letters[start % letters.length];

        /**

         return letters[start % letters.length]
         = letters[0 % 3]
         = letters[0]
         = 'c'
         */

    }
}
