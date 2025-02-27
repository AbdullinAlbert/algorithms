class Solution {
    public int maxLength(int[] nums) {
        int maxLength = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int product = 1;
                int gcd = nums[i];
                int[] primeNumbers = new int[8];
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                    gcd = gcd(gcd, nums[k]);
                    if (nums[k] == 1) continue;
                    int[] hPrimeNumbers = new int[8];
                    int h = nums[k];
                    while (h > 1) {
                        if (h % 2 == 0) {
                            h /= 2;
                            hPrimeNumbers[2]++;
                        } else if (h % 3 == 0) {
                            h /= 3;
                            hPrimeNumbers[3]++;
                        } else if (h % 5 == 0) {
                            h /= 5;
                            hPrimeNumbers[5]++;
                        } else if (h % 7 == 0) {
                            h /= 7;
                            hPrimeNumbers[7]++;
                        }
                    }
                    for (h = 2; h < primeNumbers.length; h++) {
                        if (hPrimeNumbers[h] > primeNumbers[h]) {
                            primeNumbers[h] = hPrimeNumbers[h];
                        }
                    }
                }
                int lcm = 1;
                for (int h = 2; h < primeNumbers.length; h++) {
                    if (primeNumbers[h] > 0) lcm *= pow(h, primeNumbers[h]);
                }
                if (lcm * gcd == product) {
                    int currentLength = j - i + 1;
                    if (currentLength > maxLength) maxLength = currentLength;
                }
            }
        }
        return maxLength;
    }

    int pow(int number, int pow) {
        int h = number;
        while (pow > 1) {
            h *= number;
            pow--;
        }
        return h;
    }

    int gcd(int a, int b) {
        if (a % b == 0) return b;
        if (b % a == 0) return a;
        if (a > b) {
            int diff = a - b;
            return gcd(b, diff);
        } else {
            int diff = b - a;
            return gcd(a, diff);
        }
    }

}