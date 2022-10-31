package onboarding.problem7;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserServiceTest {

    @Test
    void 추천점수가_높은_상위5명을_조회합니다() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        var userService = new UserService(
                new UserRepository(
                        user,
                        friends,
                        visitors
                )
        );
        List<String> result = List.of("andole","jun", "bedi");
        var actual = userService.findHighestRecommendationByUsernameLimitN(user, 5);

        Assertions.assertThat(actual).isEqualTo(result);
    }

    @Test
    void 추천할_친구가_없는_경우_아무도_반환하지_않습니다(){
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "bedi"),
                List.of("mrko", "donut"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        var userService = new UserService(
                new UserRepository(
                        user,
                        friends,
                        visitors
                )
        );
        List<String> result = List.of();
        var actual = userService.findHighestRecommendationByUsernameLimitN(user, 5);

        Assertions.assertThat(actual).isEqualTo(result);
    }

    @Test
    void 동일한_점수를_가진_경우라면_이름순으로_정렬되어야합니다(){
        String user = "a";
        List<List<String>> friends = List.of(
                List.of("a", "b"),
                List.of("b", "b1"),
                List.of("b", "b2"),
                List.of("b", "b0"),
                List.of("b", "b10"),
                List.of("b", "b11"),
                List.of("b", "b12")

        );
        List<String> visitors = List.of();
        var userService = new UserService(
                new UserRepository(
                        user,
                        friends,
                        visitors
                )
        );
        List<String> result = List.of("b0","b1","b10","b11","b12");
        var actual = userService.findHighestRecommendationByUsernameLimitN(user, 5);

        Assertions.assertThat(actual).isEqualTo(result);
    }

    @Test
    void 케이스1(){
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko","andole"),
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        var userService = new UserService(
                new UserRepository(
                        user,
                        friends,
                        visitors
                )
        );
        List<String> result = List.of("jun", "bedi");
        var actual = userService.findHighestRecommendationByUsernameLimitN(user, 5);

        Assertions.assertThat(actual).isEqualTo(result);
    }

/*
    @Test
    void 성능테스트(){
        String user = "mrko";

        var friend = List.of(
                List.of("mrko","andole"),
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<List<String>> friends = new ArrayList<>();

        for(int i = 0; i < 10000;i++){
            friends.add(List.of(RandomString.make(), RandomString.make()  ));
        }

        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        var userService = new UserService(
                new UserRepository(
                        user,
                        friends,
                        visitors
                )
        );
        List<String> result = List.of("jun", "bedi");
        var actual = userService.findHighestRecommendationByUsernameLimitN(user, 5);
    }*/
}