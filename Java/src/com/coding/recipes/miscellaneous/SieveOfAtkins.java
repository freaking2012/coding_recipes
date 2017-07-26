package com.coding.recipes.miscellaneous;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by shubham on 7/26/17.
 */
public class SieveOfAtkins {

    public void printPrimesWithinLimit(long limit) {

        System.out.println("Primes in range: (1," + limit + ") are:");
        if (2 < limit) {
            System.out.println(2);
        }
        if (3 < limit) {
            System.out.println(3);
        }

        boolean sieve[] = new boolean[(int) limit + 1];

        //for all pairs of (x,y) if any of the 3 equations & condition is satisfied, set the value of the equation (n) as true in the sieve
        for (long x = 1; x * x < limit; x++) {
            for (long y = 1; y * y < limit; y++) {
                long n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    sieve[(int) n] = true;

                n = (3 * x * x) + (y * y);
                if (n <= limit && n % 12 == 7)
                    sieve[(int) n] = true;

                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && n % 12 == 11)
                    sieve[(int) n] = true;
            }
        }

        //set false those true values which are MULTIPLES of a Perfect Square
        for (long k = 5; k * k < limit; k++) {
            if (sieve[(int) k]) {
                for (long j = k * k; j < limit; j += k * k)
                    sieve[(int) j] = false;
            }
        }

        for (long a = 5; a < limit; a++) {
            if (sieve[(int) a]) {
                System.out.println(a);
            }
        }


    }
}

class SieveDriver {
    public static void main(String[] args) throws IOException {
        SieveOfAtkins obj = new SieveOfAtkins();
        Reader s = new Reader();

        long t = s.nextLong();

        while (t-- > 0) {
            long limit = s.nextLong();
            obj.printPrimesWithinLimit(limit);
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}