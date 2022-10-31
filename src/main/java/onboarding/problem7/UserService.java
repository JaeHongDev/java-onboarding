package onboarding.problem7;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> findHighestRecommendationByUsernameLimitN(String username, int limit) {
        var user = userRepository.findByName(username);
        return userRepository.findAll()
                             .stream()
                             .filter(user::isNotMeAndFriend)
                             .sorted()
                             .limit(limit)
                             .map(User::name)
                             .collect(Collectors.toList());


    }
}
