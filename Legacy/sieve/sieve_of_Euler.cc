#include <cstdio>

const int MAXN = 10000010;

int prime[MAXN];
bool isPrime[MAXN];

void sieve_of_Euler(int n) {
  isPrime[0] = isPrime[1] = true;

  int pNum = 0;
  int upto = n >> 1 | 1;
  for (int i = 2; i <= upto; ++i) {
    if (!isPrime[i])
      prime[++pNum] = i;
    for (int j = 1; j <= pNum && prime[j] * i <= n; ++j) {
      isPrime[prime[j] * i] = true;
      if (!(i % prime[j]))
        break;
    }
  }
}

int main() {
  int n;

  scanf("%d", &n);
  sieve_of_Euler(n);

  for (int i = 2; i <= n; ++i) {
    if (!isPrime[i])
      printf("%d ", i);
  }
}
