package kr.codelabs.member.controller;

import kr.codelabs.member.entity.Member;
import kr.codelabs.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<?> getAllMembers() {
        List<Member> members = memberService.getAllMembers();

        return ResponseEntity.ok(members);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<?> getMember(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);

        return ResponseEntity.ok(member);
    }
}
