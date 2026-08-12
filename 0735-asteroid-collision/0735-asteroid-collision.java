class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] < 0){
                boolean alive = true;
                while(!stack.isEmpty() && stack.peek() > 0){
                    int temp = stack.pop();
                    if(Math.abs(asteroids[i]) == temp){
                        alive = false;
                        break;
                    } 
                    else if(Math.abs(asteroids[i]) > temp){
                    }
                    else{
                        stack.push(temp);
                        alive = false;
                        break;
                    }
                }
                if(alive){
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}