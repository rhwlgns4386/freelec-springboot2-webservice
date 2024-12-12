package com.jojoldu.book.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

public class ProfileControllerUnitTest {

    @Test
    public void real_profile이_죄회된다(){
        String expectedProfile="real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController profileController = new ProfileController(env);

        assertThat(profileController.profile()).isEqualTo(expectedProfile);
    }

    @Test
    public void real_profile이_없으면_첫_번째가_조회된다(){
        String expectedProfile="oauth";

        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController profileController = new ProfileController(env);

        assertThat(profileController.profile()).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile이_없으면_default_조회된다(){
        String expectedProfile="default";

        MockEnvironment env = new MockEnvironment();

        ProfileController profileController = new ProfileController(env);

        assertThat(profileController.profile()).isEqualTo(expectedProfile);
    }
}
