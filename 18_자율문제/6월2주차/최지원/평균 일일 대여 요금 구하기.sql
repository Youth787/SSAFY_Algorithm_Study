-- CAR_RENTAL_COMPANY_CAR 테이블에서 
-- 자동차 종류가 'SUV'인 자동차들의 => WHERE
-- 평균 일일 대여 요금을 출력하는 SQL문을 작성해주세요. => AVG()
-- 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림 => ROUND(값, 자릿수)
-- 컬럼명은 AVERAGE_FEE 로 지정해주세요. => AS

SELECT ROUND(AVG(DAILY_FEE),0) AS AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = 'SUV'
