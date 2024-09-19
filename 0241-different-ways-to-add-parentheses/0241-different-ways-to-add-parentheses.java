class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>(); //to store result

        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            
            if(c == '+' || c == '-' || c=='*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                
                for(int x:left){
                    for(int y:right){
                        if(c == '+'){
                            result.add(x+y);
                        }
                        else if(c == '-'){
                            result.add(x-y);
                        }
                        else{
                            result.add(x*y);
                        }
                    }
                }
            }
            
        }
        //if there is no operater then we directly add string to result
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }
        return result;
        
    }
}