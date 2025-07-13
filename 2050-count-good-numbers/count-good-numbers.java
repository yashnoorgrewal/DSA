class Solution {
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long first = power(5, even);
        long second = power(4, odd);
        return (int) ((first * second) % MOD);
    }
    
    private long MOD = 1_000_000_007;

    private long power(long x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        long half = power(x, n/2);
        if(n % 2 == 0){
            return (half * half) % MOD;
        }else{
            return (half * half * x) % MOD;
        }
    }
}