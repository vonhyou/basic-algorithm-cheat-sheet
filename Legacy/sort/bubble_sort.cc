#include <cstdio>

const int MAXN = 1001;

void swap(int *x, int *y) {
  *x ^= *y;
  *y ^= *x;
  *x ^= *y;
}

void bubble_sort(int len, int *data) {
  for (int i = 0; i < len; ++i)
    for (int j = i + 1; j < len; ++j)
      if (data[i] > data[j])
        swap(&data[i], &data[j]);
}

int main() {
  int n;
  scanf("%d", &n);

  // Input data
  int data[MAXN];
  for (int i = 0; i < n; ++i)
    scanf("%d", &data[i]);

  // Sort data
  bubble_sort(n, data);

  // Print result
  for (int i = 0; i < n; ++i)
    printf("%d ", data[i]);
  printf("\n");

  return 0;
}
