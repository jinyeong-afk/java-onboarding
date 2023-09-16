package onboarding;

import java.util.List;

/**
 * 예외 상황
 * 1. 오른쪽은 짝수, 왼쪽은 홀수가 아닌 경우
 * 2. 두 페이지의 번호차이가 1이 아닌경우
 * 3. 페이지 번호가 1~400이 아닌 경우
 * # 제한사항에 pobi와 crong의 길이는 2라고 나와있으므로 이 유효성 검사는 제외
 */
class Problem1 {
    // 상수 초기화
    private final static int exceptionNum = -1;
    private final static int drawNum = 0;
    private final static int pobiNum =1;
    private final static int crongNum=2;

    // 포비와 크롱의 책 번호 리스트가 주어짐
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //예외상황 검사 코드 작성
        if (NotEvenAndOdd(pobi) && NotEvenAndOdd(crong)) {
            return exceptionNum;
        }
        if(NotDiffIsOne(pobi) && NotDiffIsOne(crong)){
            return exceptionNum;
        }
        if(NotInPageRange(pobi) && NotInPageRange(crong)){
            return exceptionNum;
        }

        //로직 작성
        int pobiScore =0;
        int crongScore=0;

        //점수 구하기
        pobiScore = calcScore(pobi);
        crongScore = calcScore(crong);

        //누가 이겼는지 구하기
        answer = findWinner(pobiScore,crongScore);

        return answer;
    }

    public static boolean NotEvenAndOdd(List<Integer> list){
        return list.get(0) % 2 == 0 || list.get(1) % 2 != 0;
    }
    public static boolean NotDiffIsOne(List<Integer> list){
        return list.get(1) - list.get(0) != 1;
    }
    public static boolean NotInPageRange(List<Integer> list){
        Integer startPage = list.get(0);
        Integer endPage = list.get(1);
        return (startPage <= 0 || startPage > 400) || (endPage <= 0 || endPage > 400);
    }
    public static int calcScore(List<Integer> list){
        //더하기랑 곱하기 점수 구하기
        int plus = getPlus(list);
        int multiple = getMultiple(list);

        return Math.max(plus,multiple);
    }
    public static int getPlus(List<Integer> list){
        int res = 0;
        for(Integer a:list){
            int sum=0;
            while(a!=0){
                sum+= a%10;
                a/=10;
            }
            if(sum > res) res = sum;
        }
        return res;
    }
    public static int getMultiple(List<Integer> list){
        int res = 0;
        for(Integer a:list){
            int sum=1;
            while(a!=0){
                sum*= a%10;
                a/=10;
            }
            if(sum > res) res = sum;
        }
        return res;
    }
    public static int findWinner(int pobiScore, int crongScore){
        if(pobiScore > crongScore) return pobiNum;
        else if(pobiScore < crongScore) return crongNum;
        else return drawNum;
    }
}