package com.safe.web1.Controller;

import com.safe.web1.pojo.Input;
import com.safe.web1.utils.TestRSA;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.security.PublicKey;

import static com.safe.web1.utils.TestRSA.*;

@Controller
@RequestMapping("/api")
public class TestDemoController {
    String privateKey;
    String publicKey;
    String data;
    String encryptData;
    @CrossOrigin
    @RequestMapping("/say")
    @ResponseBody
    String testSay(){
        return "testsay";
    }
    @CrossOrigin
    @GetMapping(value = "/test")
    @ResponseBody
    public String test() {
        System.out.println("请求测试");
        return "测试请求";
    }
    @CrossOrigin
    @GetMapping(value = "/newKey")
    @ResponseBody
    public String newKey() throws Exception {
        // 生成密钥对
        KeyPair keyPair = getKeyPair();
        privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
        System.out.println("私钥:" + privateKey);
        System.out.println("公钥:" + publicKey);
        System.out.println("生成密匙");
        return "私钥:" + privateKey +"\n 公钥:" + publicKey;
    }
    @CrossOrigin
    @PostMapping(value = "/RSAen")
    @ResponseBody
    public String RSAen(@RequestBody Input input) throws Exception {
        // RSA加密
        data = input.getInput();
        System.out.println("data=="+data);
        encryptData = encrypt(data, TestRSA.getPublicKey(publicKey));
        System.out.println("加密后内容:" + encryptData);
        System.out.println("RSA加密");
        return encryptData;
    }


    @CrossOrigin
    @PostMapping(value = "/RSAde")
    @ResponseBody
    public String RSAde(@RequestBody Input input) throws Exception{
        encryptData = input.getInput();
        System.out.println("解密前内容"+encryptData);
        String decryptData = decrypt(encryptData, getPrivateKey(privateKey));
        System.out.println("解密后内容:" + decryptData);
        System.out.println("RSA解密");
        return  decryptData;
    }
}
