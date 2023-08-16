package kr.ac.phdljr.springbootjpaquerydsl;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

@Slf4j
public class JasyptTest {
    @Test
    public void jasyptEncoding(){
        String value = "admin";
        String key = "h0yUWA8s+j6mK3bjMrpVQoZUge3mbd7n62m1pccidBYctq0Zn8w3zGQk0D+MNPWB";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);

        String enc = pbeEnc.encrypt(value);

        System.out.println(enc);
    }
}
