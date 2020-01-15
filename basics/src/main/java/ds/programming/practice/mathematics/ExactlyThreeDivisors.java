package ds.programming.practice.mathematics;

class ExactlyThreeDivisors
{
    
    public int exactly3Divisors(int N)
    {
        int exctly3Divisor =0;
        for(int i = 2 ; i <=N ;i++){
            boolean isPrime = true;
            int j = 2;
            for( ; j <= Math.sqrt(i) ; j++){
                if(i%2==0){
                    isPrime = false;
                }
            }
            if(isPrime && j*j <= i ){
                exctly3Divisor++;
            }
        }
        return exctly3Divisor;
    }
}