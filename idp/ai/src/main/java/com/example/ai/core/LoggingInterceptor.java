package com.example.ai.core;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Component("LoggingInterceptor")
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    private static final String USER_ID = "USER_ID";

    private static final String SESSION_ID = "SESSION_ID";

    // コントローラー実行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Principal user = request.getUserPrincipal();

        String userId = null;

        if (user != null)
            userId = user.getName();

        if (userId != null && "".equals(userId) == false) {
            MDC.put(USER_ID, userId);
        } else {
            MDC.put(USER_ID, "");
        }

        HttpSession session = request.getSession(false);
        if (session != null)
            MDC.put(SESSION_ID, session.getId());

        return true;
    }

    // コントローラー十九後
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        MDC.remove(SESSION_ID);
        MDC.remove(USER_ID);
    }

    // リクエスト処理完了後
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
