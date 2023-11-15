package controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasPromotionTest extends NsTest {
    @Test
    @DisplayName("통합 테스트")
    void executeChristmasPromotionTest() {
        assertSimpleTest(() -> {
            run("25", "양송이수프-2,크리스마스파스타-1,아이스크림-2,레드와인-1");
            assertThat(output()).contains(
                    "12월 25월에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",
                    "<주문 메뉴>",
                    "양송이수프 2개",
                    "크리스마스파스타 1개",
                    "아이스크림 2개",
                    "레드와인 1개",
                    "<할인 전 총주문 금액>",
                    "107,000원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -3,400원",
                    "평일 할인: -4,046원",
                    "특별 할인: -1,000원",
                    "<총혜택 금액>",
                    "-8,446원",
                    "<할인 후 예상 결제 금액>",
                    "98,554원",
                    "<12월 이벤트 배지>",
                    "별"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
