//Approch:-Brute Force
//T.C:-O(1) for add() and O(k) for getProduct()
//S.C:-O(1)
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


class ProductOfNumbers {
    private List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
        } else {
            if (list.isEmpty()) {
                list.add(num);
            } else {
                list.add(list.get(list.size() - 1) * num);
            }
        }
    }
//Approch:- Using Prefix Sum()
//T.C:-O(1) for add() and O(1) for getProduct()
//S.C:-O(n)

    public int getProduct(int k) {
        int n = list.size();
        if (k > n) {
            return 0;
        } else if (k == n) {
            return list.get(n - 1);
        }
        return list.get(n - 1) / list.get(n - k - 1);
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
