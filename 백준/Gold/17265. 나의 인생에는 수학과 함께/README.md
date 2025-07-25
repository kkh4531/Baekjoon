# [Gold V] 나의 인생에는 수학과 함께 - 17265 

[문제 링크](https://www.acmicpc.net/problem/17265) 

### 성능 요약

메모리: 14220 KB, 시간: 132 ms

### 분류

그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 깊이 우선 탐색, 격자 그래프

### 제출 일자

2025년 7월 17일 00:17:37

### 문제 설명

<p>세현이의 인생의 목표는 1분 1초 모든 순간 수학과 함께 살아가는 것이다. 그렇기 때문에 매일 수학을 생각하면서 살아가고 있다. 세현이는 밥을 먹을 때도 쌀알의 수를 계산하여 칼로리를 바로 계산하고 한걸음 한걸음 보폭을 계산하여 자신의 활동량을 확인하며 인생의 목표를 실행하며 살아가고 있다.  그런 세현이는 매일 학교를 가면서 지나가는 길에도 수학을 적용시키고 싶었다.</p>

<p>세현이네 집에서 학교까지 가는 길은 <em>N</em> x <em>N </em>크기의 바둑판과 같다. 그리고 각 블록은 1x1 정사각형으로 구분 지을 수 있다. 세현이는 그 블록마다 숫자와 연산자가 존재한다고 생각해서 임의의 숫자와 연산자를 각 블록에 넣어 바둑판을 만들었다.</p>

<p>세현이는 학교에서 집으로 가는 경로에서 만나는 숫자와 연산자의 연산 결과의 최댓값과 최솟값을 구하려고 한다. 세현이는 항상 자신의 집 (1, 1)에서 학교 (N, N)까지 최단거리로 이동한다. 최단거리로 이동하기 위해서는 오른쪽과 아래쪽으로만 이동해야 한다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/52b1ed3b-b434-4cb7-b532-ce8658764c08/-/preview/" style="height: 298px; width: 600px;"></p>

<p>위와 같이 N = 5 인 5 x 5 바둑판을 만들었다고 해보자.<img alt="" src="https://www.acmicpc.net/problem/%EB%B0%94%ED%83%95%ED%99%94%EB%A9%B4/%EC%BA%A1%EC%B2%982.jpg"></p>

<p>그림 1의 경로를 통해 집(1, 1)에서 학교(N, N)까지 어떻게 연산이 되는지 확인해보자. 경로에서 만나는 연산자들의 우선순위는 고려하지 않는다.</p>

<ol>
	<li> 5 → × → 4 = 20</li>
	<li> 20 → + → 5 = 25</li>
	<li> 25 → ×→ 5 = 125</li>
	<li> 125 → + → 2 = 127</li>
</ol>

<p>그림 1은 최댓값을 가지는 경로이며 127이라는 최댓값을 얻을 수 있다.</p>

<p>그리고 위와 같이 연산하여 그림 2의 경로를 통해서 최솟값으로 3을 얻을 수 있다.</p>

<p>세현이는 이 길을 걸으면서 최댓값과 최솟값을 암산하다가 교통사고를 당해 현재 인하대학교 병원에 입원했다. 아픈 세현이를 위해 최댓값과 최솟값을 구해주자.</p>

### 입력 

 <p>첫 번째 줄에는 지도의 크기 <em>N</em>이 주어진다. (<em>3 ≤ N ≤ 5</em>, <em>N</em>은 홀수) </p>

<p>그 다음 N 줄에는 N개의 숫자 또는 연산자가 빈칸을 사이에 두고 주어지며, 세현이네 집 (1, 1)과 학교 (N, N)는 반드시 숫자로 주어진다.</p>

<p>그리고 숫자 다음에는 연산자, 연산자 다음에는 숫자가 나오도록 주어진다. 주어지는 숫자는 0이상 5이하의 정수, 연산자는 <em>(‘+’, ‘-’, ‘*’) </em>만 주어진다.</p>

### 출력 

 <p>연산 결과의 최댓값과 최솟값을 하나의 공백을 두고 출력한다. 연산자 우선순위는 고려하지 않는다.</p>

