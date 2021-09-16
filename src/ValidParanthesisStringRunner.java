import java.util.Stack;

public class ValidParanthesisStringRunner {
    public static void main(String args[]){
        ValidParanthesisString validParanthesisString = new ValidParanthesisString();
        String input ="(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(validParanthesisString.check(input));
        validParanthesisString.count(input);
    }
}

class ValidParanthesisString {
    public void count(String input){
        int count_1 =0;
        int count_2 =0;
        int count_3 =0;
        char []inputArray = input.toCharArray();
        for(int i=0;i<input.length();i++){
            if(Character.valueOf(inputArray[i]).toString().equals("(")){
                count_1++;
            }else if(Character.valueOf(inputArray[i]).toString().equals(")")){
                count_2++;
            }else {
                count_3++;
            }
        }
        System.out.println("Count_1: "+count_1+"Count2 : "+count_2+"Count 3 : "+count_3);
    }
    public boolean check(String input){
        boolean result =false;
        if(input.length()<=0){
            // check if length of string is greater than 1
            return result;
        }
        char []inputArray = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackOfStar = new Stack<>();
        for(int i=0;i<input.length();i++){
            if(Character.valueOf(inputArray[i]).toString().equals("(")){
                stack.push(inputArray[i]);
            }else if (Character.valueOf(inputArray[i]).toString().equals("*")){
                stackOfStar.push(inputArray[i]);
            }else{
                // check if there is
                if(!stack.empty()){
                    if(Character.valueOf(stack.peek()).toString().equals("(")){
                        stack.pop();
                    }
                }else if(!stackOfStar.empty()){
                    stackOfStar.pop();
                }else{
                    return false;
                }

            }
        }
        return checkStacks(stack,stackOfStar);
    }
    public boolean checkStacks(Stack stack , Stack stackOfStars){
        if(stack.empty()){
            return true;
        }else{
            if(stackOfStars.empty()){
                return false;
            }else{
                if(stack.size()<= stackOfStars.size()){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}
