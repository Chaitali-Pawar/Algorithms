public class PalindromeRunner {
    public static void main(String args[]){
        PalindromeRunner palindromeRunner = new PalindromeRunner();
        palindromeRunner.isPalindrome(121);
    }
    public boolean isPalindrome(int x) {
        if(Integer.signum(x) == -1){
            return false;
        }
        else{
            char arr[] =Integer.valueOf(x).toString().toCharArray();
            int left = 0;
            int right =arr.length-1;
            while(left<right){
                if(arr[left] != arr[right]){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
