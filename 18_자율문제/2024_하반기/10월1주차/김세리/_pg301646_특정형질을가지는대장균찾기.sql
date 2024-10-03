# 내 풀이: 이진수로 변환 후 특정 위치에 있는 값들을 조건으로 필터링하여 데이터 검색

# SELECT COUNT(ID) AS COUNT
# FROM ECOLI_DATA
# WHERE SUBSTR(BIN(GENOTYPE),-2,1)=0
#     AND (SUBSTR(BIN(GENOTYPE),-1,1)=1 OR SUBSTR(BIN(GENOTYPE),-3,1)=1);

# 비트 연산자 사용 풀이: 직접적 비트 비교이므로 속도가 더 향상된다
SELECT COUNT(ID) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 0b10) = 0   -- 두 번째 비트가 0인지 확인
  AND ((GENOTYPE & 0b01) = 1   -- 첫 번째 비트가 1이거나
        OR (GENOTYPE & 0b100) = 4); -- 세 번째 비트가 1인지 확인
