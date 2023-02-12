import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sieve_algorithm{

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	static int N = (int)1E7;
    static boolean [] isPrime = new boolean [N];
    static int [] lowestPrime = new int [N];
    static int [] highestPrime = new int [N];


    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        
        // initially consider all numbers prime
        for(int i=0; i<N; i++){
            isPrime[i] = true;
        }

       isPrime[0] = isPrime[1] = false;

       for(int i=2; i<N; i++){
            if(isPrime[i] == true){
                lowestPrime[i] = highestPrime[i] = i;
                // make all multiples of i false
                for(int j=2*i; j<N; j+=i){
                    isPrime[j] = false;
                    highestPrime[j] = i;
                    if(lowestPrime[j] == 0){
                        lowestPrime[j] = i;
                    }
                }
            }
       }

       // to check first 10 numbers
       // for(int i=0; i<=10; i++){
       //      System.out.print(lowestPrime[i] + " ");
       //      System.out.println(highestPrime[i]);
       // }


       // to find prime factors of a given number
       int num = 6;
       ArrayList<Integer> prime_factors = new ArrayList<Integer>();

       while(num>1){
            int prime_factor = highestPrime[num];
            while(num % prime_factor == 0){
                num = num / prime_factor;
                prime_factors.add(prime_factor);
            }
       }

       for(int a : prime_factors){
        System.out.print(a + " ");
       }


       



	}
}