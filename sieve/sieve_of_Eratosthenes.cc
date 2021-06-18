#include <cstdio>

const int MAXN = 10000010;

bool isPrime[MAXN];

void sieve_of_Eratosthenes(int n) {
  isPrime[0] = isPrime[1] = true;
  
  for (int i = 2; i <= n; ++i)
    if (!isPrime[i])
      for (int j = i << 1; j <= n; j += i)
        isPrime[j] = true;
}

int main() {
  int n;
  
  scanf("%d", &n);
  sieve_of_Eratosthenes(n);

  for (int i = 2; i <= n; ++i) {
    if (!isPrime[i])
      printf("%d ", i);
  }
}
