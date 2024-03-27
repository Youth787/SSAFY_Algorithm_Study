//자바로 풀면 pq사용해서 정말 간단하게 풀수있지만
//자스에는 pq같은건 없다. 직접 구현해야 한다...
//아래 class MinHeap은 pq를 직접 구현한 클래스이다
//https://mingmeng030.tistory.com/293
//위의 블로그에서 참 좋은 문제들이 많아서 많이 참조중

class MinHeap {
    constructor() {
        this.heap = [];
    }
    size() { return this.heap.length;}
    peek() { return this.heap[0];}
    push(value) {
        this.heap.push(value);
        let index = this.heap.length - 1;
        //오름차순 정렬
        while(
            index > 0 && this.heap[index] < this.heap[Math.floor((index - 1) / 2)]
        ) {
            //Math.floor((index - 1) / 2) 는 index의 부모 노드
            const temp = this.heap[index];
            this.heap[index]  = this.heap[Math.floor((index - 1)/ 2)];
            this.heap[Math.floor((index - 1)/2)] = temp;
            index = Math.floor((index - 1)/2);
        }
    }
    //값을 빼고 오름차순 정렬
    pop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();
        
        const minValue = this.heap[0];
        this.heap[0] = this.heap.pop();
        let index = 0;
        
        while (index * 2 + 1 < this.heap.length) {
            let minChildIndex = (index * 2 + 2 < this.heap.length && this.heap[index * 2 + 2] < this.heap[index * 2 + 1]) ? index * 2 + 2 : index * 2 + 1;
            
            if (this.heap[index] < this.heap[minChildIndex]) {
                break;
            }
            
            const temp = this.heap[index];
            this.heap[index] = this.heap[minChildIndex];
            this.heap[minChildIndex] = temp;
            index = minChildIndex;
        }
        return minValue;
    }
}

function solution(scoville, K) {
    const minHeap = new MinHeap();
    
    for (const sco of scoville) {
        minHeap.push(sco);
    }
    let mixedCount = 0;
    
    //힙 안에 음식이 2개 이상 있고, 스코빌 지수가 가장 작은 음식의 수치가
    //K보다 작을 때 까지 반복하기
    while (minHeap.size() >= 2 && minHeap.peek() < K) {
        //스코빌 지수 낮은 두 음식 섞기
        const first = minHeap.pop();
        const second = minHeap.pop();
        const mixedFood = first + second * 2;
        minHeap.push(mixedFood);
        mixedCount++;
    }
    return minHeap.peek() >= K ? mixedCount : -1;
}
