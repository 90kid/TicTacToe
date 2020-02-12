package io.games.simple.webapp.dto;

import io.games.simple.webapp.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserToLeaderboardDto {
    private String login;
    private int winNumber;
    private int loseNumber;
    private int gamePlayed;

    public static UserToLeaderboardDto from(UserEntity userEntity){
        return UserToLeaderboardDto.builder()
                .login(userEntity.getLogin())
                .loseNumber(userEntity.getLoseNumber())
                .winNumber(userEntity.getWinNumber())
                .gamePlayed(userEntity.getNumberOfPlayedGame())
                .build();
    }

    public static List<UserToLeaderboardDto> from(List<UserEntity> userEntityList){
        return userEntityList.stream().map(UserToLeaderboardDto::from).collect(Collectors.toList());
    }
}
