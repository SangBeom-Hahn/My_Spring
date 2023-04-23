package hello.login.web.login;

import hello.login.domain.login.LoginService;
import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import hello.login.web.login.form.LoginForm;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm form) {
        return "login/loginForm";
    }
    
//    @PostMapping("/login")
//    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response) {
//        // 필드 에러
//        if(bindingResult.hasErrors()) {
//            return "login/loginForm";
//        }
//
//        // 핵심 비즈니스 에러
//        Member login = loginService.login(form.getLoginId(), form.getPassword());
//        if(login == null) {
//            bindingResult.reject("loginFail", "아이디 또는 비번이 맞지 않음");
//            return "login/loginForm";
//        }
//
//        // 로그인 성공 처리
//        Cookie cookie = new Cookie("memberId", String.valueOf(login.getId()));
//        response.addCookie(cookie);
//
//        return "redirect:/";
//    }

//    @PostMapping("/login")
//    public String login2(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response) {
//        // 필드 에러
//        if(bindingResult.hasErrors()) {
//            return "login/loginForm";
//        }
//
//        // 핵심 비즈니스 에러
//        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
//        if(loginMember == null) {
//            bindingResult.reject("loginFail", "아이디 또는 비번이 맞지 않음");
//            return "login/loginForm";
//        }
//
//        // 로그인 성공 처리
////        Cookie cookie = new Cookie("memberId", String.valueOf(login.getId()));
////        response.addCookie(cookie);
//
//        sessionManager.createSession(loginMember, response);
//        /**
//         *     public void createSession(Object value, HttpServletResponse response) {
//         *         String sessionId = UUID.randomUUID().toString();
//         *         sessionStore.put(sessionId, value);
//         *
//         *         Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
//         *         response.addCookie(mySessionCookie);
//         *     }
//         */
//
//        return "redirect:/";
//    }

    @PostMapping("/login")
    public String login3(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
        // 필드 에러
        if(bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        // 핵심 비즈니스 에러
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        if(loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비번이 맞지 않음");
            return "login/loginForm";
        }

        // 이전
//        sessionManager.createSession(loginMember, request);

        // 이후
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return "redirect:/";
    }


//    @PostMapping("/logout")
//    public String logout(HttpServletResponse response) {
//        Cookie cookie = new Cookie("memberId", null);
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
//        return "redirect:/";
//    }

//    @PostMapping("/logout")
//    public String logout2(HttpServletRequest request) {
////        Cookie cookie = new Cookie("memberId", null);
////        cookie.setMaxAge(0);
////        response.addCookie(cookie);
//
//        sessionManager.expire(request);
//
//        /**
//         *         Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
//         *         if(sessionCookie != null) {
//         *             sessionStore.remove(sessionCookie.getValue());
//         *         }
//         */
//        return "redirect:/";
//    }

    @PostMapping("/logout")
    public String logout3(HttpServletRequest request) {
        // 이전
        sessionManager.expire(request);

        // 이후
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
