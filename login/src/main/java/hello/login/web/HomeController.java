package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }

//    @GetMapping("/")
//    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
//        // 로그인을 하지 않은 사용자
//        if(memberId == null) {
//            return "home";
//        }
//
//        // 로그인한 사용자
//        Member loginMember = memberRepository.findById(memberId);
//
//        // 너무 오래된 쿠키
//        if(loginMember == null) {
//            return "home";
//        }
//
//        model.addAttribute("member", loginMember);
//        return "loginHome";
//    }

//    @GetMapping("/")
//    public String homeLogin2(HttpServletRequest request, Model model) {
//
//        /* 사라지는 로직
//        // 로그인을 하지 않은 사용자
//        if(memberId == null) {
//            return "home";
//        }
//
//        // 로그인한 사용자
//        Member loginMember = memberRepository.findById(memberId);
//        */
//
//        Member member = (Member)sessionManager.getSession(request);
//
//        // 너무 오래된 쿠키
//        if(member == null) {
//            return "home";
//        }
//
//        model.addAttribute("member", member);
//        return "loginHome";
//    }

//    @GetMapping("/")
//    public String homeLogin3(HttpServletRequest request, Model model) {
//        // 이후
//        HttpSession session = request.getSession(false);
//        if(session == null) {
//            return "home";
//        }
//
//        Member loingMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
//
//        // 너무 오래된 쿠키
//        if(loingMember == null) {
//            return "home";
//        }
//
//        model.addAttribute("member", loingMember);
//        return "loginHome";
//    }

    @GetMapping("/")
    public String homeLogin4(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember
            , Model model) {
        /** 삭제될 지저분한 코드
         * HttpSession session = request.getSession(false);
         *         if(session == null) {
         *             return "home";
         *         }
         *
         *         Member loingMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
         */

        // 로그인 안한 사용자
        if(loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}