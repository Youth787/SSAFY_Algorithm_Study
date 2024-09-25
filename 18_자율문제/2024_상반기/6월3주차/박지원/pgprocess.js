//프로그래머스 프로세스 자바스크립트
//문제가 너무 어려웠따...

function findPrintOrder(priorities, location) {
  let count = 0; // 처리된 프로세스 수
  let maxPriority = Math.max(...priorities); // 최대 우선순위
 
  while (true) {
    const currentProcess = priorities.shift(); // 대기중인 프로세스를 큐에서 꺼냄
 
    if (currentProcess === maxPriority) {
      count++; // 프로세스 실행
      if (location === 0) return count; // 찾고자 하는 프로세스일 경우 결과 반환
      maxPriority = Math.max(...priorities); // 최대 우선순위 갱신
    } else {
      priorities.push(currentProcess); // 큐에 다시 넣음
    }
 
    location = location === 0 ? priorities.length - 1 : location - 1; // 위치 조정
  }
}
