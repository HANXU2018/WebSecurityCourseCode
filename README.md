

# 实验二 ✨非对称加密和解密 实验代码

### 生成公私秘钥对，对文本框内容进行RSA加密和解密。

web安全实验课代码


![前端效果展示](https://i.loli.net/2020/05/09/5xXip7VdZh4snlU.png)
- RSA加密解密算法 工具类 [🔗链接](https://www.cnblogs.com/pcheng/p/9629621.html)
- 课程代码使用 Java springboot 进行后台 逻辑交互 VUE +elementUI 框架进行前端页面展示
- 后端使用8080端口 运行\web1\src\main\java\com\safe\web1\Web1Application.java 启动后台项目
- 前端 准备 
  - npm install 安装npm开发环境
  - npm install axios 按照Axios， Axios 是一个基于 promise 的 HTTP 库 进行前后端交互
  - npm i element-ui -S 安装 elementUI 前端组件库
  - npm run dev 运行环境
  - npm build 进行打包

# 实验三 利用session **进行页面访问控制**

### 引入session编写登录界面 对页面进行访问权限控制

![登录页面.png](https://i.loli.net/2020/05/16/oLPeWONUQqyTRSd.png)



![登录成功.png](https://i.loli.net/2020/05/16/Fomg7LwETxY5X2s.png)

### 登录页面引入session

```
package com.safe.web1.Controller;

import com.safe.web1.pojo.User;
import com.safe.web1.result.Result;
import com.safe.web1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}

```


### 对页面进行过滤

```java
package com.safe.web1.interceptor;

import com.safe.web1.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor  implements HandlerInterceptor{

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String contextPath=session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };

        String uri = httpServletRequest.getRequestURI();

        uri = StringUtils.remove(uri, contextPath+"/");
        String page = uri;

        if(begingWith(page, requireAuthPages)){
            User user = (User) session.getAttribute("user");
            if(user==null) {
                httpServletResponse.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if(StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}


```

### 配置使用过滤
```
package com.safe.web1.config;

import com.safe.web1.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }
}


```

├─src

│  ├─main

│  │  ├─java

│  │  │  └─com

│  │  │      └─safe

│  │  │          └─web1

│  │  │              ├─Controller 前后端 交互逻辑代码

│  │  │              ├─pojo 存储输入数据的实体类

│  │  │              └─utils RSA加密工具类

│  │  └─resources

│  │      ├─static

│  │      └─templates

│  └─test

│      └─java

│          └─com

│              └─safe

│                  └─web1


联系方式 

- 📧1076998404@qq.com
- 🎉[博客链接](https://hanxu.blog.csdn.net/)
- 🎉[github链接](https://github.com/HANXU2018)
