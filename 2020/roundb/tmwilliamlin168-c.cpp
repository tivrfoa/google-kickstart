#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define ar array

const int M=1e9;
string s;
int ptr;

ar<ll, 2> pr() {
	ar<ll, 2> r={0, 0};
	while(1) {
		if(ptr>=s.size())
			break;
		if(s[ptr]==')') {
			break;
		}
		if(s[ptr]=='N') {
			--r[1];
			if(r[1]<0)
				r[1]+=M;
		}
		else if(s[ptr]=='S') {
			++r[1];
			if(r[1]>=M)
				r[1]-=M;
		}
		else if(s[ptr]=='E') {
			++r[0];
			if(r[0]>=M)
				r[0]-=M;
		}
		else if(s[ptr]=='W') {
			--r[0];
			if(r[0]<0)
				r[0]+=M;
		} else {
			int d=s[ptr++]-'0';
			++ptr;
			ar<ll, 2> b=pr();
			r[0]=(r[0]+d*b[0])%M;
			r[1]=(r[1]+d*b[1])%M;
		}
		++ptr;
	}
	return r;
}

void solve() {
	cin >> s;
	ptr=0;
	ar<ll, 2> a=pr();
	cout << a[0]+1 << " " << a[1]+1 << "\n";
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int t, i=1;
	cin >> t;
	for(int i=1; i<=t; ++i) {
		cout << "Case #" << i << ": ";
		solve();
	}
}