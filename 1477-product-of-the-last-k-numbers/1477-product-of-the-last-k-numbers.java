class ProductOfNumbers {
    private List<Integer> list;
    private int n;

    public ProductOfNumbers() {
        list=new ArrayList<>();
        n=0;
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int prod=1;
        int n=list.size();
        for(int i=n-k;i<n;i++){
            prod*=list.get(i);
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */