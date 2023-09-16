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
        //로직 작성
        return answer;
    }
}