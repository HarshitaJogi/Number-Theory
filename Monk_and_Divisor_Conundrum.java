import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Monk_and_Divisor_Conundrum{

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

	static int N = 100;
    static int n = 0;
    static int arr [] = new int[N];
    static int [] cnt = new int[N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        Arrays.fill(cnt, 0);

        n = sc.nextInt();
        
        int max_number = -1;
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            arr[i] = x;
            max_number = Math.max(max_number, x);
        }


        int t = sc.nextInt();
 
        cnt[0] = 0;
        cnt[1] = n; 
        
        for(int i=2; i<max_number; i++){
            //cnt[i] = 1;  <-- WRONG
            for(int j=i; j<=max_number; j+=i){
                // if(cnt[i] != -1){
                //     if(isPresent(j) == true){
                //         cnt[i]++;
                //     }
                // }
                if(isPresent(j) == true){
                    cnt[i]++;
                }
            }
        }


        // for(int i=0; i<10; i++){
        //     System.out.println(i + " " + cnt[i]);
        // }

        for(int i=0; i<t; i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            int lcm = lcm(p, q);

            int ans = cnt[p] + cnt[q] - cnt[lcm];
            System.out.println(ans);
        }

	}

    static int gcd (int a, int b){
        if((a%b) == 0) return b;
        return gcd(b, a%b);
    }

    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    static boolean isPresent(int a){
        boolean ans = false;
        for(int i=0; i<n; i++){
            if(arr[i] == a){
                ans = true;
                break;
            }
        }
        return ans;
    }
}