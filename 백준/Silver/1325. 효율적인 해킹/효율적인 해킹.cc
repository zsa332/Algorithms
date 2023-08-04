#include <iostream>
#include <vector>
using namespace std;
 
int n,m;
vector<int> map[10001];
bool check[10001];
int res[10001];
 
void initCheckArray() {
    for (int i = 1; i <= n; i++) {
        check[i] = false;
    }
}
 
void dfs(int v) {
    check[v] = true;
    for (auto& vv : map[v]) {
        if (!check[vv]) {
            dfs(vv);
            res[vv]++;
        }
    }
}
 
int main() {
    cin >> n >> m;
 
    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        map[x].push_back(y);
    }
 
    for (int i = 1; i <= n; i++) {
        initCheckArray();
        dfs(i);
    }
 
    int max = 0;
    for (int i = 1; i <= n; i++) {
        if (max < res[i]) {
            max = res[i];
        }
    }
 
    for (int i = 1; i <= n; i++) {
        if (res[i] == max) {
            cout << i << " ";
        }
    }
 
}