import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;                                        

public class bit_masking_eg{

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

	public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        // n is number of workers
        int n = sc.nextInt();


        // ArrayList<Integer> [] masks = new ArrayList [n];
        // for(int i=0; i<n; i++){
        //     masks[i] = new ArrayList<Integer>();
        // }
        // for(int i=0; i<n; i++){
        //     int num_days = sc.nextInt();
        //     for(int j=0; j<num_days; j++){
        //         int day = sc.nextInt();
        //         //System.out.println(day);
        //         days[i].add(day);
        //     }
        // }


        // Instead of storing like this we can store the days in the form of bit masks
        int [] masks = new int [n];
        for(int i=0; i<n; i++){
            int num_days = sc.nextInt();
            int mask = 0;
            for(int j=0; j<num_days; j++){
                int day = sc.nextInt();
                mask = mask | (1<<day);
            }
            masks[i] = mask;
            //System.out.println(mask);
        }


        // max_days is the max value of common days
        int max_days = 0;
        int worker_1 = -1;
        int worker_2 = -1;
        // to find intersection btw ith and jth worker
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int intersection = masks[i] & masks[j];
                // to check which bit is set in intersection
                int common_days = 0;
                for(int k=0; k<32; k++){
                    // checking if kth bit is set or not in intersection
                    if((intersection & (1<<k)) != 0) common_days++;
                }
                //System.out.println("i " + i + " j " + j + " common_days " + common_days);
                if(common_days > max_days){
                    max_days = common_days;
                    worker_1 = i;
                    worker_2 = j;
                } 

            }
        }

        System.out.println("worker 1: " + worker_1 + " worker 2: " + worker_2 + " max days: " + max_days);


	}
}


// input: 
//5
// 4
// 1 4 7 9
// 6
// 2 9 1 7 25 29
// 7
// 1 23 4 7 9 11 29
// 10
// 2 28 8 7 9 10 30 21 18 19
// 4
// 1 11 29 7

// there are 5 workers, who work from days 1 to 30.
// first worker works for 4 days: 1st day, 4th day 7th day, 9th day
// same for rest
// find two workers such that they have maximum common working days
