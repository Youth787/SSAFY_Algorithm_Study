//프로그래머스 택배상자 JavaScript
//stack 써서 쉽게 풀었는데, at(-1)에대해 배웠따

function solution(order) {
  let result = 0;
  const stack = [];

  for (let i = 1; i <= order.length; i++) {
    stack.push(i);

    // 스택의 상자 번호가 주어진 순서와 일치하는지 확인
    while (stack.length !== 0 && stack.at(-1) === order[result]) {
      stack.pop(); // 일치하는 상자 번호는 스택에서 제거
      result++;
    }
  }

  return result;
}
