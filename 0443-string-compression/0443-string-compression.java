// in this code i just make new string in which i itterate the while loop main think is all char are together each other thats why it is easy to understand but we need to add last element because array index get bound 

class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        if(chars.length <1){
            return 0;
        }

        int rear = 0 ;
        int front =0;
        while(front< chars.length){
            if(chars[rear] == chars[front]){
                front++;
            }
            else{
                sb.append(chars[rear]);
                int count= front -rear ; 
                if(count > 1){
                    sb.append(count);
                }
                rear=front;
            }
        }
        sb.append(chars[rear]);

        int count = front - rear;
        if (count > 1) {
            sb.append(count);
        }

        char[] ans = sb.toString().toCharArray();
         for (int i = 0; i < ans.length; i++) {
            chars[i] = ans[i];
        }
       return ans.length;
    }
}