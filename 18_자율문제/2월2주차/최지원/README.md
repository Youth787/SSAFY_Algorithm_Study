## 📚 자율 문제

순서대로 푸는게 좋아요.

필수로 풀어야하는 문제는 (✅ 체크표시) 했습니다.

<br/>
<table>
  <tr>
    <td align="center">순서</td>
    <td align="center">필수 문제</td>
    <td align="center">난이도</td>
    <td align="center">문제 번호</td>
    <td align="center">문제 이름</td>
    <td align="center">문제 링크</td>
  </tr>
  <tr>
    <td align="center">01</td>
    <td align="center">✅</td>
    <td align="center"><img height="23px" width="25px" src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg"></td>
    <td align="center">15649</td>
    <td align="center">N과M(1)</td>
    <td align="center"><a href="https://www.acmicpc.net/problem/15649">바로가기</a></td>
  </tr>
    <tr>
    <td align="center">02</td>
    <td align="center">✅</td>
    <td align="center"><img height="23px" width="25px" src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg"></td>
    <td align="center">15650</td>
    <td align="center">N과M(2)</td>
    <td align="center"><a href="https://www.acmicpc.net/problem/15650">바로가기</a></td>
  </tr>
  <tr>
    <td align="center">03</td>
    <td align="center">✅</td>
    <td align="center"><img height="23px" width="25px" src="https://d2gd6pc034wcta.cloudfront.net/tier/9.svg"></td>
     <td align="center">6603</td>
    <td align="center">로또</td>
    <td align="center"><a href="https://www.acmicpc.net/problem/6603">바로가기</a></td>
  </tr>
    <tr>
    <td align="center">04</td>
    <td align="center">✅</td>
    <td align="center"><img height="23px" width="25px" src="https://d2gd6pc034wcta.cloudfront.net/tier/10.svg"></td>
    <td align="center">14888</td>
    <td align="center">연산자 끼워넣기</td>
    <td align="center"><a href="https://www.acmicpc.net/problem/14888">바로가기</a></td>
  </tr>
  <tr>
    <td align="center">05</td>
    <td align="center">✅</td>
    <td align="center"><img height="23px" width="25px" src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg"></td>
    <td align="center">1759</td>
    <td align="center">암호 만들기</td>
    <td align="center"><a href="https://www.acmicpc.net/problem/1759">바로가기</a></td>
  </tr>
</table>
<br/><br/>

### 백트래킹
여러 선택지가 존재하는 상황에서 한가지를 선택->새로운 선택지들의 집합이 생성->반복하면 최종상태 도달   
  
아닌 것 같으면 다음 꺼 실행하지 않아 = 백트래킹(불필요한 경로 조기 차단)  
아닐 수 있어도 다시 가봐 = 깊이 우선 탐색(완전탐색의 일종)  
유망성 검사 후 그 경로를 줄여서 시도 횟수를 줄임 = 가지치기  
  
  
*(당첨 리프 노드 찾기)  
루트에서 갈 수 있는 노드 선택, 최근 선택으로 되돌아와서 (깊이 우선 탐색)...*  
  
모든 후보를 검사x, 어떤 노드의 유방성 검사 후 아니다 결정 시 부모 노드로 돌아가 다음 자식 노드로 감.  
그 노드를 포함한 경로가 해답이 될 수 없다 = 유망하지 않다  
유망하지 않는 노드가 포함되는 경로는 더 이상 고려하지 않음 = 가지치기  
  
절차 = 상태 공간 트리의 깊이 우선 검색 > 각 노드 유망한지 점검 > 유망하지 않으면 부모로 가서 검색 계속  
  
0,0에 넣고 재귀호출 > 유망성 검사했는데 1,0이 안된다 = 재귀 호출 안함 / 유망하다 = 재귀호출  
