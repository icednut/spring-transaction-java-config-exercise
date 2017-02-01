package io.icednut.exercise.api;

import io.icednut.exercise.api.support.UserDto;
import io.icednut.exercise.api.support.UserResponse;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void test_get_users() throws Exception {
        HttpEntity<?> requestEntity = null;
        ResponseEntity<UserResponse<List<UserDto>>> responseEntity = restTemplate.exchange("/user", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<UserResponse<List<UserDto>>>() {
        });

        UserResponse<List<UserDto>> body = responseEntity.getBody();
        assertThat(CollectionUtils.isEmpty(body.getUsers()), Is.is(false));
    }
}
