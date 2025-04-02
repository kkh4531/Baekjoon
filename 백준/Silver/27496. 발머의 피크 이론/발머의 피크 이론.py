import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
num = list(map(int, input().split()))
s_num = deque() #혈중 알코올 농도에 관여하는 알코올의 양이 들어갈 큐
al = 0 #혈중 알코올 농도
ans = 0
for i in range(n):
    s_num.append(num[i])
    al += num[i]
    if len(s_num) > m:
        al -= s_num.popleft() #알코올 분해
    if 129 <= al <= 138:
        ans += 1
print(ans)