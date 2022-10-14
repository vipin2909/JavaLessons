import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static StringTokenizer tok;
    static BufferedReader br;
    static PrintWriter out;


    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }

    public static String next() throws IOException {
        while(tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(br.readLine());
        }
        return tok.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static int upperBound(int[] arr, int key) {
        int mid, N = arr.length;
        int low = 0;
        int high = N;
        while(low < high && low != N) {
            mid = low+(high-low)/2;
            if(key >= arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        if(low == N) {
            return N-1;
        }
        return low;
    }
    public static void solve() throws IOException {

       int t = nextInt();
       while(t-- > 0) {
           int n = nextInt();
           long[] pref = new long[n+1];
           pref[0] = 0;
           int[] prefmax = new int[n];
           int index = 1;
           int q = nextInt();
           int prefIndex = 0;
           for(int i = 0; i < n; i++) {
               int x = nextInt();
               pref[index] = pref[index-1]+x;
               if(i == 0) {
                   pref[prefIndex++] = x;
               }
               else {
                   prefmax[prefIndex] = Math.max(prefmax[prefIndex-1], x);
                   prefIndex++;
               }
           }
           for(int i = 0; i < q; i++) {
               int k = nextInt();
               int ind = upperBound(prefmax, k);
               System.out.print(pref[ind] + " ");

           }
           System.out.println();
       }
    }

    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            br.close();
            out.close();

        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}