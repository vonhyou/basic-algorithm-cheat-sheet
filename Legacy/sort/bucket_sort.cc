#include <cstdio>

const int INTMAX = 10010;

int bucket[INTMAX];
void bucket_sort(int n) {
  for (int i = 0; i < n; ++i) {
    int temp;
    scanf("%d", &temp);
    ++bucket[temp];
  }
}

void print_n_times(int num) {
  for (int i = 0; i < bucket[num]; ++i)
    printf("%d ", num);
}

int main() {
  int n;
  scanf("%d", &n);
  bucket_sort(n);
  
  // Print result
  for (int i = 0; i < INTMAX; ++i) 
    print_n_times(i);
  printf("\n");
  return 0;
}
