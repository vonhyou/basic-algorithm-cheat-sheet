#include <cstdio>

const int MAXN = 10000010;

bool isPrime[MAXN];

void sieve_of_Sundaram(int n) {
  isPrime[0] = true;
  for (int i = 1; i <= n; ++i) {
    int upto = (n - i) / (i << 1 | 1);
    for (int j = 1; j <= upto; ++j)
      isPrime[i + j + (i * j << 1)] = 1;
  }
}

int main() {
  int n;

  scanf("%d", &n);
  sieve_of_Sundaram(n);

  for (int i = 2; i <= n; ++i) {
    if (i & 1 && !isPrime[i >> 1])
      printf("%d ", i);
  }
}
