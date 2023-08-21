package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.dto.RedisEntityRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    public void put(RedisEntityRequestDto redisEntityRequestDto){
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        stringValueOperations.set(redisEntityRequestDto.getId(), redisEntityRequestDto.getNickname());
    }

    public String get(String id){
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        String result = stringValueOperations.get(id);
        return result;
    }

}
