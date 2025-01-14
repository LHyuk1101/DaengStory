package com.crud.first.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
  private final MemberRepository memberRepository;
  private final MemberService memberService;

  @GetMapping("/register")
  public String register() {
    return "member/register.html";
  }

  @PostMapping("/member")
  public String addMember(MemberDto memberDto) {
      memberService.saveMember(memberDto);
    return "redirect:/";
  }

  @GetMapping("/login")
  public String login() {
    return "home.html";
  }

  @GetMapping("/my-page") //권한 확인 페이지
  public String myPage(Authentication auth) {
    CustomUser customUser = (CustomUser) auth.getPrincipal();
    System.out.println(customUser.getDisplayName());
    return "member/mypage.html";
  }


}
