package kr.ac.phdljr.springbootjpaquerydsl.controller;

import kr.ac.phdljr.springbootjpaquerydsl.dto.RedisEntityRequestDto;
import kr.ac.phdljr.springbootjpaquerydsl.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class RedisController {
    private final RedisService redisService;

    @GetMapping("/entity/{id}")
    public ResponseEntity<String> getRedisEntity(@PathVariable String id) {
        String result = redisService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/entity")
    public ResponseEntity<String> setRedisEntity(@RequestBody RedisEntityRequestDto redisEntityRequestDto) {
        redisService.put(redisEntityRequestDto);
        return ResponseEntity.ok().build();
    }
}
